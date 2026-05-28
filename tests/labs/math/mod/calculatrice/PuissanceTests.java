package labs.math.mod.calculatrice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test pour CalculatriceModulaire.puissance()
 
 */
public class PuissanceTests {

	/* --- public static long puissance(long base, long exp, long modulo) --- */
	
	@Test
	public void testPuissanceExposantPgcdDifferentUn() {
		assertThrows(ArithmeticException.class, () -> { CalculatriceModulaire.puissance(3, -4, 12); });
	}
	
	@Test
	public void testPuissanceTrivial() {
		assertEquals(8, CalculatriceModulaire.puissance(2, 3, 12));
	}
	
	@Test
	public void testPuissanceSimple() {
		assertEquals(4, CalculatriceModulaire.puissance(2, 4, 12));
	}
	
	@Test
	public void testPuissanceExposantPlusGrandQueBase() {
		assertEquals(4, CalculatriceModulaire.puissance(4, 2, 12));
	}
	
	@Test
	public void testPuissanceBaseEgaleUn() {
		assertEquals(1, CalculatriceModulaire.puissance(1, 123, 12));
	}
	
	@Test
	public void testPuissanceExposantEgalUn() {
		assertEquals(5, CalculatriceModulaire.puissance(17, 1, 12));
	}
	
	@Test
	public void testPuissanceBaseEgaleZero() {
		assertEquals(0, CalculatriceModulaire.puissance(0, 13, 12));
	}
	
	@Test
	public void testPuissanceExposantEgalZero() {
		assertEquals(1, CalculatriceModulaire.puissance(19, 0, 12));
	}	
	
	@Test
	public void testPuissanceUnZero() {
		assertEquals(1, CalculatriceModulaire.puissance(1, 0, 12));
	}
	
	@Test
	public void testPuissanceZeroUn() {
		assertEquals(0, CalculatriceModulaire.puissance(0, 1, 12));
	}
	
	@Test
	public void testPuissanceZeroZero() {
		assertEquals(1, CalculatriceModulaire.puissance(0, 0, 12));
	}
	
	@Test
	void testPuissanceBaseNegative() {
	    assertEquals(7, CalculatriceModulaire.puissance(-5, 9, 12));
	}

	@Test
	void testPuissanceExposantNegatif() {
	    assertEquals(1, CalculatriceModulaire.puissance(5, -2, 12));
	}
	
	@Test
	void testPuissanceExposantNegatifModuloGrand() {
	    assertEquals(409, CalculatriceModulaire.puissance(5, -2, 568));
	}
	
	@Test
	public void testPuissanceExposantMoinsUn() {
		assertEquals(CalculatriceModulaire.inverseModulaire(19, 12), CalculatriceModulaire.puissance(19, -1, 12));
	}
	
	@Test
	void testPuissanceMultiplesModulo() {
	    assertEquals(0, CalculatriceModulaire.puissance( 15, 7, 15));
	    assertEquals(0, CalculatriceModulaire.puissance(60, 45, 15));
	}	
	
	@Test
	void testPuissanceModulo2() {
	    assertEquals(1, CalculatriceModulaire.puissance(1, 1, 2));
	    assertEquals(0, CalculatriceModulaire.puissance(0, 1, 2));
	    assertEquals(1, CalculatriceModulaire.puissance(1, 0, 2));
	}
	
	@Test
	public void testPuissanceGrandsNombres() {    // Prends un peu de temps :)
		assertEquals(9, CalculatriceModulaire.puissance(546987123, 321987654, 12));
	}	
	
	@Test
	public void testPuissanceTresGrandsNombres() {  // uniquement base ! 
		assertEquals(7, CalculatriceModulaire.puissance(Long.MAX_VALUE, 1, 12));
		assertEquals(57, CalculatriceModulaire.puissance(Long.MAX_VALUE, 1, 125));
		assertEquals(4, CalculatriceModulaire.puissance(Long.MIN_VALUE, 1, 12));
	}

}
