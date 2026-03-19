package labs.starwars;

import util.Contract;

/**
 * Les utilisateurs de la force sont des entités capables d'utiliser la force.
 * 
 * L'utilisation de la force sur une autre entité retire par défaut damage
 * points de vie à sa cible.
 */
public class ForceUser extends BaseCharacter {
    private final int dp;

    /**
     * ForcerUser constructor wich use his parent method.
     * 
     * @param name Character's name
     * @param hp   Character's health points
     * @param dp   Character's damage points (need to be greater or equal to 0)
     */
    public ForceUser(String name, int hp, int dp) {
        super(name, hp);

        Contract.require(dp >= 0, "Arg. dp doit être >= 0"); // DamagePoint >= 0;
        this.dp = dp;
    }

    /**
     * Method to get ForceUser damage points
     * 
     * @return ForceUser's damage points (int)
     */
    public int getDamagePoints() {
        return this.dp;
    }

    public String useForceOn(BaseCharacter target) {
        Contract.require(target != null, "Arg. target doit être != null"); // Check for target ot not be null.
        
        int damagePoint = this.getDamagePoints();
        target.loseHP(damagePoint);
        
        return String.format("%s utilise la Force sur %s. Dégâts causés : %d.", 
            this.getName(), 
            target.getName(),
            damagePoint
        );
    }

}
