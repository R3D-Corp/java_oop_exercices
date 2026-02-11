package prb.labo4;

import prb.io.Console;

public class Lendemain {

    public static String getDate() {
        String currentDate;

        currentDate = Console.lireString("Quelle est la date d'aujourd'hui ? ");
        if(!Date.estValide(currentDate)) {
            System.out.println("Date invalide...");
            getDate();
        };

        return currentDate;
    }

    public static void main(String[] args) {
        int jour, mois, annee;
        String currentDate = getDate();

        jour = Date.getJour(currentDate);
        mois = Date.getMois(currentDate);
        annee = Date.getAnnee(currentDate);
        if(jour == Date.joursParMois(mois, annee)) {
            jour = 1;
            mois++;
            if(mois == 13) {
                mois = 1;
                annee++;
            }
        } else {
            jour++;
        }
        String tomorowDate = Date.formaterDate(jour, mois, annee);
        System.out.printf("Demain sera le %s", tomorowDate);
    }
}