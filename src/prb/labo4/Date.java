package prb.labo4;

public class Date {

    public static int getJour(String date) {
        String[] data = date.split("/");

        return Integer.parseInt(data[0]);
    }

    public static int getMois(String date) {
        String[] data = date.split("/");

        return Integer.parseInt(data[1]);
    }

    public static int getAnnee(String date) {
        String[] data = date.split("/");

        return Integer.parseInt(data[2]);
    }

    public static boolean estBissextile(int annee) {
        if(annee % 4 == 0) return true;

        return false;
    }

    public static boolean estValide(String date) {
        int jour, mois, annee;

        jour = getJour(date);
        mois = getMois(date);
        annee = getAnnee(date);
        if(mois>0 && mois <= 12 && annee>0) {
            if(jour>0 && jour <= joursParMois(mois, annee)) {
                return true;
            }
        }
        return false;
    }


    public static int joursParMois(int mois, int annee) {
        switch(mois) {
            case 1: // Janvier
            case 3: // Mars
            case 5: // Mai
            case 7: // Juillet
            case 8: // Aout
            case 10: // Octobre
            case 12: // Décembre
                return 31;

            case 4: // Avril
            case 6: // Juin
            case 9: // Septembre
            case 11: 
                return 30;
            case 2: 
                return estBissextile(annee) ? 29 : 28;

            default: 
                return 0;
        }

    }

    public static String formaterDate(int jour, int mois, int annee) {
        return String.format("%02d/%02d/%04d", jour, mois, annee);
    }
}
