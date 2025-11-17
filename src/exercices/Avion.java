package exercices;

import io.Console;

public class Avion {
    public static void main(String[] args) {
        int vitesseAvion, vitesseVent, distance, heure, minutes;
        float vitesseTotAller, vitesseTotRetour;

        double tempsSecondes;

        distance = Console.lireInt("Distance à parcourir (en km) ? ") * 1000;
        vitesseAvion = Console.lireInt("Vitesse de l'avion (en km/h) ? ");
        vitesseVent = Console.lireInt("Vitesse du vent a l'aller (en km/h) ? ");


        // Calcul des vitesses en mètres par secondes.
        vitesseTotAller = (vitesseAvion + vitesseVent) / 3.6f;
        vitesseTotRetour = (vitesseAvion - vitesseVent) / 3.6f;


        // Calcul durée a l'aller.
        
        tempsSecondes = distance / vitesseTotAller;

        heure = (int)tempsSecondes / 3600;
        tempsSecondes = tempsSecondes % 3600;
        minutes = (int)tempsSecondes / 60;
        System.out.printf("Durée vol aller %dh%dmin%ds", heure, minutes, (int) minutes % 60);

        tempsSecondes = distance / vitesseTotRetour;

        heure = (int)tempsSecondes / 3600;
        tempsSecondes = tempsSecondes % 3600;
        minutes = (int)tempsSecondes / 60;
        System.out.printf("Durée vol retour %dh%dmin%ds", heure, minutes, (int) minutes % 60);
    }
}