package labo4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
class DateTest {
    @Test
    @Order(1)
    void getJour_test() {
        assertEquals(14, Date.getJour("14/5/1979"));
        assertEquals(3, Date.getJour("03/5/1979"));
        assertEquals(5, Date.getJour("5/5/1979"));
    }

    @Test
    @Order(2)
    void getMois_test() {
        assertEquals(12, Date.getMois("14/12/1979"));
        assertEquals(3, Date.getMois("25/03/1979"));
        assertEquals(5, Date.getMois("23/5/1979"));
    }
    @Test
    @Order(3)
    void getAnnee_test() {
        assertEquals(1973, Date.getAnnee("14/12/1973"));
        assertEquals(373, Date.getAnnee("25/03/373"));
        assertEquals(37, Date.getAnnee("23/5/37"));
    }

    @Test
    @Order(4)
    void formatDate_test() {
        assertEquals("03/05/2027", Date.formaterDate(3, 5, 2027));
        assertEquals("12/05/2027", Date.formaterDate(12, 5, 2027));
        assertEquals("03/05/2014", Date.formaterDate(3, 5, 2014));
    }

    @Test
    @Order(5)
    void estBissextile_test() {
        assertEquals(true, Date.estBissextile(2000));
        assertEquals(false, Date.estBissextile(1973));
    }


    @Test
    @Order(6)
    void joursParMois_test() {
        assertEquals(28, Date.joursParMois(2, 1973));
        assertEquals(29, Date.joursParMois(2, 2000));
        assertEquals(30, Date.joursParMois(4, 1973));
        assertEquals(30, Date.joursParMois(4, 2000));
        assertEquals(31, Date.joursParMois(1, 1973));
        assertEquals(31, Date.joursParMois(1, 2000));
        assertEquals(0, Date.joursParMois(0, 2000));
        
    }
    @Test
    @Order(6)
    void estValide_test() {
        assertEquals(true, Date.estValide("19/07/2007"));
        assertEquals(true, Date.estValide("29/02/2004"));
        assertEquals(false, Date.estValide("29/02/2003"));
        assertEquals(false, Date.estValide("0/07/2007"));
        assertEquals(false, Date.estValide("10/00/2007"));
        assertEquals(false, Date.estValide("33/07/2007"));
        assertEquals(false, Date.estValide("19/13/2007"));
        
    }
}
