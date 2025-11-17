package labo5;

import io.Console;
import util.Aleatoire;

public class Casino {
    
    public static void main(String[] args) {

        int argent = 20;
        int partiesJouer = 0;

        final int ARGENT_A_JOUER = Console.lireInt("Argent de départ ? ");
        final int TOTAL_VOULU = Console.lireInt("Gain souhaités ? ");
        argent = ARGENT_A_JOUER;

        if(ARGENT_A_JOUER == 0 || TOTAL_VOULU == 0) {
            System.out.println("On ne joue pas sans argent et sans éspoir.");
            return;
        } 

        while(argent < (ARGENT_A_JOUER + TOTAL_VOULU) && argent > 0) {
            partiesJouer++;
            
            if(Aleatoire.aleatoire(1, 2) == 1) {
                argent = argent + 2;
            } else {
                argent--;
            }
        }
        System.out.printf("Vous avez jouer %s paris\n", partiesJouer);
        if(argent == 0) {
            System.out.printf("Vous repartez avec %s de moins", ARGENT_A_JOUER);
        } else if(argent == (ARGENT_A_JOUER + TOTAL_VOULU)) {
            System.out.printf("Vous repartez avec %s de plus", TOTAL_VOULU);
        }
    }
}
