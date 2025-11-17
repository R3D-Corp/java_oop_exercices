package labo4;

import io.Console;
import util.Date;

public class Annivesaire {

    private static int[] convertirDate(String annivesaire) {
        String[] values = annivesaire.split("/");
        int[] dateConvertie = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            dateConvertie[i] = Integer.parseInt(values[i]);
        }

        return dateConvertie;
    }

    public static void main(String[] args) {
        String anniversaire;
        int[] anniversaireConvertie, ajdConvertie;
        int numeroAnniversaire, numeroAjd;

        final int ANNEE_AJD = Date.anneeAuj();
        final String DATE_AJD = "23/07";

        anniversaire = Console.lireString("La date de votre anniversaire (j/m) ?"); 
        
        ajdConvertie = convertirDate(DATE_AJD);
        anniversaireConvertie = convertirDate(anniversaire);

        numeroAnniversaire = Date.numeroJour(anniversaireConvertie[0], anniversaireConvertie[1], ANNEE_AJD); 
        numeroAjd = Date.numeroJour(ajdConvertie[0], ajdConvertie[1], ANNEE_AJD);


        int deltaDate = numeroAjd - numeroAnniversaire;

        if(deltaDate == 0) {
            // Anniversaire
            System.out.println("C'est votre anniversaire ! ");
        } else if((deltaDate < 31 & deltaDate > 0) || (deltaDate > -(365 -31) && deltaDate < 0)) {
            // Anniversaire approche
            System.out.println("Hourra ! Votre anniversaire approche");
        } else {
            // Anniversaire loinnnn;
            System.out.println("On est loin la !");
        }

    }
}