package labs.starwars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SithTest {
    private Sith sidious;
    private static final int SIDIOUS_HP = 305;
    private static final int SIDIOUS_DP = 21;

    private Jedi windu;
    private static final int WINDU_HP = 300;
    private static final int WINDU_DP = 25;

    @BeforeEach
    void setUp() {
        // Bad Peoples.
        sidious = new Sith("Dark Sidious", SIDIOUS_HP, SIDIOUS_DP);

        // Good Peoples.
        windu = new Jedi("Mace Windu", WINDU_HP, WINDU_DP);
    }

    @Test
    @DisplayName("Very usefull test")
    void usefullTest() {
        assertTrue(sidious instanceof ForceUser);
    }

    @Test
    @DisplayName("Use force once")
    void useForce() {
        assertEquals(sidious.useForceOn(windu), "Dark Sidious utilise la Force sur Mace Windu. Dégâts causés : 21.");
        assertEquals(windu.getHealthPoints(), WINDU_HP - SIDIOUS_DP);
    }

    @Test
    @DisplayName("Use force twice and choke once")
    void useForceAndChoke() {
        assertEquals(sidious.useForceOn(windu), "Dark Sidious utilise la Force sur Mace Windu. Dégâts causés : 21.");
        assertEquals(sidious.useForceOn(windu), "Dark Sidious utilise la Force sur Mace Windu. Dégâts causés : 21.");
        assertEquals(sidious.useForceOn(windu), "Dark Sidious étrangle Mace Windu. Dégâts causés : 42.");
        assertEquals(windu.getHealthPoints(), 216);
    }

    @Test
    @DisplayName("Use force three time choke once and ligthing once")
    void useForceAndChokeAndLighting() {
        assertEquals(sidious.useForceOn(windu), "Dark Sidious utilise la Force sur Mace Windu. Dégâts causés : 21.");
        assertEquals(sidious.useForceOn(windu), "Dark Sidious utilise la Force sur Mace Windu. Dégâts causés : 21.");
        assertEquals(sidious.useForceOn(windu), "Dark Sidious étrangle Mace Windu. Dégâts causés : 42.");
        assertEquals(sidious.useForceOn(windu), "Dark Sidious utilise la Force sur Mace Windu. Dégâts causés : 21.");
        assertEquals(sidious.useForceOn(windu), "Dark Sidious lance des éclairs sur Mace Windu. Dégâts causés : 105.");
        assertEquals(windu.getHealthPoints(), 90);
    }

    @Test
    @DisplayName("Prefer Lighting")
    void useForcePreferLighting() {
        sidious.useForceOn(windu);
        sidious.useForceOn(windu);
        sidious.useForceOn(windu);
        sidious.useForceOn(windu);
        assertEquals(sidious.useForceOn(windu), "Dark Sidious lance des éclairs sur Mace Windu. Dégâts causés : 105.");
        sidious.useForceOn(windu);
        sidious.useForceOn(windu);
        sidious.useForceOn(windu);
        sidious.useForceOn(windu);
        assertEquals(sidious.useForceOn(windu), "Dark Sidious lance des éclairs sur Mace Windu. Dégâts causés : 105.");
        sidious.useForceOn(windu);
        sidious.useForceOn(windu);
        sidious.useForceOn(windu);
        sidious.useForceOn(windu);
        assertEquals(sidious.useForceOn(windu), "Dark Sidious lance des éclairs sur Mace Windu. Dégâts causés : 105.");
    }

    @Test
    @DisplayName("Don't use force on") // I dont make two test because the logic is mathematicly imposssible & I'm tired.
    void useForceOnNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            sidious.useForceOn(null);
        });
    }
}
