package labs.math.recursion.suite;

import util.Contract;

/**
 * Calcul du nième terme de la suite définie par :
 * 
 * 	u(1) = 3  et  u(n) = n * u(n-1)
 * 
 */

// u(1) = 3
// u(2) = 2 * 3;
// u(3) = 3 * (2 * 3);
// u(4) = 

public class TermesSuite {
    private static int BASE = 3;
    /**
     * Calcule le terme u(n) de la suite décrite ci-dessus.
     * Version itérative.
     *
     * @param n Indice du terme à calculer 
     * @return  le terme à calculer u(n)
     */
    public static long termesSuiteIteratif(int n) {
      Contract.require(n > 0, "Arg. n >= 1");

      long response = BASE;
      for(int i=1; i<=n; i++) {
          System.out.println("Ici reponse :" + response);
          response = response * i; 
      }
    	return response;
    }

    /**
     * Calcule le terme u(n) de la suite décrite ci-dessus.
     * Version récursive.
     *
     * @param n Indice du terme à calculer et à afficher
     * @return le terme à calculer et à afficher, u(n)
     */
    public static long termesSuiteRecursif(int n) {
      Contract.require(n >= 1, "Arg. n >= 1");
      if(n == 1) return BASE; // 3
      
      return n * termesSuiteRecursif(n-1);
    }
 
    
    public static void main(String[] args) {
      System.out.println("--- suiteIteratif --- ");
      // for(int i = 1; i <= 20; i++) {
      //   System.out.printf("", i, termesSuiteIteratif(i));
      // }
      System.out.println();
      
      System.out.println("--- suiteRecursif --- ");		
      for(int i = 1; i <= 20; i++) {
        System.out.printf("terme %2d : %d\n", i, termesSuiteRecursif(i));				
      }
    }
}
