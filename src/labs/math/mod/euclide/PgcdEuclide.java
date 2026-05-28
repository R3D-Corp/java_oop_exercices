package labs.math.mod.euclide;

import util.Contract;

/**
 * L'algorithme d'Euclide permet de calculer le PGCD de deux entiers naturels a et b.
 * 
 */

public class PgcdEuclide {
	/**
	 * Calcul du PGCD de manière itérative en suivant l'algorithme d'Euclide standard
	 * (par division euclidienne). 
	 * Cet algorithme est applicable dans le cas de deux nombres entiers positifs a et b.
	 * 
	 * @param a premier nombre naturel
	 * @param b deuxième nombre naturel
	 * @return PGCD(a, b)
	 */
	public static int pgcdEuclide(int a, int b) {
		Contract.require(a >= 0, "Arg. a natural integer require");
		Contract.require(b >= 0, "Arg. b natural integer require");


		int r;
		while(b!=0) {
			r = a % b;
			a = b;
			b = r;
		} 

		return a;
	}	
}
