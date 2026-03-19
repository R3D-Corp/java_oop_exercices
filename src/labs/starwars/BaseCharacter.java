package labs.starwars;

import java.util.StringJoiner;

import util.Contract;

/**
 * Représente un personnage de base de l'univers starwars. Un personnage connaît son nom et gère ses
 * points de vie.
 */
public class BaseCharacter {
    private final String name;
    private int hp;


    public BaseCharacter(String name, int hp) {
        Contract.require(name != null && !name.isBlank(), "Arg. name doit être non blanc");
        Contract.require(hp >= 0, "Arg. hp doit être >= 0");

        this.name = name;
        this.hp = hp;
    }


    public String getName() {
        return this.name;
    }

    public int getHealthPoints() {
        return this.hp;
    }

    public boolean isAlive() {
        return this.getHealthPoints() > 0;
    }

    public void loseHP(int loosedHP) {
        Contract.require(loosedHP >= 0, "Arg. loosedHP doit être >= 0"); // Force loosedHP to be superior or equal to 0

        int newHP = this.getHealthPoints() - loosedHP; // calculate new HP
        this.hp = newHP > 0 ? newHP : 0; // Clamp Instance HP to be at 0 at least.
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        StringJoiner joiner = new StringJoiner(" - ");

        joiner.add(this.getName()); // WRITE "%s" name.
        joiner.add(
            builder.append(this.getHealthPoints()).append("HP") // Write "%dHP" 
        );
        return joiner.toString(); 
    }
}
