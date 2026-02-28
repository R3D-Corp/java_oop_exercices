package theory.chap5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


public class ipTest {
    @Test
    @Order(1)
    public void convertirOctetLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            AdresseIPEnBase10.convertirOctet("010010110");
        });
    }
    @Test
    @Order(2)
    public void convertirOctetBinary() {
        assertThrows(IllegalArgumentException.class, () -> {
            AdresseIPEnBase10.convertirOctet("0120101100");
        });
    }

    @Test
    @Order(3)
    public void convertirIpLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            AdresseIPEnBase10.convertirIpToOctet("11000000.10101000.0000000");
        });
    }
    
    @Test
    @Order(4)
    public void convertirIpTest() {
        assertEquals(4, AdresseIPEnBase10.convertirIpToOctet("11000000.10101000.00000001.00000101").length);
    }
}
