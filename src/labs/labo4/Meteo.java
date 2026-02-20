package labs.labo4;

import io.Console;

public class Meteo {

    /**
     * Fonction, qui décide quelle vêtement apporté pour votre sortie.
     * @param Temperature Température en degré Celsius a l'éxtérieur;
     */

    private static void monVetement(double Temperature) {
        
        if(Temperature >= 16) {
            // FAIT BEAU
            char sunshine = Console.lireChar("Fait t'il ensoleillé (o/n) ? ");
            switch(sunshine) {
                case 'o': 
                    System.out.println("Vous devriez prendre un T-Shirt ! ");
                    break;
                case 'n':
                    System.out.println("Vous devriez prendre un Pull ! ");
                    break;
                default:
                    System.out.println("Erreur");
                    monVetement(Temperature);
            }
        } else {
            char raining = Console.lireChar("Pleut t'il (o/n) ? ");
            switch(raining) {
                case 'o': 
                    System.out.println("Vous devriez prendre un parapluie ! ");
                    break;
                case 'n':
                    System.out.println("Vous devriez prendre un manteau ! ");
                    break;
                default: 
                    System.out.println("Erreur");
                    monVetement(Temperature);
            }
        }
    
    }

    public static void main(String[] args) {
        double temperature;

        temperature = Console.lireDouble("Quelle est le température (°C) ? ");
        monVetement(temperature);
    }
}  
