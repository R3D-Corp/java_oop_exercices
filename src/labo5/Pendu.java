package labo5;

import io.Console;
import util.Aleatoire;
import util.Dictionnaire;

public class Pendu {


    public static final String REGEX = "^[a-zA-Z]";

    private static final String[][] GAME_FORMAT = {
        {" _____", " |", " |", " |", " |", "_|_"}, 
        {" _____", " |  |", " |", " |", " |", "_|_"}, 
        {" _____", " |  |", " |  o", " |", " |", "_|_"}, 
        {" _____", " |  |", " |  o", " |  |", " |", "_|_"}, 
        {" _____", " |  |", " |  o", " |/ | \\", " | / \\", "_|_"}, 
    };

    public static void afficherJeu(int i, String motJouer) {
        IO.println(i);
        for(String s : GAME_FORMAT[i]) {
            IO.println(s);
        }
        IO.println(motJouer);
    }

    public static String genererMot(String correctWord) {
        String s = "";
        for(int i=0; i<correctWord.length(); i++) {
            s += "-";
        }
        return s;
    }

    public static boolean verifierMot(String correctWord, String currentWord, char guessedChar) {
        boolean founded = false;

        for(int i=0; i<currentWord.length(); i++) {
            char c = currentWord.charAt(i);
            if(c == '-' && correctWord.charAt(i) == guessedChar) {
                founded = true;
                break;
            }
        }
        return founded;
    }

    public static String revellerLettre(String correctWord, String currentWord, char guessedChar) {
        String s = "";

        for(int i=0; i<currentWord.length(); i++) {
            char c = currentWord.charAt(i);
            if(c == '-') {
                if(correctWord.charAt(i) == guessedChar) {
                    s += guessedChar;
                } else {
                    s += "-";
                };
            } else {
                s += c;
            }
        }
        return s;
    }


    public static void main(String[] args) {
        int numberError = 0;
        String mot = Dictionnaire.getMot(Aleatoire.aleatoire(0, Dictionnaire.getNumMots())).toLowerCase(); 
        String motJouer = genererMot(mot);

        do {
            afficherJeu(numberError, motJouer);
            char c = Console.lireStringWhile("Une Lettre ? ", "Lettre incorrecte", REGEX).charAt(0);
            if(verifierMot(mot, motJouer, c)) {
                motJouer = revellerLettre(mot, motJouer, c);
            } else {
                IO.println("hein");
                numberError++;
            }
        } while(motJouer.contains("-") && numberError < GAME_FORMAT.length);
    }
}
