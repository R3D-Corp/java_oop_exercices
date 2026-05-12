package labs.math.recursion.numeration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test pour ChiffresRomains.chiffresRomainsVersDecimalIteratif()
 * 
 */

public class ChiffresRomainsVersDecimalIteratifTest {
	@Test
	public void testChiffresRomainsVersDecimalIteratifUnChiffre() {
		String[] chiffres = {"M", "D", "C", "L", "X", "V", "I"};
		int[] valeurs = {1000, 500, 100, 50, 10, 5, 1};
		for (int i = 0; i < chiffres.length; i++) {
			assertEquals(valeurs[i], ChiffresRomains.chiffresRomainsVersDecimalIteratif(chiffres[i]));
		}
	}

	@Test
	public void testChiffresRomainsVersDecimalIteratifChiffresDecroissants() {
		assertEquals(1666, ChiffresRomains.chiffresRomainsVersDecimalIteratif("MDCLXVI"));
	}

	@Test
	public void testChiffresRomainsVersDecimalIteratifChiffresDecroissantsRepetitions() {
		assertEquals(2020, ChiffresRomains.chiffresRomainsVersDecimalIteratif("MMXX"));
	}

	@Test
	public void testChiffresRomainsVersDecimalIteratifChiffresCroissants() {
		assertEquals(334, ChiffresRomains.chiffresRomainsVersDecimalIteratif("IVXLCDM"));
	}

	@Test
	public void testChiffresRomainsVersDecimalIteratifChiffresCroissantsRepetitions() {
		assertEquals(2001, ChiffresRomains.chiffresRomainsVersDecimalIteratif("IIIMM"));
	}
	
	@Test
	public void testChiffresRomainsVersDecimalIteratif334() {
		assertEquals(334, ChiffresRomains.chiffresRomainsVersDecimalIteratif("CCCXXXIV"));
	}
	
	@Test
	public void testChiffresRomainsVersDecimalIteratif2001() {
		assertEquals(2001, ChiffresRomains.chiffresRomainsVersDecimalIteratif("MMI"));
	}
	
	@Test
	public void testChiffresRomainsVersDecimalIteratif1100() {
		assertEquals(1100, ChiffresRomains.chiffresRomainsVersDecimalIteratif("MC"));
	}
	
	@Test
	public void testChiffresRomainsVersDecimalIteratif1000Complexe() {
		assertEquals(1000, ChiffresRomains.chiffresRomainsVersDecimalIteratif("DMCDLCXLVXIVI"));
	}
}
