package prb.labo4;

import prb.io.Console;

public class FaireUneSieste {
    public static final String FAIRE_UNE_SIESTE = "Faites une sieste (zzz... zzz...)";
    public static final String NE_PAS_FAIRE_UNE_SIESTE = "Ne faites pas de sieste (soupir)";

    public static boolean choixBinaire(String question) {
        String reponse = Console.lireString(String.format("%s (oui/non) ? ", question)).trim().toLowerCase();
        
        if(reponse.equals("oui") || reponse.equals("o")) {
            return true;
        } else if(reponse.equals("non") || reponse.equals("n")) {
            return false;
        }
        choixBinaire(question);
        return false;
    }

    private static void nePasDormir() {
        System.out.println(NE_PAS_FAIRE_UNE_SIESTE);
        return;
    }
    private static void Dormir() {
        System.out.println(FAIRE_UNE_SIESTE);
        return;
    }

    public static void main(String[] args) {
        boolean fatigue = false;

        fatigue = choixBinaire("Êtes vous très fatigué.e");

        if (fatigue) {
            boolean troubles = choixBinaire("Avez-vous des troubles du sommeil ?");
            if (troubles) {
                nePasDormir();
                return;
            }
        }

        boolean tard = choixBinaire("Est-il plus tard que 16h ?");
        if (tard) {
            nePasDormir();
            return;
        }

        boolean travail = choixBinaire("Êtes-vous au travail ?");
        if (travail) {
            boolean patron = choixBinaire("Votre patron se fâchera-t-il si vous faites une sieste ?");
            if (patron) {
                nePasDormir();
                return;
            }
        }

        boolean trenteMin = choixBinaire("Disposez-vous de 30 minutes ?");
        if (trenteMin) {
            Dormir();
            return;
        }

        boolean dixMin = choixBinaire("Disposez-vous de 10 minutes ?");
        if (dixMin) {
            Dormir();
        } else {
            nePasDormir();
        }
    }

    
}
