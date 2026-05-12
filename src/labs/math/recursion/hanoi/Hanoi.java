package labs.math.recursion.hanoi;

/**
 * Les tours de Hanoi.
 * 
 * @author François Schumacker
 */

public class Hanoi {

	/*
	 * Contenu des 3 tours
	 * 
	 * Exemple : configuration initiale avec 4 disques { "4321", "", "" }
	 */
	private static String[] tours = { "", "", "" };

	/**
	 * Résolution du problème des tours de Hanoï avec n disques.
	 * 
	 * @param n Nombre de disques
	 */
	public static void hanoi(int n) {
		
		if (n < 1 || n > 9)
			return; // N est compris entre 1 et 9

		// Initialisation des 3 tours
		tours = new String[] { "", "", "" };
		for (int i = n; i > 0; i--) {
			tours[0] += i;
		}

		// Affichage de la configuration initiale
		afficherTours();

		/*
		 * Résolution récursive
		 * - N disques
		 * - Tour de départ = 0
		 * - Tour d'arrivée = 2
		 * - Tour intermédiaire = 1
		 */
		hanoi(n, 0, 2, 1);
	}

	/**
	 * Résolution RECURSIVE du problème des tours de Hanoi.
	 * 
	 * @param n             Nombre de disques
	 * @param depart        Numéro du plot de départ
	 * @param arrivee       Numéro du plot d'arrivée
	 * @param intermediaire Numéro du plot intermédiaire
	 */
	private static void hanoi(int n, int depart, int arrivee, int intermediaire) {
		if (n == 0) return; // Cas d'arrêt : plus de disque à bouger
		hanoi(n - 1, depart, intermediaire, arrivee);
		deplacer(depart, arrivee);
		hanoi(n - 1, intermediaire, arrivee, depart);
	}

	/**
	 * Déplace le disque au sommet de la tour d'origine vers le sommet de la tour de
	 * destination et affiche la configuration après le déplacement.
	 * 
	 * Exemple : deplacer(1,2) à partir de la configuration { "43", "1", "2" }
	 *           donne la configuration résultante { "43", "", "21" }
	 * 
	 * @param origine     Numéro de la tour d'origine
	 * @param destination Numéro de la tour de destination
	 */
	private static void deplacer(int origine, int destination) {
		char c = tours[origine].charAt(tours[origine].length() - 1); // Récupèrer le caractère
		tours[origine] = tours[origine].substring(0, tours[origine].length()-1); // Retirer de l'ancienne tour
		tours[destination] = tours[destination] + c; // rajouter la a nouvelle tour
		afficherTours();
	}

	/**
	 * Affiche la configuration courante des tours
	 */
	private static void afficherTours() {
		System.out.println();
		int n = tours[0].length() + tours[1].length() + tours[2].length();
		for (int i = n; i > 0; i--) {
			for (int t = 0; t < 3; t++) {
				int size = 0;
				String disque = " ";
				if (tours[t].length() >= i) {
					size = tours[t].charAt(i - 1) - '0';
					for (int x = 0; x < (n - size + 1); x++)
						disque += " ";
					for (int x = 0; x < (size * 2 - 1); x++)
						disque += "*";
					for (int x = 0; x < (n - size + 1); x++)
						disque += " ";
				} else {
					for (int x = 0; x < n; x++)
						disque += " ";
					disque += "|";
					for (int x = 0; x < n; x++)
						disque += " ";
				}
				System.out.print(disque + " ");
			}
			System.out.println();
		}
		for (int x = 0; x < ((2 * n) + 3) * 3; x++) {
			System.out.print("=");
		}
	}

	/**
	 * Programme principal
	 */
	public static void main(String[] args) {
		
		System.out.println("Résolution avec 3 disques :");
		hanoi(3);

		System.out.println("Résolution avec 4 disques :");
		hanoi(4);

		System.out.println("Résolution avec 5 disques :");
		hanoi(5);
	}
}
