package labo5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;

import io.Console;

public class LdvelhTest {


    static void nettoyerSaisiesAvantChaqueTest() {
        Console.nettoyerSaisies();
    }

    @AfterAll
    static void nettoyerSaisiesFinDesTests() {
        Console.nettoyerSaisies();
    }

    @Test
    public void lireChoix_saisieValide() {
        nettoyerSaisiesAvantChaqueTest();
        Console.simulerSaisies("A");
        assertEquals('A', Ldvelh.lireChoix("A ou B ? ", "AaBb"));
    }
    
    @Test
    public void lireChoix_saisieNonValide() {
        nettoyerSaisiesAvantChaqueTest();
        Console.simulerSaisies("C", "", "a");
        assertEquals('a', Ldvelh.lireChoix("A ou B ? ", "AaBb"));
    }
}
