package labs.janken.domains.players;

import java.util.List;

import labs.janken.domains.Move;
import labs.janken.domains.MoveComparison;
import util.Contract;

/**
 * TODO: ajouter le rôle (exo 1)
 *
 * <p>Cette classe définit les propriétés et comportements communs à tous les types de joueurs,
 * qu'ils soient humains, automatisés ou autres. Elle gère le nom du joueur et son score,
 * et impose la mise en œuvre des méthodes essentielles pour le déroulement d'un tour.</p>
 *
 * <p><strong>Invariants :</strong></p>
 * <ul>
 *   <li>Le nom du joueur ne peut pas être {@code null} ou blanc.</li>
 *   <li>Le score est toujours un entier non négatif.</li>
 * </ul>
 *
 */
public abstract class BasePlayer {

    /** Nom du joueur (non modifiable après initialisation). */
    private final String name;

    /** Score actuel du joueur (initialisé à 0). */
    private int score;

    /**
     * Construit un nouveau joueur avec le nom spécifié.
     *
     * @param name le nom du joueur (ne peut pas être {@code null} ou vide).
     * @throws IllegalArgumentException si {@code name} est {@code null} ou vide.
     */
    protected BasePlayer(String name) {
        this.name = Contract.require(
            name,
            name != null && !name.isBlank(),
            "Arg. name must not be blank"
        );
    }

    /**
     * Retourne le nom du joueur.
     *
     * @return le nom du joueur (jamais {@code null} ou vide).
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Retourne le score actuel du joueur.
     *
     * @return le score du joueur (toujours >= 0).
     */
    public final int getScore() {
        return this.score;
    }

    /**
     * Incrémente le score du joueur de 1.
     */
    public final void raiseScore() {
        this.score += 1;
    }

    /**
     * Réinitialise le score du joueur à 0.
     */
    public final void resetScore() {
        this.score = 0;
    }

    /**
     * Méthode abstraite pour choisir le prochain coup parmi les coups disponibles.
     *
     * @param availableMoves la liste des coups disponibles (ne peut pas être {@code null}).
     * @return le coup sélectionné par le joueur.
     */
    public abstract Move nextMove(List<Move> availableMoves);

    /**
     * Méthode abstraite appelée à la fin d'un tour pour informer le joueur du résultat.
     *
     * @param thisMove le coup joué par ce joueur.
     * @param otherMove le coup joué par l'adversaire.
     * @param result le résultat de la comparaison entre les deux coups.
     */
    public abstract void handleTurnOver(Move thisMove, Move otherMove, MoveComparison result);
}
