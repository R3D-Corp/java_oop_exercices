package labs.starwars;

import util.Contract;

/**
 * Un Jedi est un bon utilisateur de la force. Poussé à bout, il peut utiliser
 * la furie de la force.
 */
public class Jedi extends ForceUser {

    private boolean hasUsedFury = false;

    public Jedi(String name, int hp, int dp) {
        super(name, hp, dp);
    }

    @Override
    public String useForceOn(BaseCharacter target) {
        Contract.require(target != null, "Arg. target doit être != null"); // Check for target ot not be null.


        int damagePoint = this.getDamagePoints();
        String regex = "%s utilise la Force sur %s. Dégâts causés : %d.";
        if(!hasUsedFury && this.getHealthPoints() <= 2) {
            damagePoint = damagePoint * 10;
            regex = "%s utilise la rage de la Force sur %s. Dégâts causés : %d.";

            hasUsedFury = true;
        }


        target.loseHP(damagePoint);

        return String.format(regex,
                this.getName(),
                target.getName(),
                damagePoint);
    }
}
