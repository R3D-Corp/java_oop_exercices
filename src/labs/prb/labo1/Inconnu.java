package labs.prb.labo1;

public class Inconnu {
	
	private static void afficher(int nombre, int somme, int chiffre) {
		System.out.println("nombre : " + nombre + ", " + "somme : " + somme + ", " + "chiffre : " + chiffre);
	}

	public static void main(String[] args) {
		int nombre = 7805;
		int somme = 0;
		int chiffre;
		
		chiffre = nombre % 10;
		somme = somme + chiffre;
		nombre = nombre / 10;
		afficher(nombre, somme, chiffre);

		chiffre = nombre % 10;
		somme = somme + chiffre;
		nombre = nombre / 10;
		afficher(nombre, somme, chiffre);

		chiffre = nombre % 10;
		somme = somme + chiffre;
		nombre = nombre / 10;
		afficher(nombre, somme, chiffre);

		
		chiffre = nombre % 10;
		somme = somme + chiffre;
		nombre = nombre / 10;
		afficher(nombre, somme, chiffre);
		
		System.out.println(somme);
	}
	
}