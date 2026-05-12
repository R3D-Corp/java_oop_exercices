package labs.starwars;

import java.util.ArrayList;
import java.util.random.RandomGenerator;

/**
 * Fais combattre des utilisateurs de la Force. Le vainqueur est le dernier combattant vivant.
 */
public class Melee {
  private final static RandomGenerator GENERATOR = RandomGenerator.getDefault();
  private ArrayList<ForceUser> fighters = new ArrayList<>();
  private String lastMessage = new String();

  /**
   * Retourne les types de combattants qu’on peut créer.
   * 
   * A priori, on peut créer des Jedi et des Sith.
   */
  public String[] getFightersKind() {
    return new String[] {"Jedi", "Sith"};
  }

  /**
   * Retourne les combattants vivants sous forme de tableaux.
   * 
   * Pour chaque combattant, la méthode retourne son nom, sa classe concrète, ses points de vie et ses
   * points de dégâts.
   */
  public String[][] getFightersArray() {
    String[][] result = new String[fighters.size()][4];


    for(int i = 0; i<fighters.size(); i++) {
      ForceUser fighter = fighters.get(i);

      result[i] = new String[] {
        fighter.getName(),
        fighter.getClass().toString(),
        Integer.toString(fighter.getHealthPoints()), 
        Integer.toString(fighter.getDamagePoints()),
      };
    }
    return result;
  }

  /**
   * Retourne le nombre de combattant vivants.
   */
  public int getAlivesCount() {
    int response = 0;
    for(BaseCharacter b : fighters) {
      if(b.isAlive()) response++;
    }
    return response;
  }

  /**
   * Retourne les informations relatives à la dernière action valable exécutée.
   */
  public String getLastMessage() {
    return this.lastMessage;
  }

  /**
   * Crée un utilisateur de la Force correspondant à la requête.
   * 
   * Le paramètre args contient les données nécessaires à la création : le type de combattant
   * souhaité, son nom, ses points de vie et de dégâts.
   */
  public void addFighter(AddFighterRequest args) {
    fighters.add(switch(args.getKind()) {
      case "Jedi" -> new Jedi(args.getName(), args.getHitPoints(), args.getDamagePoints());
      case "Sith" -> new Sith(args.getName(), args.getHitPoints(), args.getDamagePoints());
      default -> throw new IllegalArgumentException();
    });
  }

  public ForceUser[] selectChar() {

    ForceUser firstFighter;
    ForceUser secondFighter;

    do {
      int randomNumber = GENERATOR.nextInt(0, this.fighters.size());
      firstFighter = this.fighters.get(randomNumber);
    } while(!firstFighter.isAlive());

    do {
      int randomNumber = GENERATOR.nextInt(0, this.fighters.size());
      secondFighter = this.fighters.get(randomNumber);
    } while(!secondFighter.isAlive() || firstFighter == secondFighter);


    return new ForceUser[] {firstFighter, secondFighter};
  }
  /**
   * Choisit un attaquant et une cible aléatoirement puis demande à l’attaquant d’utiliser la Force
   * sur la cible.
   * 
   * La méthode met à jour le dernier message :
   * <ul>
   * <li>Le dernier message commence par le résultat de l’utilisation de la Force ;
   * <li>Si la cible décède, la méthode ajoute le message « … est mort ! » ;
   * <li>Si il reste un seul combattant vivant, la méthode ajoute le message « Le vainqueur est … ! ».
   * </ul>
   */
  public void makeNextAction() {
    if(getAlivesCount() <= 1) return;

    ForceUser[] charsIndex = selectChar();
    this.lastMessage = "\n" + charsIndex[0].useForceOn(charsIndex[1]);

    if(!charsIndex[1].isAlive()) this.lastMessage += String.format("\n%s est mort!", charsIndex[1].getName());
    if(getAlivesCount() == 1) this.lastMessage += String.format("\n%s est le vainqueur!", charsIndex[0].getName());
  }
}
