package theory.chap5;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import theory.chap5.formes.Rectangle;

public class GeometrieTest {

    @Test
    @Order(1) 
    public void rectanglePerimetreHauteurZero() {
        assertThrows(IllegalArgumentException.class, () -> Rectangle.perimetre(0, 5));
    }
    @Test
    @Order(2) 
    public void rectanglePerimetreLargeurZero() {
        assertThrows(IllegalArgumentException.class, () -> Rectangle.perimetre(0, 5));
    }
    @Test
    @Order(3) 
    public void rectanglePerimetreZero() {
        assertThrows(IllegalArgumentException.class, () -> Rectangle.perimetre(0, 0));
    }

}
