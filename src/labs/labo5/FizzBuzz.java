package labs.labo5;

import io.Console;

public class FizzBuzz {

    public static void main(String[] args) {
        int dernierNombre = Console.lireInt("Dernier chiffre ? ");

        String s = "";

        for(int i=1; i<dernierNombre; i++) {
            if(i != 1) {
                s += ",";
            }

            if(i % 3 == 0) {s += "fizz"; continue;}
            else if(i % 5 == 0) {s += "buzz"; continue;}
            
            s += i;
        }

        System.out.println(s);
    }
}
