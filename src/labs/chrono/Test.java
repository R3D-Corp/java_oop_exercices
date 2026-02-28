package labs.chrono;

public class Test {
    
    public static void main(String[] args) {
		// 1️. Création de deux chronomètres
        Chronometre c1 = new Chronometre(1, 20, 30);
        Chronometre c2 = new Chronometre(0, 45, 50);
		
		System.out.println("=== Valeurs initiales ===");

        System.out.println(c1.toString());
        System.out.println(c2.toString());

		// 2️.a. Manipulations sur chrono1


		c1.addSecond(4800);
		c1.addMinute(10);
        System.out.println("=== Après modifications de chrono1 ===");
		System.out.println(c1.toString());


		// 2.b. Manipulations sur chrono2
		c2.addMinute(70);
		c2.addHour(1);
		System.out.println("=== Après modifications de chrono2 ===");
		System.out.println(c2.toString());

		// 3. Comparaison des deux chronomètres
		int result = c1.compare(c2);
		System.out.println("=== Comparaison ===");
		if(result < 0) {
			System.out.println("c2 est plus grand");
		} else if (result > 0) {
			System.out.println("c1 est plus grand");
		} else {
			System.out.println("Les deux sont égaux");
		}

		// 4.a. Afficher le temps total en secondes de chaque chronomètre
		System.out.println("=== Temps total en secondes ===");
		System.out.println(c1.toSeconds());
		System.out.println(c2.toSeconds());

		// 4.b. Réinitialisation de chrono2
		c2.reset();
		System.out.println("=== Après réinitialisation de chrono2 ===");
		System.out.println(c2.toString());

		// 4.c. Vérification si l’un des chronomètres est au maximum
		System.out.println("=== Vérification du maximum ===");
		System.out.println(c1.isMax());
		System.out.println(c2.isMax());
    }
}
