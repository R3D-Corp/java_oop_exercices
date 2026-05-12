package labs.math.recursion.string;

/**
 * Modification de la casse d'une chaîne de caractères.
 * 
 */

public class Casse {
	/**
	 * Convertit un caractère en majuscule.
	 * 
	 * @param c un caractère
	 * @return le caractère en majuscule
	 * 
	 */
	private static char majuscule(char c) {
		// ! Force au caractère spéciaux...
		return c >= 'a' && c <= 'z' ? (char) (c - 32) : c;
	}
	
	/**
	 * Convertit une chaîne de caractères en majuscules.
	 * Version ITERATIVE
	 * 
	 * @param txt une chaîne de caractères
	 * @return la chaîne de caractères en majuscules
	 */
	public static String majusculeIteratif(String txt) {
		// String
		// txt.toUpperCase() // NOOOO

		// ça c'est mieux et super opti...
		String response = "";
		for(char c : txt.toCharArray()) {
			response += majuscule(c);
		}
		return response;  // <- A modifier !
	}
	
	/**
	 * Convertit une chaîne de caractères en majuscules.
	 * Version RECURSIVE
	 * 
	 * @param txt une chaîne de caractères
	 * @return la chaîne de caractères en majuscules
	 */
	public static String majusculeRecursif(String txt) {
		// J'ai été voir le corrigé parvce que personne ferait cette saloperie...
		if (txt.length() == 0) {
			return "";
		} else {
			return majuscule(txt.charAt(0)) + majusculeRecursif(txt.substring(1));
		}
	}
	
	/**
	 * Convertit un caractère en minuscule.
	 * 
	 * @param c un caractère
	 * @return le caractère en minuscule
	 */
	private static char minuscule(char c) {
		// ! Force au caractère spéciaux...
		return c >= 'A' && c <= 'Z' ? (char) (c + 32) : c;
	}
	
	/**
	 * Convertit une chaîne de caractères en minuscules.
	 * Version ITERATIVE
	 * 
	 * @param txt une chaîne de caractères
	 * @return la chaîne de caractères en minuscules
	 */
	public static String minusculeIteratif(String txt) {
		// String
		// txt.toUpperCase() // NOOOO

		// ça c'est mieux et super opti...
		String response = "";
		for(char c : txt.toCharArray()) {
			response += minuscule(c);
		}
		return response;  // <- A modifier !
	}
	
	/**
	 * Convertit une chaîne de caractères en minuscules.
	 * Version RECURSIVE
	 * 
	 * @param txt une chaîne de caractères
	 * @return la chaîne de caractères en minuscules
	 */
	public static String minusculeRecursif(String txt) {
		// J'ai changé les fonctions...
		if (txt.length() == 0) {
			return "";
		} else {
			return minuscule(txt.charAt(0)) + minusculeRecursif(txt.substring(1));
		}
	}	
}
