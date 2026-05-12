package labs.math.recursion.string;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test pour MajusculeMinuscule.toLowerCaseRecursif()
 * 
 */

public class MinusculeRecursifTest {
	@Test
	public void testMinusculeRecursifChaineVide() {
		assertEquals("", Casse.minusculeRecursif(""));
	}

	@Test
	public void testMinusculeRecursifChaineUnCaractere() {
		for (int i = 32; i <= 126; i++) {
			String txt = "" + (char)(i);
			assertEquals(txt.toLowerCase(), Casse.minusculeRecursif(txt));
		}
	}

	@Test
	public void testMinusculeRecursifGeneral() {
		assertEquals("abcdefghijklmnopqrstuvwxyz0123456789", Casse.minusculeRecursif("aBcDeFgHiJkLmNoPqRsTuVwXyZ0123456789"));
	}
}
