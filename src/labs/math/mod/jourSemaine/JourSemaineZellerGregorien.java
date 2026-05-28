package labs.math.mod.jourSemaine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.Console;

/**
 * Trouver le jour de la semaine d'une date donnée.
 * 
 * Algorithme de Zeller, pour le calendrier grégorien.
 * 
 */

public class JourSemaineZellerGregorien {
	private static String[] DAYS_NAME = new String[] {"samedi", "dimanche", "lundi", "mardi", "mercredi", "jeudi", "vendredi"}; 
	
	/**
	 * Détermine le jour de la semaine d'une date du calendrier grégorien
	 * en utilisant l'algorithme de Zeller.
	 *
	 * <p>L'algorithme de Zeller calcule le jour de la semaine à partir d'une date
	 * sous forme de trois entiers (jour, mois, année). Les mois de janvier et février
	 * sont traités comme les mois 13 et 14 de l'année précédente.</p>
	 *
	 * @param jour  le jour du mois 
	 * @param mois  le mois de l'année (1 = janvier, ..., 12 = décembre)
	 * @param annee l'année complète (ex. : 2026)
	 * @return le nom du jour de la semaine correspondant à la date fournie.
	 */	
	public static String jourZellerGregorien(int jour, int mois, int annee) {
		if(mois == 1) { 
			mois = 13;
			annee = annee-1;
		}
		if(mois == 2) {
			mois = 14;
			annee = annee - 1;
		}
		int K = annee % 100;
		int J = annee / 100;


		int partOne = ((13 * (mois + 1)) / 5);
		int partTwo = (K + (K / 4));
		int partThree = ((J/4) - (2 * J));
		int r = (jour+ partOne + partTwo + partThree) % 7;

		if(r < 0) {
			r += 7;
		}

        return DAYS_NAME[r];
    }
    
    
    /**
	 * Programme principal (voir exemple d'exécution dans l'énoncé)
	 */
    public static void main(String[] args) {
		String regex = "\\d{2}/\\d{2}/\\d{4}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;
		String yourDate;
		do {
			yourDate = Console.lireString("Votre date (jj/mm/aaaa)");
			matcher = pattern.matcher(yourDate);

		} while(!matcher.find());

		String[] parts = yourDate.split("\\/");
		int[] numbers = new int[parts.length];
		
		for(int i=0; i<parts.length; i++) {
			String part = parts[i];
			System.out.println(parts);
			numbers[i] = Integer.parseInt(part);
		}

		System.out.println(jourZellerGregorien(numbers[0], numbers[1], numbers[2]));
    }
}
	