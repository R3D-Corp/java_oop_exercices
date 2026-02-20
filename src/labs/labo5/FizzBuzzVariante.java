package labs.labo5;

import io.Console;

public class FizzBuzzVariante {
    
    /**
     * Fonction qui vérifie si un entier contient un chiffre spécifique
     * @param entier Entier a vérifier
     * @param voulu Chiffrre recherché dans le nombre
     * @return boolean disant si le nombre contient le chiffre
     */
    private static boolean hasNumber(int entier, int voulu) {
        String s = String.valueOf(entier);

        if(s.contains(String.valueOf(voulu))) return true;
        return false;
    }

    public static void main(String[] args) {
        int dernierNombre = Console.lireInt("Dernier nombre ? ");
        String resultat = "";

        for(int i=1; i<=dernierNombre; i++) {
            if(i!=1) resultat += ",";

            boolean hasThree, hasFive;

            hasThree = hasNumber(i, 3);
            hasFive = hasNumber(i, 5);

            if(hasThree) resultat += "fizz";
            if(hasFive) resultat += "buzz";

            if(!hasThree && !hasFive) resultat += i;
        }

        System.out.println(resultat);
    }
}
