package labs.math.mod.jourSemaine;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test pour JourSemaineZellerGregorien.jourZellerGregorien()
 *
 */

public class JourSemaineZellerGregorienTests {

	@Test
	public void testJourZellerGregorienExempleEnonce1() {
		assertEquals("dimanche", JourSemaineZellerGregorien.jourZellerGregorien(31, 03, 2013));
	}	
	
	@Test
	public void testJourZellerGregorienExempleEnonce2() {
		assertEquals("mardi", JourSemaineZellerGregorien.jourZellerGregorien(9, 2, 1649));
	}
	
	@Test
	public void testJourZellerGregorienPriseBastille() {
		assertEquals("mardi", JourSemaineZellerGregorien.jourZellerGregorien(14, 7, 1789));
	}	
	
	@Test
	public void testJourZellerGregorienJanvier1() {
		assertEquals("mercredi", JourSemaineZellerGregorien.jourZellerGregorien(1, 1, 1834));
	}
	
	@Test	
	public void testJourZellerGregorienJanvier31() {
		assertEquals("vendredi", JourSemaineZellerGregorien.jourZellerGregorien(31, 1, 1834));
	}
	
	@Test
	public void testJourZellerGregorienDecembre31() {
		assertEquals("mercredi", JourSemaineZellerGregorien.jourZellerGregorien(31, 12, 1834));
	}
	
	@Test
	public void testJourZellerGregorienFevrier1() {
		assertEquals("jeudi", JourSemaineZellerGregorien.jourZellerGregorien(01, 02, 1827));
	}
	
	@Test
	public void testJourZellerGregorienFevrier28() {
		assertEquals("lundi", JourSemaineZellerGregorien.jourZellerGregorien(28, 2, 1724));
	}
	
	@Test
	public void testJourZellerGregorienFevrier29() {
		assertEquals("dimanche", JourSemaineZellerGregorien.jourZellerGregorien(29, 2, 1824));
	}
	
	@Test
	public void testJourZellerGregorienHNegatif() {
		assertEquals("mardi", JourSemaineZellerGregorien.jourZellerGregorien(02, 10, 2001));
	}
}
