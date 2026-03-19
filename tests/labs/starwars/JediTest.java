package labs.starwars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JediTest {

    private Jedi maceWindu;
    private static final int MACE_WINDU_HP = 300;
    private static final int MACE_WINDU_DP = 25;


    private Jedi monLi;
    private static final int MON_LI_HP = 18;
    private static final int MON_LI_DP = 25;
    
    private BaseCharacter atat;
    private static final int AT_AT_HP = 1000;

    private BaseCharacter stormTrooper;
    private static final int STORMTROPPER_HP = 15;


    @BeforeEach
    void setUp() {
        maceWindu = new Jedi("Mace Windu", MACE_WINDU_HP, MACE_WINDU_DP);
        monLi = new Jedi("Mon Li-esi", MON_LI_HP, MON_LI_DP);
        atat = new BaseCharacter("AT-AT WALKER", AT_AT_HP);
        stormTrooper = new BaseCharacter("Jean-Chris", STORMTROPPER_HP);
    }


    @Test
    @DisplayName("check Parent?")
    public void veryUsefullTest() {
        assertTrue(maceWindu instanceof ForceUser);
    }

    @Test
    @DisplayName("Use force without fury mode")
    public void useForceOnNoFury() {
        assertEquals(maceWindu.useForceOn(stormTrooper), "Mace Windu utilise la Force sur Jean-Chris. Dégâts causés : 25.");
        assertFalse(stormTrooper.isAlive());
    }

    @Test
    @DisplayName("don't use force on null")
    public void useForceOnNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            maceWindu.useForceOn(null);
        });
    }

    @Test
    @DisplayName("don't use fury on null")
    public void useFuryOnNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            monLi.loseHP(16);
            monLi.useForceOn(null);
        });
    }

    @Test
    @DisplayName("use fury on other") 
    public void useFuryOnOther() {
        monLi.loseHP(16);
        assertEquals(monLi.useForceOn(stormTrooper), "Mon Li-esi utilise la rage de la Force sur Jean-Chris. Dégâts causés : 250.");
    }


    @Test
    @DisplayName("use fury on other")
    public void useFuryOnAtAt() {
        maceWindu.loseHP(298);
        assertEquals(maceWindu.useForceOn(atat), "Mace Windu utilise la rage de la Force sur AT-AT WALKER. Dégâts causés : 250.");
        assertEquals(atat.getHealthPoints(), AT_AT_HP - MACE_WINDU_DP * 10);
    }

    @Test
    @DisplayName("use fury on other only once") 
    public void useFuryOnOtherOnlyOnce() {
        maceWindu.loseHP(298);
        assertEquals(maceWindu.useForceOn(stormTrooper), "Mace Windu utilise la rage de la Force sur Jean-Chris. Dégâts causés : 250.");
        assertEquals(maceWindu.useForceOn(stormTrooper), "Mace Windu utilise la Force sur Jean-Chris. Dégâts causés : 25.");
    }

}
