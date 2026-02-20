package labs.labo2;

import io.Console;

public class HeuresPrestees {

    private static final double TARIF_HEURE = 128.50;
    private static int toutesHeures = 0;
    private static int toutesMinutes = 0;



    private static void recupererTemps(String jour) {
        int separation = jour.indexOf(":");
        int heures = Integer.parseInt(jour.substring(0, separation));
        int minutes = Integer.parseInt(jour.substring(separation+1, jour.length()));


        toutesHeures = toutesHeures + heures;
        toutesMinutes = toutesMinutes + minutes;
    }

    public static void main(String[] args) {
        
        double argent = 0;
        String lundiTemps, mardiTemps, mercrediTemps, jeudiTemps, vendrediTemps;

        lundiTemps = Console.lireString("Lundi ? ");
        mardiTemps = Console.lireString("Mardi ? ");
        mercrediTemps = Console.lireString("Mercredi ? ");
        jeudiTemps = Console.lireString("Jeudi ? ");
        vendrediTemps = Console.lireString("Vendredi ? ");
        recupererTemps(lundiTemps);
        recupererTemps(mardiTemps);
        recupererTemps(mercrediTemps);
        recupererTemps(jeudiTemps);
        recupererTemps(vendrediTemps);

        toutesHeures = toutesHeures + (toutesMinutes / 60);
        toutesMinutes = toutesMinutes % 60;

        argent = argent + toutesHeures * TARIF_HEURE;
        argent = argent + (toutesMinutes) * (TARIF_HEURE / 60) ;
        argent = Math.round(argent * 100);
        argent = argent / 100;

        System.out.println("Heures prestées : " +  toutesHeures +"h " + toutesMinutes + "min");
        System.out.println("Montant à facturer : " + argent + " EUR");
    }
}
