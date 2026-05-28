
package labs.math.mod.euclide;

/**
 * Soient a et b deux entiers positifs (naturels).
 * 
 * L'algorithme d'Euclide étendu permet de caluler le PGCD de ces deux nombres,
 * 
 * mais aussi les entiers u et v, solution de l'équation :
 * 
 *             a * u + b * v = pgcd(a, b) (équation de Bézout)
 * 
 * Lorsque a et b sont premiers entre eux, u est l'inverse modulaire de a modulo b.
 *  
 */

public class EuclideEtendu {
	/**
	 * Algorithme d'Euclide étendu. Implémentation itérative. 
	 * 
	 * @param a premier nombre naturel
	 * @param b deuxième nombre naturel
	 * @return PGCD(a, b) 
	 * 
	 */
	public static long pgcdEuclideEtendu(long a, long b) {
		return euclideEtendu(a, b)[0];
	}

	
	/**
	 * Algorithme d'Euclide étendu. Implémentation itérative. 
	 * 
	 * @param a premier nombre naturel
	 * @param b deuxième nombre naturel
	 * @return PGCD(a, b) et  u, v entiers relatifs tels que a * u + b * v = pgcd(a, b)
	 * 
	 */
    public static long[] euclideEtendu(long a, long b) {
		// if(a<0) throw new ArithmeticException("Arg. a natural integer require");
		// if(b<0) throw new ArithmeticExc:eption("Arg. b natural integer require");



		long[] lineA = new long[] {a, 1, 0};
		long[] lineB = new long[] {b, 0, 1};
		long q;
		while(lineB[0] != 0) {
			q = lineA[0] / lineB[0];

			long[] newLineA = lineB;
			long[] newLineB = new long[] {lineA[0] - lineB[0] * q, lineA[1] - lineB[1] * q, lineA[2] - lineB[2] * q};

			lineA = newLineA;
			lineB = newLineB;
		}

	    return new long[] {lineA[0], lineA[1], lineA[2]};
    }
 
}
