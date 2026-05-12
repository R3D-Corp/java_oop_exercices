package labs.math.recursion.string;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test pour MajusculeMinuscule.toUpperCaseRecursif()
 * 
 */

public class MajusculeRecursifTest {
	@Test
	public void testMajusculeRecursifChaineVide() {
		assertEquals("", Casse.majusculeRecursif(""));
	}

	@Test
	public void testMajusculeRecursifChaineUnCaractere() {
		for (int i = 32; i <= 126; i++) {
			String txt = "" + (char)(i);
			assertEquals(txt.toUpperCase(), Casse.majusculeRecursif(txt));
		}
	}

	@Test
	public void testMajusculeRecursifGeneral() {
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789", Casse.majusculeRecursif("aBcDeFgHiJkLmNoPqRsTuVwXyZ0123456789"));
	}
}
