package prb.labo5;

import prb.io.Console;

public class Puissance2 {
    public static void main(String[] args) {
        int combien = Console.lireInt("jusqu'a combien ? ");
        int iteration = 0;
        System.out.printf("%-10s%-10s\n", "Exp.", "Puissance");
        while(iteration <= combien) {
            int result = 2;
            for (int i=1; i<iteration; i++) {
                result = result * 2;
            }
            System.out.printf("%-10d%-10d\n", iteration, result);
            iteration++;
        }
    }
}