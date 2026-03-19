package labs.starwars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseCharacterTest {
    private final String CHAR_NAME = "Senateur Organa";

    @Test
    @DisplayName("Vérification getter")
    void testGetter() {
        BaseCharacter character = new BaseCharacter(CHAR_NAME, 10);

        assertEquals(CHAR_NAME, character.getName());
        assertEquals(10, character.getHealthPoints());
    }

    @Test
    @DisplayName("Verfication nom null")
    void testNullName() {
        assertThrows(IllegalArgumentException.class, () ->  {
             new BaseCharacter(null, 20);
        });

        assertThrows(IllegalArgumentException.class, () ->  {
             new BaseCharacter("\t", 20);
        });
    }

    @Test
    @DisplayName("Verfication point de vie négatifs") 
    void testNegativeHP() {
        assertThrows(IllegalArgumentException.class, () ->  {
             new BaseCharacter(CHAR_NAME, -15);
        });
    }

    @Test
    @DisplayName("Verfication système point de vie")
    void testHPSystem() {
        BaseCharacter character = new BaseCharacter(CHAR_NAME, 10);
        assertEquals(character.getHealthPoints(), 10); // Verified intalisalised value to be sure there is no inchorent values.

        character.loseHP(9); // Remove 9 HP to character so 10 - 9 = 1

        assertTrue(character.isAlive());
        assertEquals(character.getHealthPoints(), 1); // Check if the previous calcul was correct
    }

    @Test
    @DisplayName("Verfication système point de vie")
    void testHPSystemWithBiggerDamage() {
        BaseCharacter character = new BaseCharacter(CHAR_NAME, 5);
        assertEquals(character.getHealthPoints(), 5); // Verified intalisalised value to be sure there is no inchorent values.

        character.loseHP(6);

        assertFalse(character.isAlive());
        assertEquals(character.getHealthPoints(), 0);
    }

    @Test
    @DisplayName("Verfication toString")
    void testToString() {
        BaseCharacter character = new BaseCharacter(CHAR_NAME, 10);
        String toString = character.toString();

        assertTrue(toString.contains(CHAR_NAME));
        assertTrue(toString.contains(Integer.toString(10)));
    }

}
