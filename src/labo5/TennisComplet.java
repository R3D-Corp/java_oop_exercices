package labo5;

import io.Console;

public class TennisComplet {
    public static String getScore(int points) {
        switch(points) {
            case 0:
                return "0";
            case 1: 
                return "15";
            case 2:
                return "30";
            case 3:
                return "40";
            case 4:
                return "A";
            default:
                return "?";
        }
    }

    public static void main(String[] args) {
        String joueur1, joueur2;
        boolean finish = false;
        int pointJoueur1, pointJoueur2;

        joueur1 = Console.lireString("Joueur 1 ? ");
        joueur2 = Console.lireString("Joueur 2 ? ");
        pointJoueur1 = 0;
        pointJoueur2 = 0;

        System.out.println(getScore(0));

        while(!finish) {
            System.out.printf("%-10s%-10s\n", joueur1, getScore(pointJoueur1));
            System.out.printf("%-10s%-10s\n", joueur2, getScore(pointJoueur2));

            String gagnant = Console.lireString("Quel joueur gagne le point (1 ou 2) ? ");

            switch(gagnant) {
                case "1": 
                    pointJoueur1++;
                    break;
                case "2":
                    pointJoueur2++;
                    break;
            }

            if(pointJoueur1 == pointJoueur2 && (pointJoueur1 >= 4 || pointJoueur2 >= 4)) {
                pointJoueur1 = 3;
                pointJoueur2 = 3;
            }
            if(pointJoueur1 == 5) {
                System.out.printf("%s Remporte le jeu\n", joueur1);
                break;
            }
        }
    }
}
