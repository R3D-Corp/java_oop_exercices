package labs.janken.domains.players;

import java.util.List;

import labs.janken.domains.MoveChooser;
import labs.janken.domains.MoveComparison;
import labs.janken.domains.Move;

import util.Contract;

/**
 * TODO: ajouter le rôle (exo 1)
 *
 * <p>Cette classe implémente un joueur dont les décisions sont prises par un être humain
 * via une interface utilisateur externe. Elle ne gère pas la fin du tour, car ces
 * informations sont affichées et traitées par l'interface utilisateur sur base des événements lancés par JankeGame.</p>
 *
 */
public class HumanPlayer extends BasePlayer {

    /** Interface utilisateur responsable du choix du coup. */
    private final MoveChooser ui;

    /**
     * Construit un nouveau joueur humain.
     *
     * @param name le nom du joueur (ne peut pas être {@code null}).
     * @param ui l'interface utilisateur utilisée pour choisir un coup (ne peut pas être {@code null}).
     * @throws IllegalArgumentException si {@code ui} est {@code null}.
     */
    public HumanPlayer(String name, MoveChooser ui) {
        super(name);
        Contract.require(ui != null, "Arg. ui != null attendu");
        this.ui = ui;
    }

    /**
     * Demande à l'utilisateur de choisir un coup parmi les coups disponibles.
     *
     * <p>Présente les coups disponibles sous forme numérotée et utilise l'interface
     * utilisateur pour récupérer le choix de l'utilisateur.</p>
     *
     * @param availableMoves la liste des coups disponibles (ne peut pas être {@code null}
     *                       et doit contenir au moins deux éléments).
     * @return le coup sélectionné par l'utilisateur.
     * @throws IllegalArgumentException si {@code availableMoves} est {@code null} ou
     *         contient moins de deux éléments.
     */
    @Override
    public Move nextMove(List<Move> availableMoves) {
        Contract.require(availableMoves != null, "Arg. availableMoves != null attendu");
        Contract.require(availableMoves.size() > 1, "Arg. |availableMoves| > 1 attendu. Reçu " + availableMoves.size());

        var prompt = new StringBuilder();
        for (int i = 0; i < availableMoves.size(); ++i) {
            prompt.append("%d. %s%n".formatted(i + 1, availableMoves.get(i)));
        }

        int moveIndex = ui.chooseBetween(prompt.toString(), 1, availableMoves.size()) - 1;
        return availableMoves.get(moveIndex);
    }

    /**
     * Méthode appelée à la fin d'un tour.
     *
     * <p><strong>Note :</strong> Cette implémentation ne fait rien, 
     *  car l'affichage se fait sur base des événements lancés par JankenGame.</p>
     *
     * @param thisMove le coup joué par ce joueur.
     * @param otherMove le coup joué par l'adversaire.
     * @param result le résultat de la comparaison entre les deux coups.
     */
    @Override
    public void handleTurnOver(Move thisMove, Move otherMove, MoveComparison result) {
        // Ne fait rien : la gestion de la fin du tour est déléguée à l'UI.
    }
}

