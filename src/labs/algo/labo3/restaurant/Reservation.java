package labs.algo.labo3.restaurant;

import java.util.Objects;

/**
 * Reservation
 * Représente à la fois les plages libres et les plages occupées.
 * 
 * Les réservations sont immuables.
 * Elles sont créés sur base des méthodes de fabriques statiques librePour et auNomDePour
 */
public final class Reservation {

	private static final String SANS_NOM = "";
	
	private final String nom;
	private final int nbPersonnes;
	private final boolean libre;
	private final int siegeDebut;
	
	private Reservation(int nombre, int siegeDebut, boolean libre, String nom) {
		this.libre = libre;
		this.nbPersonnes = nombre;
		this.siegeDebut = siegeDebut;
		this.nom = nom;
	}
	
	/**
	 * Crée une plage libre entre les sièges siegeDebut et siegeDebut + nombre - 1.
	 * @param nombre
	 * @param siegeDebut
	 * @return la plage libre.
	 */
	public static Reservation librePour(int nombre, int siegeDebut) {
		return new Reservation(verifierValeurAuMoins(nombre, 1),
				verifierValeurAuMoins(nombre, 0),
				true,
				SANS_NOM);
	}
	
	/**
	 * Crée une réservation au nom précisé entre siegeDebut et siegeDebut + nombre - 1.
	 * @param nom nom auquel on réserve
	 * @param nombre
	 * @param siegeDebut
	 * @return
	 */
	public static Reservation auNomDePour(String nom, int nombre, int siegeDebut) {
		return new Reservation(verifierValeurAuMoins(nombre, 1),
				verifierValeurAuMoins(nombre, 0),
				false,
				Objects.requireNonNull(nom));
	}

	public boolean isLibre() {
		return libre;
	}
	
	public int getNbPersonnes() {
		return nbPersonnes;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getSiegeDebut() {
		return siegeDebut;
	}
	
	public int getSiegeFin() {
		return siegeDebut + nbPersonnes - 1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(libre, nbPersonnes, siegeDebut, nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Reservation))
			return false;
		Reservation other = (Reservation) obj;
		return libre == other.libre 
				&& nbPersonnes == other.nbPersonnes 
				&& siegeDebut == other.siegeDebut
				&& Objects.equals(nom, other.nom);
	}

	@Override
	public String toString() {
		if (libre) {
			return nbPersonnes + " places libres entre " + getSiegeDebut() + " et " + getSiegeFin();
		} else {
			return "Réservation au nom de " + nom + ", pour " + nbPersonnes + " (" + getSiegeDebut() + " -> " + getSiegeFin() + ")";
		}
	}

	private static int verifierValeurAuMoins(int nombre, int seuil) {
		if (nombre < seuil) {
			throw new IllegalArgumentException("%d doit être >= %d".formatted(nombre, seuil));
		}
		return nombre;
	}
}
