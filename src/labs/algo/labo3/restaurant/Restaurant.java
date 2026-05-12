package labs.algo.labo3.restaurant;

import java.util.LinkedList;
import java.util.List;

public class Restaurant {

	private final List<Reservation> reservations;
	// TODO Utiliser une Map<String, Integer> / HashMap ? pour lier un nom et une position ?
	
	public Restaurant(int capacite) {
		reservations = new LinkedList<>();
		reservations.add(Reservation.librePour(capacite, 0));
	}
	
	/**
	 * Réserver une plage de nbPersonnes au nom donné par nom.
	 * @param nom pour lequel on réserve
	 * @param nbPersonnes la taille de la réservation.
	 * @return true si la réservation est possible, false sinon.
	 */
	public boolean reserver(String nom, int nbPersonnes) {
		return false; // FIXME
	}
	
	/**
	 * Libérer la réservation au nom donné en paramètre
	 * @param nom
	 */
	public void libererPlace(String nom) {
		// FIXME
	}
	
	/**
	 * Retourner le début de la plage de la réservation.
	 * @param nom
	 * @return la plage, -1 si pas trouvé
	 */
	public int placeDebut(String nom) {
		return -1; // FIXME
	}
	
	/**
	 * Retourne une représentation du restaurant.
	 */
	@Override
	public String toString() {
		return ""; // FIXME
	}
}
