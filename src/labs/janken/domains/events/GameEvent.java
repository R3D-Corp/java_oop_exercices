package labs.janken.domains.events;

import java.util.HashMap;
import java.util.Objects;

import util.Contract;


/**
 * Représente un événement de jeu immuable, caractérisé par un type et une collection d'arguments.
 * <p>Les clés des arguments sont insensibles à la casse.</p>
 *
 * <p>Exemple d'utilisation :
 * <pre>
 *   GameEvent event = new GameEvent(GameEventType.PLAYER_WIN, "score", "100", "player", "Alice");
 *   String player = event.getArg("Player"); // Retourne "Alice"
 * </pre>
 */
public final class GameEvent {
    private final GameEventType type;
    private final HashMap<String, String> args;

    /**
     * Construit un nouvel événement de jeu.
     *
     * @param type le type de l'événement, ne peut pas être null
     * @param args une liste de paires clé-valeur (doit avoir une longueur paire)
     * @throws IllegalArgumentException si {@code type} ou {@code args} est null,
     *         ou si une clé/valeur dans {@code args} est null
     * @throws IllegalArgumentException si {@code args.length} est impair
     */
    public GameEvent(GameEventType type, String... args) {
        this.type = Contract.require(type, type != null, "Arg. type != null attendu");
        Contract.require(args != null, "Arg. args != null attendu");
        Contract.require(args.length % 2 == 0, "Arg. args doit avoir un nombre pair d'éléments.");
        this.args = new HashMap<String, String>();

        for(int i = 0; i < args.length; i += 2) {
        	Contract.require(args[i] != null, "Clé ne peut pas être null");
        	Contract.require(args[i+1] != null, "Valeur ne peut pas être null");
            this.args.put(args[i].toLowerCase(), args[i+1]);
        }
    }

    /**
     * Retourne le type de cet événement.
     *
     * @return le type de l'événement
     */
    public GameEventType getType() {
        return type;
    }

    /**
     * Vérifie si un argument existe pour la clé spécifiée.
     *
     * @param key la clé à vérifier (insensible à la casse)
     * @return true si la clé existe, false sinon
     * @throws IllegalArgumentException si {@code key} est null ou vide
     */
    public boolean hasArg(String key) {
        Contract.require(key != null && !key.isBlank(), "Arg. key non-blanc attendu");
        return this.args.containsKey(key.toLowerCase());
    }

    /**
     * Retourne la valeur associée à la clé spécifiée.
     *
     * @param key la clé dont on veut la valeur (insensible à la casse)
     * @return la valeur associée à la clé, ou null si la clé n'existe pas
     * @throws IllegalArgumentException si {@code key} est null ou vide
     */
    public String getArg(String key) {
        Contract.require(key != null && !key.isBlank(), "Arg. key non-blanc attendu");
        return this.args.get(key.toLowerCase());
    }

    /**
     * Retourne une représentation textuelle de cet événement.
     *
     * @return une chaîne de caractères au format "{type} with args {args}"
     */
    @Override
    public String toString() {
        return "%s with args %s".formatted(type, args);
    }

    /**
     * Calcule le code de hachage de cet événement.
     *
     * @return le code de hachage, basé sur le type et les arguments
     */
    @Override
    public int hashCode() {
        return Objects.hash(args, type);
    }

    /**
     * Compare cet événement avec un autre objet pour l'égalité.
     * Deux événements sont égaux s'ils ont le même type et les mêmes arguments.
     *
     * @param obj l'objet à comparer
     * @return true si les objets sont égaux, false sinon
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameEvent other)) {
            return false;
        }
        return Objects.equals(args, other.args) && type == other.type;
    }
}
