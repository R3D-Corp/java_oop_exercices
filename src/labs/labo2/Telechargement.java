package labs.labo2;

import io.Console;

public class Telechargement {
    public static void main(String[] args) {
        double taille = Console.lireDouble("Taille de votre fichier en Mo ? ");
        double debit = Console.lireDouble("Debit de votre connexion en Mbps ? ");

        taille = taille * 8;

        int temps, heures, minutes, secondes;
        temps = (int)Math.round(taille / debit);
        heures = (temps / 3600);
        temps = temps % 3600;
        minutes = temps / 60;
        secondes = temps % 60;
        System.out.println("il faudra " + temps + " secondes");
        System.out.println(heures+"h "+minutes+"min "+secondes+"s");
    }
}


