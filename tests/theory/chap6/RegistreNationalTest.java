package theory.chap6;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


public class RegistreNationalTest {
    @Test
    @Order(1)
    public void estNumeroValide_Post2000() {
        assertTrue(RegistreNational.isValid("36.10.21-171.54"));
        assertTrue(RegistreNational.isValid("07.07.19-171.66"));
    }

    @Test
    @Order(2)
    public void estNumeroInvalide_Pre2000() {
        assertFalse(RegistreNational.isValid("05.05.05-123.63"));
    }

    @Test
    @Order(3)
    public void estInvalide_1() {
        assertThrows(IllegalArgumentException.class, () -> RegistreNational.isValid("36.10.21-171.99"));
    }

    @Test
    @Order(4)
    public void estInvalide_2() {
        assertThrows(IllegalArgumentException.class, () -> RegistreNational.isValid("07.07.19-171.00"));
    }

    @Test
    @Order(5)
    public void estInvalide_3() {
        assertThrows(IllegalArgumentException.class, () -> RegistreNational.isValid("07.07.19-171.54.33"));
    }

    @Test
    @Order(6)
    public void estInvalide_4() {
        assertThrows(IllegalArgumentException.class, () -> RegistreNational.isValid("07.07.19-171"));
    }

}
