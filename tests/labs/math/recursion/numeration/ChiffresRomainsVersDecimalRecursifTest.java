package labs.math.recursion.numeration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test pour ChiffresRomains.chiffresRomainsVersDecimalRecursif()
 * 
 */

public class ChiffresRomainsVersDecimalRecursifTest {
	@Test
	public void testChiffresRomainsVersDecimalRecursifUnChiffre() {
		String[] chiffres = {"M", "D", "C", "L", "X", "V", "I"};
		int[] valeurs = {1000, 500, 100, 50, 10, 5, 1};
		for (int i = 0; i < chiffres.length; i++) {
			assertEquals(valeurs[i], ChiffresRomains.chiffresRomainsVersDecimalRecursif(chiffres[i]));
		}
	}

	@Test
	public void testChiffresRomainsVersDecimalRecursifChiffresDecroissants() {
		assertEquals(1666, ChiffresRomains.chiffresRomainsVersDecimalRecursif("MDCLXVI"));
	}

	@Test
	public void testChiffresRomainsVersDecimalRecursifChiffresDecroissantsRepetitions() {
		assertEquals(2020, ChiffresRomains.chiffresRomainsVersDecimalRecursif("MMXX"));
	}

	@Test
	public void testChiffresRomainsVersDecimalRecursifChiffresCroissants() {
		assertEquals(334, ChiffresRomains.chiffresRomainsVersDecimalRecursif("IVXLCDM"));
	}

	@Test
	public void testChiffresRomainsVersDecimalRecursifChiffresCroissantsRepetitions() {
		assertEquals(2001, ChiffresRomains.chiffresRomainsVersDecimalRecursif("IIIMM"));
	}
	
	@Test
	public void testChiffresRomainsVersDecimalRecursif334() {
		assertEquals(334, ChiffresRomains.chiffresRomainsVersDecimalRecursif("CCCXXXIV"));
	}
	
	@Test
	public void testChiffresRomainsVersDecimalRecursif2001() {
		assertEquals(2001, ChiffresRomains.chiffresRomainsVersDecimalRecursif("MMI"));
	}
	
	@Test
	public void testChiffresRomainsVersDecimalRecursif1100() {
		assertEquals(1100, ChiffresRomains.chiffresRomainsVersDecimalRecursif("MC"));
	}
	
	@Test
	public void testChiffresRomainsVersDecimalRecursif1000Complexe() {
		assertEquals(1000, ChiffresRomains.chiffresRomainsVersDecimalRecursif("DMCDLCXLVXIVI"));
	}
}
