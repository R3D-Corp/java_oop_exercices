package labs.math.mod.chiffrementAffine;


/**
 * Chiffrement/déchiffrement affine.
 * 
 */
import java.util.Scanner;

import labs.math.mod.calculatrice.CalculatriceModulaire;
import util.logs.LogEntry;
import util.logs.LogsManager;


public class ChiffrementAffine {
    private static final LogsManager MANAGER = new LogsManager("math_affine", true);

	/**
     * Chiffre un texte donné à l'aide du chiffrement affine : 
     * 
     * C(x) = (a * x + b) mod 26
     * 
     * Les caractères sont convertis en nombres en appliquant la règle 
     * A = 0, B = 1, C = 2, ..., Z = 25.
     * 
     * NB : le texte renvoyé sera en majuscules.
     *
     * @param texte le texte à chiffrer
     * @param a un entier positif premier avec 26
     * @param b un entier positif quelconque
     * @return le message chiffré.
     */
    public static String chiffrer(String texte, int a, int b) {
        StringBuilder builder = new StringBuilder();
        char[] chars = texte.toCharArray();

        for(char c : chars) {
            if(!Character.isUpperCase(c)) {
                c = Character.toUpperCase(c);
            }

            if(Character.isAlphabetic(c)) {
                int x = c - 64;
                x -= 1;
                int f = ((a * x) + b) % 26;
                f += 1;
                char encodedChar = (char) (f + 64);
                builder.append(encodedChar);
            } else builder.append(c);
        }

        return builder.toString();   // <- A modifier !!!
    }

    
    /**
     * Déchiffre un message donné à l'aide du chiffrement affine : 
     * 
     * D(y) = a^-1 * (y - b) mod 26
     * 
     * Les caractères sont convertis en nombres en appliquant la règle 
     * A = 0, B = 1, C = 2, ..., Z = 25.
     * 
     * NB : le texte renvoyé sera en majuscules.
     *
     * @param message le message à déchiffrer
     * @param a un entier positif premier avec 26
     * @param b un entier positif quelconque
     * @return le message déchiffré sous la forme d'une chaîne de caractères.
     */
    public static String dechiffrer(String texte, int a, int b) {
        StringBuilder builder = new StringBuilder();
        char[] chars = texte.toCharArray();

        for(char c : chars) {
            if(!Character.isUpperCase(c)) {
                c = Character.toUpperCase(c);
            }

            if(Character.isAlphabetic(c)) {
                int x = c - 64;
                x -= 1;
                int f = ((int) (CalculatriceModulaire.inverseModulaire(a, 26)) * (x - b)) % 26;
                if(f < 0) f+=26;
                f += 1;
                char encodedChar = (char) (f + 64);
    
                
                MANAGER.addLog(LogEntry.createLogFromArray(texte, new String[][] {
                    {"x : ", "" + x},
                    {"f : ", "" + f},
                    {"decoded char : ", "" + encodedChar}
                }));
                builder.append(encodedChar);
            } else builder.append(c);
        }

        return builder.toString();   // <- A modifier !!!
    }

    
    /**
	 * Programme principal (voir exemples d'exécution dans l'énoncé)
	 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dechiffrer("CHLZMBGD", 53, 25);
        sc.close();
    }
}
