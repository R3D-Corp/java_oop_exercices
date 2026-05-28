package labs.math.mod.calculatrice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test pour CalculatriceModulaire.soustraction()
 
 */
public class SoustractionTests {

/* --- public static long soustraction(long a, long b, long modulo) --- */
	
	@Test
	public void testSoustractionBase() {
		assertEquals(2, CalculatriceModulaire.soustraction(5, 3, 12));
	}
	
	@Test
	public void testSoustractionSimple() {
		assertEquals(4, CalculatriceModulaire.soustraction(22, 6, 12));
	}	
	
	@Test
	public void testSoustractionAMoinsBEgalModulo() {
		assertEquals(0, CalculatriceModulaire.soustraction(17, 5, 12));
	}
	
	@Test
	public void testSoustractionAEgalZeroBEgalZero() {
		assertEquals(0, CalculatriceModulaire.soustraction(0, 0, 12));
	}
	
	@Test
	public void testSoustractionAEgalZero() {
		assertEquals(10, CalculatriceModulaire.soustraction(0, 14, 12));
	}
	
	@Test
	public void testSoustractionBEgalZero() {
		assertEquals(3, CalculatriceModulaire.soustraction(27, 0, 12));
	}
	
	@Test
	public void testSoustractionANegatifBPositif() {
		assertEquals(2, CalculatriceModulaire.soustraction(-3, 19, 12));
	}
	
	@Test
	public void testSoustractionANegatifBNegatif() {
		assertEquals(4, CalculatriceModulaire.soustraction(-3, -19, 12));
	}
	
	@Test
	public void testSoustractionANegatifBZero() {
		assertEquals(8, CalculatriceModulaire.soustraction(-28, 0, 12));
	}
	
	@Test
	void testSoustractionIdentiques() {
	    assertEquals(0, CalculatriceModulaire.soustraction(7, 7, 12));  // 7 - 7 ≡ 0
	}
	
	@Test
	void testSoustractionMultiplesModulo() {
	    assertEquals(0, CalculatriceModulaire.soustraction( 15, 0, 15));
	    assertEquals(8, CalculatriceModulaire.soustraction(45, 7, 15));
	    assertEquals(0, CalculatriceModulaire.soustraction(60, 45, 15));
	}
	
	@Test
	void testSoustractionModulo2() {
	    assertEquals(0, CalculatriceModulaire.soustraction(1, 1, 2));
	}
	
	@Test
	public void testSoustractionGrandsNombres() {
		assertEquals(9, CalculatriceModulaire.soustraction(546987123, 321987654, 12));
	}	
	
	@Test
	public void testSoustractionTresGrandsNombres() {
		assertEquals(6, CalculatriceModulaire.soustraction(Long.MAX_VALUE, 1, 12));
		assertEquals(0, CalculatriceModulaire.soustraction(Long.MAX_VALUE, Long.MAX_VALUE, 12));
		assertEquals(6, CalculatriceModulaire.soustraction(Long.MAX_VALUE, 1, 123));
		assertEquals(3, CalculatriceModulaire.soustraction(Long.MIN_VALUE, 1, 12));
	}	
}
