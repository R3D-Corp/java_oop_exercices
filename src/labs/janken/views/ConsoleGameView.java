package labs.janken.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;

import io.Console;
import labs.janken.domains.MoveChooser;
import labs.janken.domains.events.GameEvent;
import labs.janken.domains.events.GameEventSubscriber;
import util.Contract;

/**
 * TODO: ajouter le rôle (exo 1)
 *
 * <p>Cette classe gère l'affichage textuel du jeu dans la console, en réagissant aux événements
 * du jeu ({@link GameEvent}) et en permettant à l'utilisateur de sélectionner ses coups.
 * Elle maintient un tableau des coups joués par chaque joueur au fil des tours.</p>
 *
 * <p><strong>Invariants :</strong></p>
 * <ul>
 *   <li>Le tableau des tours ({@link #turnsBoard}) est toujours trié par nom de joueur.</li>
 *   <li>Les arguments attendus dans les événements sont vérifiés par contrat.</li>
 * </ul>
 *
 */
public final class ConsoleGameView extends MoveChooser {

    public static final String BIG_LINE_FEED = "━".repeat(42) + "\n";
    public static final String LIGHT_LINE_FEED = "─".repeat(42) + "\n";

    /** Tableau des coups joués par chaque joueur, organisé par nom de joueur. */
    private final Map<String, List<String>> turnsBoard = new TreeMap<>();

    /**
     * Demande à l'utilisateur de choisir une option parmi une plage de valeurs.
     *
     * @param prompt le message à afficher pour guider l'utilisateur.
     * @param minIncl la valeur minimale incluse.
     * @param maxIncl la valeur maximale incluse.
     * @return le choix de l'utilisateur, compris entre {@code minIncl} et {@code maxIncl}.
     */
    @Override
    public int chooseBetween(String prompt, int minIncl, int maxIncl) {
        return Console.readInt(prompt, minIncl, maxIncl);
    }

    /**
     * Traite les événements du jeu en fonction de leur type.
     *
     * @param event l'événement à traiter (ne peut pas être {@code null}).
     */
    @Override
    public void onEvent(GameEvent event) {
        switch (event.getType()) {
            case GAME_STARTED -> handleGameStarted();
            case TURN_STARTED -> handleTurnStarted(event);
            case PLAYER_CHANGED -> handlePlayerChanged(event);
            case MOVE_SELECTED -> handleMoveSelection(event);
            case TURN_OVER -> handleTurnOver(event);
            case GAME_OVER -> handleGameOver(event);
            default -> Console.println();
        }
    }

    /** Affiche le début d'une nouvelle partie. */
    private void handleGameStarted() {
        Console.println(BIG_LINE_FEED);
        Console.println("Partie commencée");
        Console.println("━".repeat(16));
    }

    /**
     * Affiche le début d'un nouveau tour.
     *
     * @param event l'événement contenant les numéros de tour et total de tours.
     * @throws IllegalArgumentException si les arguments "Turn" ou "Total" sont manquants.
     */
    private void handleTurnStarted(GameEvent event) {
        Contract.require(event.hasArg("Turn"), "Donnée Turn attendue");
        Contract.require(event.hasArg("Total"), "Donnée Total attendue");

        Console.println(LIGHT_LINE_FEED);
        Console.printf("Tour %s/%s%n", event.getArg("Turn"), event.getArg("Total"));
    }

    /**
     * Affiche le changement de joueur et initialise son entrée dans le tableau des coups.
     *
     * @param event l'événement contenant le nom du joueur.
     * @throws IllegalArgumentException si l'argument "Player" est manquant.
     */
    private void handlePlayerChanged(GameEvent event) {
        Contract.require(event.hasArg("Player"), "Donnée Player attendue");

        String playerName = event.getArg("Player");
        Console.printf("Au tour de %s%n", playerName);
        if (!this.turnsBoard.containsKey(playerName)) {
            this.turnsBoard.put(playerName, new ArrayList<>());
        }
    }

    /**
     * Enregistre le coup sélectionné par un joueur et met à jour le tableau des coups.
     *
     * @param event l'événement contenant le nom du joueur et son coup.
     * @throws IllegalArgumentException si les arguments "Player" ou "Move" sont manquants.
     */
    private void handleMoveSelection(GameEvent event) {
        Contract.require(event.hasArg("Player"), "Donnée Player attendue");
        Contract.require(event.hasArg("Move"), "Donnée Move attendue");

        String playerName = event.getArg("Player");
        String move = event.getArg("Move");
        this.turnsBoard.get(playerName).add(move);
    }

    /**
     * Affiche la fin d'un tour et le résultat (victoire ou égalité).
     *
     * @param event l'événement contenant le résultat et éventuellement le gagnant.
     * @throws IllegalArgumentException si les arguments requis sont manquants.
     */
    private void handleTurnOver(GameEvent event) {
        Contract.require(event.hasArg("Result"), "Donnée Result attendue");
        String result = event.getArg("Result").toLowerCase();
        Console.println("Tour terminé");
        Console.println("─".repeat(12));

        Console.println();
        displayBoard();
        Console.println();

        if (result.equals("draw")) {
            Console.println("Résultat : égalité");
        } else {
            Contract.require(event.hasArg("Winner"), "Donnée Winner attendue");
            Console.printf("%s remporte le tour%n", event.getArg("Winner"));
        }
        Console.println(LIGHT_LINE_FEED);
    }

    /** Affiche le tableau récapitulatif des coups joués par chaque joueur. */
    private void displayBoard() {
        for (var playerName : this.turnsBoard.keySet()) {
            var columnsJoiner = new StringJoiner("|", "|", "|");
            columnsJoiner.add("%-20s".formatted(playerName));
            for (var move : this.turnsBoard.get(playerName)) {
                columnsJoiner.add("%s".formatted(move));
            }
            Console.println(columnsJoiner.toString());
        }
    }

    /**
     * Affiche la fin de la partie et le résultat final (gagnant ou match nul).
     *
     * @param event l'événement contenant éventuellement le gagnant et le perdant.
     */
    private void handleGameOver(GameEvent event) {
        Console.println("Partie finie");
        Console.println("━".repeat(12));

        if (event.hasArg("Winner") && event.hasArg("Loser")) {
            Console.printf("Le vainqueur est %s%n", event.getArg("Winner"));
        } else {
            Console.println("Match nul");
        }
        Console.println(BIG_LINE_FEED);
    }
}
