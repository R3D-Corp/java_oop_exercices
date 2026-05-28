package labs.math.mod.calculatrice;


import java.util.Scanner;

import labs.math.mod.euclide.EuclideEtendu;
import util.Contract;

/**
 * Calculatrice d'arithmétique modulaire.
 * 
 * Propose les opérations suivantes : 
 *    - addition
 *    - soustraction 
 *    - multiplication
 *    - division
 *    - puissance
 *    - inverse modulaire
 *    - affichage de la table de multiplication mod n
 *    - affichage de la liste des entiers qui admettent un inverse modulo n ainsi que de leurs inverses.
 */
public class CalculatriceModulaire {
	
	// En respectant les définitions vues au cours 
	// et en tenant compte du comportement de Java pour les valeurs négatives.
	
	/**
	 * Calcule l'addition modulaire a + b mod modulo.
	 * 
	 * @param a       le premier terme (peut être négatif)
	 * @param b       le second terme (peut être négatif)
	 * @param modulo  le modulo  (doit être ≥ 2)
	 * @return        a + b mod modulo, dans [0, modulo[
	 */
    public static long addition(long a, long b, long modulo) {
    	Contract.require(modulo >= 2, "Arg. modulo >= 2 require");
        long res = (a%modulo + b%modulo) % modulo;
        if(res < 0) {
            res += modulo;
        }

	    return res;
    }

    /**
     * Calcule la soustraction modulaire a - b mod modulo.
     *
     * @param a       le premier terme (peut être négatif)
	 * @param b       le second terme (peut être négatif)
     * @param modulo  le modulo (doit être ≥ 2)
     * @return        a - b mod modulo, dans [0, modulo[
     */
    public static long soustraction(long a, long b, long modulo) {
        Contract.require(modulo >= 2, "Arg. modulo >= 2 require");

        long res = (a%modulo - b%modulo) % modulo;
        if(res < 0) {
            res += modulo;
        }

	    return res;

    }
    
    /**
     * Calcule la multiplication modulaire a × b mod modulo.
     *
     * @param a       le premier facteur (peut être négatif)
     * @param b       le second facteur (peut être négatif)
     * @param modulo  le modulo (doit être ≥ 2)
     * @return        a × b mod modulo, dans [0, modulo[
     */
    public static long multiplication(long a, long b, long modulo) {
        Contract.require(modulo >= 2, "Arg. modulo >= 2 require");

        long res = (a%modulo * b%modulo) % modulo;
        if(res < 0) {
            res += modulo;
        }

	    return res;
    }
    
    /**
     * Calcule l'inverse modulaire de a modulo n, si il existe. <br>
     *
     * NB : Il est obtenu via l'algorithme d'Euclide étendu implémenté dans la classe EuclideEtendu.java.
     *
     * @param a       l'entier dont on cherche l'inverse (peut être négatif)
     * @param modulo  le modulo (doit être ≥ 2)
     * @return        l'inverse modulaire de a, dans [0, modulo[
     * @throws ArithmeticException si a n'est pas inversible modulo n  (pgcd(a, modulo) != 1).
     */
    public static long inverseModulaire(long a, long modulo) {
    	long[] response = EuclideEtendu.euclideEtendu(a, modulo);
        if(response[0] != 1) throw new ArithmeticException("L'inverse modulaire n'existe pas");
        
        if(response[1] <0) {
            response[1] += modulo;
        }

	    return response[1];
    }
    
    /**
     * Calcule la division modulaire a / b mod modulo. <br>
     *
     * Rappel : diviser par b revient à multiplier par b^-1, si b^-1 existe.
     * 
     * @param a       le numérateur
     * @param b       le dénominateur
     * @param modulo  le modulo (doit être ≥ 2)
     * @return        a / b mod modulo, dans [0, modulo[
     */
    public static long division(long a, long b, long modulo) {  
        Contract.require(modulo >= 2, "Arg. modulo >= 2 require");

	    return (a + 1/b) % 2;
    }
    
