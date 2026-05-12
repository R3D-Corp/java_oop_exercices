package labs.math.recursion.numeration;

/**
 * Nombres en chiffres romains.
 * 
 */

public class ChiffresRomains {
	/**
	 * Détermine la valeur décimale d'un nombre exprimé en chiffres romains. 
	 * Version ITERATIVE.
	 * 
	 * @param nombre Nombre exprimé en chiffres romains.
	 * @return Valeur décimale du nombre.
	 */
	public static int chiffresRomainsVersDecimalIteratif(String nombre) {
		int response = 0;

		for(int i=0; i<nombre.length(); i++) {
			if(i+1 < nombre.length()) {
				int current = valeurChiffre(nombre.charAt(i));
				int next = valeurChiffre(nombre.charAt(i+1));
				
				if(current>=next) {
					response += current;
				} else {
					response -= current;
				}

			} else {
				response += valeurChiffre(nombre.charAt(i));
			}
		}
		return response;  // <- A modifier !
	}

	/**
	 * Détermine la valeur décimale d'un nombre exprimé en chiffres romains. 
	 * Version RECURSIVE.
	 * 
	 * @param nombre Nombre exprimé en chiffres romains.
	 * @return Valeur décimale du nombre.
	 */
	public static int chiffresRomainsVersDecimalRecursif(String nombre) {
		if(nombre.isEmpty()) return 0;

		if(nombre.length() >= 2) {
			int current = valeurChiffre(nombre.charAt(0));
			int next = valeurChiffre(nombre.charAt(1));

			if(current>=next) {
				return current + chiffresRomainsVersDecimalRecursif(nombre.substring(1, nombre.length()));
			} else {
				return -current + chiffresRomainsVersDecimalRecursif(nombre.substring(1, nombre.length()));
			}
		}
		
		return valeurChiffre(nombre.charAt(0));
	}

	/**
	 * Retourne la valeur décimale d'un chiffre romain.
	 * 
	 * @param c Un chiffre romain (M, D, C, L, X, V, I)
	 * @return La valeur décimale du chiffre romain
	 */
	private static int valeurChiffre(char c) {
		
		int valeur = 0;
		
		switch (c) {
		case 'M':
			valeur = 1000;
			break;
		case 'D':
			valeur = 500;
			break;
		case 'C':
			valeur = 100;
			break;
		case 'L':
			valeur = 50;
			break;
		case 'X':
			valeur = 10;
			break;
		case 'V':
			valeur = 5;
			break;
		case 'I':
			valeur = 1;
			break;
		}
		return valeur;
	}
}
