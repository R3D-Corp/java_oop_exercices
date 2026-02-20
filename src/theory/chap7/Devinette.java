package theory.chap7;

import io.Console;

public class Devinette {

    private static final int MAX_GAME = 3;
    public static void main(String[] args) {
        boolean isRunning = true;
        int aDeviner, proposition;
        int iteration = 0;
        String regex = "^(?:10|[1-9])$";

        // aDeviner = Random.getInclude(1, 10);
        aDeviner = 3;
        while(isRunning) {
            System.out.println("================");
            iteration++;
            if(iteration <= MAX_GAME) {
                proposition = Integer.parseInt(Console.lireStringWhile("Entier de 1 à 10 : ", "Input incorrect", regex));
        
                if(proposition == aDeviner) {
                    isRunning = false;
                    System.out.println("Bravo tu as trouvé le nombre");
                    break;
                }
                else if(proposition < aDeviner) System.out.println("Le nombre est plus grand");
                else System.out.println("Le nombre est plus petit");
        
                System.out.println(String.format("Il vous reste %d tentative(s)", MAX_GAME - iteration));
                continue;
            } else if(iteration == MAX_GAME+1) {
                System.out.println("Malheureusement vous avez perdu.");
                break;
            };
        }
    }
}