    /**
     * Calcule la puissance modulaire a^exp mod m (a = base).
     *
     * @param base    la base de la puissance
     * @param exp     l'exposant(peut être négatif)
     * @param modulo  le modulo (doit être ≥ 2)
     * @return        base^exp mod modulo, dans [0, modulo[
     */
    //  NB : Version implémentant la définition du cours (pas efficace !!)   
    public static long puissance(long base, long exp, long modulo) {
    	
    	// TODO
	    return 0;  // <- A modifier !!!
    }
       
    /**
	 * Affiche la table de multiplication mod n.
	 * 
	 * @param modulo le modulo souhaité (doit être ≥ 2)
	 */
    // Exemples dias 54 ( n = 5) et 55 ( n = 15)
    public static void afficheMultTable(long modulo) {
    	
    	// TODO
    }
      
    /**
	 * Affiche la liste des entiers qui admettent un inverse modulo n ainsi que leurs inverses.
	 * 
	 * @param modulo le modulo souhaité (doit être ≥ 2)
	 */
    public static void afficheInversibles(long modulo) {
    	
    	// TODO
    }    
 
    /**
	 * Affiche le menu des choix.
	 */
    public static void afficheMenu() {
    	System.out.println("\n ------------- Menu -------------\n");
        System.out.println(" 1. Addition        (a + b) mod n");
        System.out.println(" 2. Soustraction    (a - b) mod n");
        System.out.println(" 3. Multiplication  (a × b) mod n");
        System.out.println(" 4. Division        (a / b) mod n");
        System.out.println(" 5. Puissance       (a ^ e) mod n");
        System.out.println(" 6. Inverse modulaire de a");
        System.out.println(" 7. Table de multiplication");
        System.out.println(" 8. Liste des inversibles");
        System.out.println(" 9. Quitter");
    }

    
    /**
	 * Programme principal
	 */
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
      
        System.out.println("\n   Calculatrice modulaire    \n-----------------------------\n");

        System.out.print("Choisissez le modulo n : ");
        int modulo = sc.nextInt();
        if (modulo <= 1) { 
        	System.out.println("le modulo doit être ≥ 2"); 
        	sc.close();
        	return; 
        }

        boolean calculer = true;
        while (calculer) {
        	
        	afficheMenu();
            System.out.print("\nVotre choix : ");
            int choix = sc.nextInt();
            
            if (choix == 9) {
//            	calculer = false;
            	break;
            }            	

            long a = 0, b = 0;
            if (choix > 0 && choix < 5) {
            	System.out.print("a = "); a = sc.nextLong();
                System.out.print("b = "); b = sc.nextLong();
            }
            try {
	            switch (choix) {
	                case 1 -> {                    
	                    System.out.printf("(%d + %d) ≡ %d (mod %d)\n", a, b, addition(a, b, modulo), modulo);
	                }
	                case 2-> {
	                    System.out.printf("(%d - %d) ≡ %d (mod %d)\n", a, b, soustraction(a, b, modulo), modulo);
	                }
	                case 3-> {
	                    System.out.printf("(%d × %d) ≡ %d (mod %d)\n", a, b, multiplication(a, b, modulo), modulo);
	                }
	                case 4-> {
	                    System.out.printf("(%d / %d) ≡ %d (mod %d)\n", a, b, division(a, b, modulo), modulo);
	                }
	                case 5 -> {
	                    System.out.print("base = "); long base = sc.nextLong();
	                    System.out.print("exposant = "); long exp = sc.nextLong();
	                    System.out.printf("%d^%d ≡ %d (mod %d)\n", base, exp, puissance(base, exp, modulo), modulo);
	                }
	                case 6 -> {
	                    System.out.print("a = "); a = sc.nextLong();
	                    System.out.printf("%d^(-1) ≡ %d (mod %d)\n", a, inverseModulaire(a, modulo), modulo);
	                }
	                case 7 -> afficheMultTable(modulo);
	                case 8 -> afficheInversibles(modulo);                
	                default -> System.out.println("Option invalide.");
	            }
	        } 
            catch (ArithmeticException e) {
	            System.out.println("Calcul impossible : " + e.getMessage());
	        }
        }
        
        sc.close();
        System.out.println("\nAu revoir !");
    }
}