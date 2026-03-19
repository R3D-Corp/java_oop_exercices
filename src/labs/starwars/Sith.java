package labs.starwars;

import util.Contract;

/**
 * Un Jedi est un mauvais utilisateur de la force. Il peut utiliser la force de
 * plusieurs façons.
 */
public class Sith extends ForceUser {
    private int hitIndex = 1;

    public Sith(String name, int hp, int dp) {
        super(name, hp, dp);
    }

    @Override
    public String useForceOn(BaseCharacter target) {
        Contract.require(target != null, "Arg. target doit être != null"); // Check for target ot not be null.

        // Initalzing variables for base hit.
        int damagePoint = this.getDamagePoints();
        String regex = "%s utilise la Force sur %s. Dégâts causés : %d.";

        if(hitIndex % 5 == 0) { // Lightining
            damagePoint =  damagePoint * 5; // Multiply by five when using lightining.
            regex = "%s lance des éclairs sur %s. Dégâts causés : %d.";
        } else if(hitIndex % 3 == 0) { // Force Choke
            damagePoint = damagePoint * 2; // Multiply by two when using choke.
            regex = "%s étrangle %s. Dégâts causés : %d.";
        }

        hitIndex++;
        target.loseHP(damagePoint);
        return String.format(regex, this.getName(), target.getName(), damagePoint);
    }
}
