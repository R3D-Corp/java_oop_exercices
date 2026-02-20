package labs.prb.labo1;

public class JourDeLaSemaine {
	public static void main(String[] args) {
		int jour= 30,mois = 9, annee = 2024;
		
		int anneeEnCours, a, b, m;
		
		int jourDeLaSemaine;
		
		anneeEnCours = (14 - mois) / 12;
		a = annee - anneeEnCours;
		b = a + a / 4 - a / 100 + a / 400;
		m = mois + 12 * anneeEnCours - 2;
		jourDeLaSemaine = (jour + b + 31 * m /12) % 7;
		
		System.out.println(jourDeLaSemaine);
	}
}