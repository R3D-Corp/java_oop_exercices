package labs.math.recursion.string;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test pour MajusculeMinuscule.MinusculeIteratif()
 *
 */

public class MinusculeIteratifTest {
	@Test
	public void testMinusculeIteratifChaineVide() {
		assertEquals("", Casse.minusculeIteratif(""));
	}

	@Test
	public void testMinusculeIteratifChaineUnCaractere() {
		for (int i = 32; i <= 126; i++) {
			String txt = "" + (char)(i);
			assertEquals(txt.toLowerCase(), Casse.minusculeIteratif(txt));
		}
	}

	@Test
	public void testMinusculeIteratifGeneral() {
		assertEquals("abcdefghijklmnopqrstuvwxyz0123456789", Casse.minusculeIteratif("aBcDeFgHiJkLmNoPqRsTuVwXyZ0123456789"));
	}
}
