package labs.labo4;

import io.Console;

public class DroiteRa {

    public static void main(String[] args) {
        // Variable
        String coordPoint;
        double xA, yA, xB, yB, coefAB, coefAB2;
        // Acquisition
        // Droite 1
        coordPoint = Console.lireString("Coordonnée du point A (a b) ? ");
        xA = DroiteRa.lireCoordX(coordPoint);
        yA = DroiteRa.lireCoordY(coordPoint);
        coordPoint = Console.lireString("Coordonnée du point B (a b) ? ");
        xB = DroiteRa.lireCoordX(coordPoint);
        yB = DroiteRa.lireCoordY(coordPoint);
        coefAB = DroiteRa.coefficientDirecteur(xA, yA, xB, yB);
        // Droite 2
        coordPoint = Console.lireString("Coordonnée du point C (a b) ? ");
        xA = DroiteRa.lireCoordX(coordPoint);
        yA = DroiteRa.lireCoordY(coordPoint);
        coordPoint = Console.lireString("Coordonnée du point d (a b) ? ");
        xB = DroiteRa.lireCoordX(coordPoint);
        yB = DroiteRa.lireCoordY(coordPoint);
        coefAB2 = DroiteRa.coefficientDirecteur(xA, yA, xB, yB);
        // Affichage des résultats
        if (coefAB == coefAB2) {
            System.out.printf("les deux droites sont parrallèles");
        } else if (coefAB * coefAB2 == -1) {
            System.out.printf("Les deux droites sont perpenduclaires");
        } else {
            System.out.printf("Les deux droites sont scécante");
        }
    }

    public static double lireCoordX(String coordPoint) {
        int placeEspace;
        String str;
        placeEspace = coordPoint.indexOf(' ');
        str = coordPoint.substring(0, placeEspace);
        return Integer.parseInt(str);
    }

    public static double lireCoordY(String coordPoint) {
        int placeEspace;
        String str;
        placeEspace = coordPoint.indexOf(' ');
        str = coordPoint.substring(placeEspace++);
        return Integer.parseInt(str);
    }

    public static double coefficientDirecteur(double xA, double yA, double xB, double yB) {
        if (yB == yA && xB == xA) {
            return Double.NaN;
        } else if ((yB - yA) / (xB - xA) == 0.000) {
            return Double.POSITIVE_INFINITY;
        } else {
            return (((yB - yA) / (xB - xA)) * 1.000);
        }
    }

}