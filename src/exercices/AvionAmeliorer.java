package exercices;

import io.Console;
import util.Vector.Vector2;

public class AvionAmeliorer {

    private static Vector2 calcualteSpeedVector(int speed, Vector2 direction) {

        float magnitude = direction.norm();  
        
        if(magnitude == 0) return new Vector2(0, 0);

        float normalizedX = direction.getX() / magnitude;
        float normalizedY = direction.getY() / magnitude;
        return new Vector2(normalizedX * speed, normalizedY * speed);
    }

    public static void main(String[] args) {
        Vector2 destination, depart, direction, avion;
        int vitesseAvion;
        int rotationVent;
        
        depart = Vector2.fromString(Console.lireString("Postion dans l'espace du départ (longitude, lattitude) ? "));
        destination = Vector2.fromString(Console.lireString("Postion dans l'espace de la destination (longitude, lattitude) ? "));
        
        direction = destination.sub(depart);
        vitesseAvion = Console.lireInt("Vitesse de l'avion (km/h) ? ");
        avion = calcualteSpeedVector(vitesseAvion, direction);
        
        System.out.printf("Comp x : %f, Comp y: %f", avion.getX(), avion.getY());



        // vitesseVent = Console.lireInt("Vitesse du vent (x, y)? ");


    }
}
