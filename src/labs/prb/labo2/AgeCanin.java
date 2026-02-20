package labs.prb.labo2;

import labs.prb.io.Console;

public class AgeCanin {
    public static void main(String[] args) {
        String nomChien = Console.lireString("Nom de votre chien ? ");
        double ageChien = Console.lireDouble("Âge de votre chien (en années) ? ");

        int ageChienHumain = (int)(16 * Math.log(ageChien) + 31);
        ageChienHumain = Math.round(ageChienHumain);
        System.out.println(nomChien + " aurait " + ageChienHumain + "ans si il était un humain");
        
    }
}