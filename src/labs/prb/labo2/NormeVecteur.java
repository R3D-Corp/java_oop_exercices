package labs.prb.labo2;

import io.Console;

public class NormeVecteur {
    public static void main(String[] args) {
        double compX, compY, norme;
        compX = Console.lireDouble("Composante X du vecteur ? ");
        compY = Console.lireDouble("Composante Y du vecteur ? ");

        compX = Math.pow(compX, 2);
        compY = Math.pow(compY, 2);
        norme = (Math.round(Math.sqrt(compX+compY) * 10));
        norme = norme / 10;
        System.out.printf("La norme du vecteur (%s, %s) vaut %s", compX, compY, norme);

    }
}