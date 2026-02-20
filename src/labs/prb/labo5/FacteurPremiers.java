package labs.prb.labo5;

import io.Console;

public class FacteurPremiers {


    private static boolean estPremier(int entier) {
        if (entier < 2) return false;
        for(int i = 2; i <= Math.sqrt(entier); i++)  {
            if(entier % i == 0) return false;
        }
        return true;
    }

    private static void decompose(int toDecompose, String s) {
        int i;
        String finalResult = s;

        for(i = 2; i <= toDecompose; i++) {
            if(toDecompose % i != 0) continue;
            if(estPremier(i)) {
                if(finalResult.length() > 0) {
                    finalResult += " ";
                }
                finalResult += i;
                break;
            }
        }

        if(toDecompose / i != 1) decompose(toDecompose / i, finalResult);
        if(toDecompose / i == 1) System.out.println(finalResult);
    }

    public static void main(String[] args) {
        int entier = Console.lireInt("Entier >= 2 ? ");
        decompose(entier, "");
    }
}
