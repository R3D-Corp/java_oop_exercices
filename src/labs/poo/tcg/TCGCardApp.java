package labs.poo.tcg;

import labs.poo.io.Console;

public class TCGCardApp {

  public static void main(String[] args) {
     
      Console.println("POO - Labo 1");
      Console.println("============");
      Console.println();
      
      //TODO: exercice 5, rassembler les morceaux
  }

  public static String format(TCGCard card) {
	//TODO : ajouter des barres de vie et de mana
	//TODO : vérifier le paramètre
    String nameLabel = "Carte : %s%n".formatted(card.getName());
    String textLabel = "%s%n".formatted(card.getText());
    String hpLabel =
      "PV : %d/%d%n".formatted(
          card.getHealthPoints(),
          card.getMaxHealthPoints()
        );
    String mpLabel =
      "PM : %d/%d%n".formatted(
          card.getManaPoints(),
          card.getMaxManaPoints()
        );
    String attrLabel =
      "ATK : %d - DEF : %d%n".formatted(card.getAttack(), card.getDefense());

    return nameLabel + textLabel + hpLabel + mpLabel + attrLabel;
  }

  public static TCGCard makeCard() {
    Console.print("Nouvelle carte\n");
    Console.print("-".repeat(14));
    Console.println();

    String name = Console.readLine("Nom :");
    String text = Console.readLine("Texte :");
    int hp = Console.readInt("HP [10; 999] :");
    int mp =  Console.readInt("MP [5; 99] :");
    //TODO: lire les points d'attaque et de défense
    //TODO: valider les données lues
    //TODO: instancier TCGCard et retourner l'objet
    return null;
  }

  public static int applyDamage(TCGCard attacker, TCGCard target) {
	  //TODO: implémenter la méthode
	  return Integer.MIN_VALUE;
  }

  //TODO: implémenter la méthode de classe restore
}
