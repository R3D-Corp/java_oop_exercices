package labs.algo.labo3.remplacement;

import java.util.Map;

public class RemplacementMot {

	/*
	 * Voici comment vous pouvez facilement créer un dictionnaire : l'interface Map contient des méthodes de fabrique statique:
	 * - ofEntries
	 * - entry
	 * Je vous laisse lire la doc pour en savoir plus.
	 */
	public static Map<String, String> DICT = Map.ofEntries(
		Map.entry("madame", "monsieur"),
		Map.entry("voiture", "train"),
		Map.entry("magic", "yugioh"),
		Map.entry("coca-cola", "café noir"),
		Map.entry("ocarina", "masque")
	);

	public static String replaceAll(String s, Map<String, String> dict) {
		for(Map.Entry<String, String> entry : dict.entrySet()) { // Go through every entry.
			s = s.replace(entry.getKey(), entry.getValue()); // Replace.
		}
		return s;
	}

	public static String translate(String s, Map<String, String> dict) {
		String result = s;
		String old;
		int limitRun = 0;

		do {
			old = result;
			result = replaceAll(old, dict);
			limitRun++;
		} while(!result.equals(old) && limitRun <= 15);

		return result;
	}

	public static void main(String[] args) {
		System.out.println(replaceAll("madame monsieur, votre voiture est magic vous y buvez un coca-cola en écoutant un joueur d'ocarina", DICT));
	}
}
