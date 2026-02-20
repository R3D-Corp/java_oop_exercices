package theory.chap5;

import org.junit.Test;
import org.junit.jupiter.api.Order;

import theory.chap5.formes.Rectangle;

public class GeometrieTest {

    @Test(expected = IllegalArgumentException.class)
    @Order(1) 
    public void rectanglePerimetreHauteurZero() {
        Rectangle.perimetre(0, 5);
    }
    @Test(expected = IllegalArgumentException.class)
    @Order(2) 
    public void rectanglePerimetreLargeurZero() {
        Rectangle.perimetre(0, 5);
    }
    @Test(expected = IllegalArgumentException.class)
    @Order(3) 
    public void rectanglePerimetreZero() {
        Rectangle.perimetre(0, 0);
    }

}
