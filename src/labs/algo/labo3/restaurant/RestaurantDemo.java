package labs.algo.labo3.restaurant;

import io.Console;

public class RestaurantDemo {

	private static final int CAPACITE_INITIALE = 100;
	private static final String MENU = """
			== Restaurant ==
			1 – Encoder une réservation
			2 – Libérer une réservation
			3 – Retrouver une réservation
			4 – Imprimer les réservatons
			* – Quitter
			> """;

	private static final String AU_REVOIR = "Au revoir.";
	private static final String INPUT_NOM = "C'est à quel nom ? ";
	private static final String INPUT_NB = "Pour combinen de personnes ? ";
	private static final String OK = "C'est noté !\n";
	private static final String KO = "J'ai bien peur que cela ne soit pas possible\n";
	private static final String PLACE = "Siège %d.\n";

	public static void main(String[] args) {

		Restaurant restOS = new Restaurant(CAPACITE_INITIALE);
		int menu;
		do {
			switch(menu = Console.lireInt(MENU)) {
			case 1 -> {
				if(restOS.reserver(Console.lireString(INPUT_NOM), Console.lireInt(INPUT_NB))) {
					System.out.println(OK);
				} else {
					System.out.println(KO);
				}
			}
			case 2 -> {
				restOS.libererPlace(Console.lireString(INPUT_NOM));
				System.out.println(OK);
			}
			case 3 -> {
				int place = restOS.placeDebut(Console.lireString(INPUT_NOM));
				if (place == -1) {
					System.out.println(KO);
				} else {
					System.out.println(PLACE.formatted(place));
				}
			}
			case 4 -> {
				System.out.println(restOS);
			}
			default -> {
				auRevoir();
			}
			}
		}
		while(menu <= 4 && menu >= 1);
	}

	private static void auRevoir() {
		System.out.println(AU_REVOIR);
	}
}
