package labs.algo.labo3.calcul;

import java.util.Objects;

/**
 * Cette classe représente soit une valeur soit un opérateur, soit une variable.
 */
public final class CellulePile {
	
	private final Object content;
	private final CelluleType type;

	private CellulePile(Object content, CelluleType type) {
		this.content = content;
		this.type = type;
	}

	/**
	 * Crée une cellule pour l'opérateur spécifié.
	 * @param operateur
	 * @return
	 */
	public static CellulePile pourOperateur(char operateur) {
		return new CellulePile(Character.valueOf(operateur), CelluleType.OPERATEUR);
	}
	
	/**
	 * Crée une cellule pour la valeur spécifiée.
	 * @param valeur
	 * @return
	 */
	public static CellulePile deValeur(double valeur) {
		return new CellulePile(Double.valueOf(valeur), CelluleType.VALEUR);
	}
	
	/**
	 * Crée une cellule pour la valeur spécifiée.
	 * @param valeur
	 * @return
	 */
	public static CellulePile pourVariable(String variable) {
		return new CellulePile(Objects.requireNonNull(variable), CelluleType.VARIABLE);
	}
	
	public boolean isValeur() {
		return getType() == CelluleType.VALEUR;
	}
	
	public boolean isVariable() {
		return getType() == CelluleType.VARIABLE;
	}
	
	public boolean isOperateur() {
		return getType() == CelluleType.OPERATEUR;
	}
	
	public CelluleType getType() {
		return type;
	}

	public char getOperateur() {
		if (type != CelluleType.OPERATEUR) {
			throw new IllegalStateException("La cellule ne contient pas d'opérateur");
		}
		return ((Character) content).charValue(); // Cast OK vu l'utilisation de CelluleType
	}

	public double getValeur() {
		if (type != CelluleType.VALEUR) {
			throw new IllegalStateException("La cellule ne contient pas de valeur");
		}
		return ((Double) content).doubleValue();
	}
	
	public String getVariable() {
		if (type != CelluleType.VARIABLE) {
			throw new IllegalStateException("La cellule ne contient pas de variable");
		}
		return (String) content;
	}
}
