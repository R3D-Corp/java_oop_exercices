package labs.labo5;

import io.Console;
import util.Aleatoire;

public class Dice {
    public static void main(String[] args) {

        int voulu = Console.lireInt("Numéro de 1 à 6 ? ");
        int resultat = 0;
        int lancer = 0;

        do {
            lancer++;
            resultat = Aleatoire.aleatoire(1, 6);
            System.out.println(resultat);
        }
        while (resultat != voulu);
        System.out.printf("Nombre de lancés : %s", lancer);
    }
}
