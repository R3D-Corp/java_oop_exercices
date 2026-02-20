package labs.prb.labo3;

import io.Console;


/**
 * This class with no build func, execute at main code a time addition between two Strings predefinded
 */
public class AdditionDurees {
    public static void main(String[] args) {

        System.out.println("Respectez ce format : h min s");
        System.out.println("Exemple : 6h 21min 30s");
        String duree1 = Console.lireString("Durée 1 ? ");
        String duree2 = Console.lireString("Durée 2 ? ");

        int hT, mT, sT;
        int h, m, s;
        int h1, m1, s1, h2, m2, s2;
        int d1, d2, dT;

        h = duree1.indexOf("h");
        m = duree1.indexOf("min");
        s = duree1.indexOf("s");

        h1 = Integer.parseInt(duree1.substring(0, h).trim());
        m1 = Integer.parseInt(duree1.substring(h + 1, m).trim());
        s1 = Integer.parseInt(duree1.substring(m + 3, s).trim());

        h = duree2.indexOf("h");
        m = duree2.indexOf("min");
        s = duree2.indexOf("s");

        h2 = Integer.parseInt(duree2.substring(0, h).trim());
        m2 = Integer.parseInt(duree2.substring(h + 1, m).trim());
        s2 = Integer.parseInt(duree2.substring(m + 3, s).trim());

        d1 = h1 * 3600 + m1 * 60 + s1;
        d2 = (int) (h2 * 3600.0 + m2 * 60 + s2);
        dT = d1 + d2;
        hT = dT / 3600;
        dT %= 3600;
        mT = dT / 60;
        sT = dT % 60;

        System.out.printf("%dh %dmin %ds\n", hT, mT, sT);
    }
}