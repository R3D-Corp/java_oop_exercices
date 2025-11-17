package labo5;

import io.Console;
import io.Fichier;

public class Ldvelh {
    
    public static char lireChoix(String question, String choixAdmis) {
        char userChoice = Console.lireChar(question);

        if (!choixAdmis.contains(String.valueOf(userChoice))) {
            System.out.println("Choix incorrect ! Veuillez recommencer... ");
            return lireChoix(question, choixAdmis);
        }
        return userChoice;
    }
    
    public static void main(String[] args) {
        final String FILE_PATH = "./data/labo5/ldvelh.txt";

        String histoire = Fichier.lireString(FILE_PATH, "intro");
        String chemin = "choix";

        while(!histoire.endsWith("FIN\n")) {
            System.out.println(histoire);
            
            chemin += "-";
            chemin += lireChoix("Que choisis-tu (A ou B) ? ", "AaBb");
            histoire = Fichier.lireString(FILE_PATH, chemin);
        }
        System.out.println(histoire);
    }
}