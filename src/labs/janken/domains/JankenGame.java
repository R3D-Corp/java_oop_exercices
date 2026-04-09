package labs.janken.domains;

import labs.janken.domains.events.GameEvent;
import labs.janken.domains.events.GameEventSubscriber;
import labs.janken.domains.events.GameEventType;
import labs.janken.domains.players.BasePlayer;
import util.Contract;

/**
 * TODO: ajouter le rôle (exo 1)
 *
 * <p>Elle notifie un abonné ({@link GameEventSubscriber})
 * des événements du jeu (début/fin de tour, sélection de coup, scores, etc.).</p>
 *
 * <p><strong>Invariants :</strong></p>
 * <ul>
 *   <li>Aucun des joueurs ou de l'abonné ne peut être {@code null}.</li>
 *   <li>Le nombre total de tours est fixe et défini par {@link #TOTAL_TURNS}.</li>
 * </ul>
 *
 */
public final class JankenGame {

    /** Nombre total de tours dans une partie. */
    private static final int TOTAL_TURNS = 3;

    private final BasePlayer first;
    private final BasePlayer second;
    private GameEventSubscriber subscriber;

    /**
     * Construit une nouvelle instance de jeu Janken.
     *
     * @param player1 le premier joueur (ne peut pas être {@code null}).
     * @param player2 le deuxième joueur (ne peut pas être {@code null}).
     * @param subscriber l'abonné aux événements du jeu (ne peut pas être {@code null}).
     * @throws IllegalArgumentException si l'un des arguments est {@code null}.
     */
    public JankenGame(BasePlayer player1, BasePlayer player2, GameEventSubscriber subscriber) {
        Contract.require(player1 != null, "Arg. player1 != null attendu.");
        Contract.require(player2 != null, "Arg. player2 != null attendu.");
        Contract.require(subscriber != null, "Arg. subscriber != null attendu.");

        this.subscriber = subscriber;
        this.first = player1;
        this.second = player2;
    }

    /**
     * Lance et exécute une partie complète.
     *
     * <p>Notifie le début de la partie, puis exécute chaque tour jusqu'à ce que
     * le nombre total de tours soit atteint, avant de conclure la partie.</p>
     */
    public void run() {
        subscriber.onEvent(new GameEvent(GameEventType.GAME_STARTED));

        var currentTurn = 1;
        do {
            notifyEvent(new GameEvent(GameEventType.TURN_STARTED,
                    "Turn", "" + currentTurn,
                    "Total", "" + TOTAL_TURNS));

            playTurn();
            currentTurn++;
        } while (currentTurn <= TOTAL_TURNS);

        concludeGame();
    }

    /**
     * Joue un tour complet : chaque joueur choisit un coup, puis le résultat est déterminé.
     *
     * <p>Notifie les changements de joueur, les coups sélectionnés, et le résultat du tour.</p>
     */
    private void playTurn() {
        notifyEvent(new GameEvent(GameEventType.PLAYER_CHANGED,
                "Player", first.getName()));
        Move firstMove = first.nextMove(Move.valueToList());
        notifyEvent(new GameEvent(GameEventType.MOVE_SELECTED,
                "Player", first.getName(),
                "Move", firstMove.toString()));

        notifyEvent(new GameEvent(GameEventType.PLAYER_CHANGED,
                "Player", second.getName()));
        Move secondMove = second.nextMove(Move.valueToList());
        notifyEvent(new GameEvent(GameEventType.MOVE_SELECTED,
                "Player", second.getName(),
                "Move", secondMove.toString()));

        MoveComparison result = firstMove.versus(secondMove);
        switch (result) {
            case WON -> handleVictory(first, second);
            case LOST -> handleVictory(second, first);
            case DRAW -> handleDrawn();
        }

        first.handleTurnOver(firstMove, secondMove, result);
        second.handleTurnOver(secondMove, firstMove, result.opposite());
    }

    /**
     * Traite une victoire : incrémente le score du gagnant et notifie l'événement.
     *
     * @param winner le joueur gagnant du tour.
     * @param loser le joueur perdant du tour.
     */
    private void handleVictory(BasePlayer winner, BasePlayer loser) {
        notifyEvent(new GameEvent(GameEventType.TURN_OVER,
                "Result", "Victory",
                "Winner", winner.getName(),
                "Loser", loser.getName()));
        winner.raiseScore();
        notifyEvent(new GameEvent(GameEventType.SCORES_CHANGED,
                "Player", winner.getName(),
                "Score", "" + winner.getScore()));
    }

    /**
     * Traite un match nul : notifie l'événement sans modifier les scores.
     */
    private void handleDrawn() {
        notifyEvent(new GameEvent(
                GameEventType.TURN_OVER, "Result", "Draw"));
    }

    /**
     * Conclut la partie en déterminant le gagnant final (ou match nul) et notifie l'événement.
     */
    private void concludeGame() {
        int scoreComparison = first.getScore() - second.getScore();
        if (scoreComparison > 0) {
            notifyEvent(new GameEvent(GameEventType.GAME_OVER,
                    "Winner", first.getName(),
                    "Loser", second.getName()));
        } else if (scoreComparison < 0) {
            notifyEvent(new GameEvent(GameEventType.GAME_OVER,
                    "Winner", second.getName(),
                    "Loser", first.getName()));
        } else {
            notifyEvent(new GameEvent(GameEventType.GAME_OVER));
        }
    }

    /**
     * Notifie un événement à l'abonné.
     *
     * @param event l'événement à notifier (ne peut pas être {@code null}).
     */
    private void notifyEvent(GameEvent event) {
        subscriber.onEvent(event);
    }
}
