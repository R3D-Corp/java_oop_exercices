package labs.labo4;

import io.Console;
import io.Fichier;

public class Authentification {

    private static boolean connectUse(String userName, String userPassword, String file) {
        String[] allUsers;
        allUsers = Fichier.lireLignes(file);
        userName = userName.toLowerCase();


        for(String user : allUsers) {
            String[] data = user.split("=");

            if(data.length!=2) {
                return false;
            }

            if(userName.equals(data[0])) {
                if(userPassword.equals(data[1])) {
                    System.out.println("Login : sucess");
                    return true;
                } else {
                    System.out.println("Incorrect password");
                    return false; 
                }
            } else if(user == allUsers[allUsers.length]) {
                System.out.println("User not found");
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String userName, userPassword;
        userName = Console.lireString("Nom Utilisateur ? ");
        userPassword = Console.lireString("Mot de passe ? ");

        connectUse(userName, userPassword, "data/labo4/authentification.txt");
    }
}
