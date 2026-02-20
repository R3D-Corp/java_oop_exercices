package labs.prb.labo4;

import io.Console;

public class Droites {

    /**
     * Récupère la valeur X à partir d'une chaîne de coordonnées "X Y".
     * 
     * @param Coordonee Chaîne de caractère de format : "X Y"
     * @return La valeur de X de Coordonee convertie en double.
     */
    public static double lireCoordX(String Coordonee) {
        String[] X_Y = Coordonee.split("\s");
        double X = Double.parseDouble(X_Y[0]);

        return X;
    }

    /**
     * Récupère la valeur Y à partir d'une chaîne de coordonnées "X Y".
     * 
     * @param Coordonee Chaîne de caractère de format : "X Y"
     * @return La valeur de Y de Coordonee convertie en double.
     */
    public static double lireCoordY(String Coordonee) {
        String[] X_Y = Coordonee.split("\s");
        double Y = Double.parseDouble(X_Y[1]);

        return Y;
    }

    private static String[] obtenirPoints() {
        String point1, point2;

        point1 = Console.lireString("Coordonnée du point 1 (X Y) ? ");
        point2 = Console.lireString("Coordonnée du point 2 (X Y) ? ");

        return new String[] { point1, point2 };
    }

    public static double coefficientDirecteur(double X_A, double Y_A, double X_B, double Y_B) {

        if (X_A == X_B && Y_A == Y_B) return Double.NaN;
        if(Y_A == Y_B) return Double.POSITIVE_INFINITY;

        double pente = (Y_A - Y_B) / (X_A - X_B);
        return pente;
    }

    private static double droites(int numb) throws ArithmeticException {
        String[] points;
        String point1, point2;
        double X_A, Y_A, X_B, Y_B, pente;

        System.out.printf("Droite %s : \n", numb);
        points = obtenirPoints();
        point1 = points[0];
        point2 = points[1];

        X_A = lireCoordX(point1);
        Y_A = lireCoordY(point1);
        X_B = lireCoordX(point2);
        Y_B = lireCoordY(point2);
        pente = (Y_A - Y_B) / (X_A - X_B);

        if(Double.isNaN(pente)) throw new ArithmeticException("La droite " + numb + " est un point unique");
        return pente;
    }


    public static void main(String[] args) {
        double pente1, pente2;

        // Droite 1;
        pente1 = droites(1);
        System.out.println("pente 1 : "  + pente1);
        // Droite 2;
        pente2 = droites(2);
        System.out.println("pente 2 : "  + pente2);

        if(pente1 == pente2) {
            System.out.println("Droite parallèle");
            return;
        }

        if(pente1 * pente2 == -1) {
            System.out.println("Droite perpendiculaire");
            return;
        }
        System.out.println("Les droites sont sécantes");
        return;
    }
}
