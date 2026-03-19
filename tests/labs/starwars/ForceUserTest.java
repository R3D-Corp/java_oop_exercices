package labs.starwars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ForceUserTest {
    private static final String LEIA_NAME = "Leia Organa";
    private static final int LEIA_HP = 30;
    private static final int LEIA_DP = 5;

    private static final int STORMTROPPER_HP = 15;

    private static BaseCharacter stormTrooper;
    private static ForceUser leia;


    @BeforeAll
    public static void intialize() {
        leia = new ForceUser("Leia Organa", 30, 5);
        stormTrooper = new BaseCharacter("Jean-Luc", STORMTROPPER_HP); 
    }

    @Test
    @DisplayName("check Parent?")
    public void veryUsefullTest() {
        assertTrue(leia instanceof BaseCharacter);
    }

    @Test
    @DisplayName("Check ForceUser's fields")
    public void checkForceUserField() {
        assertEquals(leia.getName(), LEIA_NAME);
        assertEquals(leia.getHealthPoints(), LEIA_HP);
        assertEquals(leia.getDamagePoints(), LEIA_DP);
    }

    @Test
    @DisplayName("don't use force on null")
    public void useForceOnNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            leia.useForceOn(null);
        });
    }

    @Test
    @DisplayName("use force on other character")
    public void useForceOnOther() {
        assertEquals(stormTrooper.getHealthPoints(), STORMTROPPER_HP);
        assertEquals(leia.useForceOn(stormTrooper), "Leia Organa utilise la Force sur Jean-Luc. Dégâts causés : 5.");
        assertEquals(stormTrooper.getHealthPoints(), STORMTROPPER_HP - LEIA_DP);
    }

    
}
