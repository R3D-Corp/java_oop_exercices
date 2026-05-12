package labs.math.recursion.somme;

import util.Contract;

/**
 * Somme des premières puissances d'un nombre réel x :
 * 
 *   x^0 + x^1 + x^2 + ... + x^n
 * 
 */

public class SommePuissances {

	/**
	 * Somme des N+1 premières puissances d'un nombre réel.
	 * Version explicite (utilisant la formule).
	 * 
	 * @param x Un nombre réel différent de 1
	 * @param n Un nombre naturel
	 * @return La valeur de la somme
	 */
	public static double sommePuissances(double x, int n) {
		Contract.require(x!=1, "Arg.x > 1 required");
		Contract.require(n>=0, "Arg.n greater or equal 0.0 required");

		return (1 - Math.pow(x, n+1)) / (1 - x);
	}
	
	/**
	 * Somme des N+1 premières puissances d'un nombre réel.
	 * Version itérative.
	 * 
	 * @param x Un nombre réel différent de 1
	 * @param n Un nombre naturel
	 * @return La valeur de la somme
	 */
	public static double sommePuissancesIteratif(double x, int n) {
		Contract.require(x!=1, "Arg.x > 1 required");
		Contract.require(n>=0, "Arg.n greater or equal 0.0 required");

		double sum = 0;

		for(int i=0; i<=n; i++) {
			sum += Math.pow(x, i);
		}
		
		return sum;
	}
	
	/**
	 * Somme des N+1 premières puissances d'un nombre réel.
	 * Version récursive.
	 * 
	 * @param x Un nombre réel différent de 1
	 * @param n Un nombre naturel
	 * @return La valeur de la somme
	 */
	public static double sommePuissancesRecursif(double x, int n) {
		if(x==1) throw new IllegalArgumentException("Arg.x != 1 requis");		
		if(n < 0) throw new IllegalArgumentException("Arg.n >= 0 requis");
		
		if(n==0) {
			return 1.0; // ! x^0 == 1
		} else {
			return Math.pow(x, n) + sommePuissancesRecursif(x, n-1);
		}
	}

}
