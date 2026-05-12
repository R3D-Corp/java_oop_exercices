package labs.math.recursion.string;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test pour MajusculeMinuscule.toUpperCaseIteratif()
 * 
 */

public class MajusculeIteratifTest {
	@Test
	public void testMajusculeIteratifChaineVide() {
		assertEquals("", Casse.majusculeIteratif(""));
	}

	@Test
	public void testMajusculeIteratifChaineUnCaractere() {
		for (int i = 32; i <= 126; i++) {
			String txt = "" + (char)(i);
			assertEquals(txt.toUpperCase(), Casse.majusculeIteratif(txt));
		}
	}

	@Test
	public void testMajusculeIteratifGeneral() {
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789", Casse.majusculeIteratif("aBcDeFgHiJkLmNoPqRsTuVwXyZ0123456789"));
	}
}
