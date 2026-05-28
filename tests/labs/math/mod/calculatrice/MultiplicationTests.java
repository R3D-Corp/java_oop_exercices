package labs.math.mod.calculatrice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test pour CalculatriceModulaire.multiplication()
 
 */
public class MultiplicationTests {

/* --- public static long multiplication(long a, long b, long modulo) --- */
	
	@Test
	public void testMultiplicationBase() {
		assertEquals(6, CalculatriceModulaire.multiplication(2, 3, 12));
	}
	
	@Test
	public void testMultiplicationSimple() {
		assertEquals(3, CalculatriceModulaire.multiplication(3, 5, 12));
	}	
	
	@Test
	public void testMultiplicationAEgalZeroBEgalZero() {
		assertEquals(0, CalculatriceModulaire.multiplication(0, 0, 12));
	}
	
	@Test
	public void testMultiplicationAEgalZero() {
		assertEquals(0, CalculatriceModulaire.multiplication(0, 14, 12));
	}
	
	@Test
	public void testMultiplicationANegatifBPositif() {
		assertEquals(9, CalculatriceModulaire.multiplication(-3, 9, 12));
	}
	
	@Test
	public void testMultiplicationANegatifBNegatif() {
		assertEquals(3, CalculatriceModulaire.multiplication(-3, -9, 12));
	}
	
	@Test
	public void testMultiplicationANegatifBZero() {
		assertEquals(0, CalculatriceModulaire.multiplication(-28, 0, 12));
	}
	
	@Test
	void testMultiplicationInverses() {
	    assertEquals(1, CalculatriceModulaire.multiplication(7, 7, 12));  // 7 x 7 ≡ 1
	}
	
	@Test
	void testMultiplicationMultiplesModulo() {
	    assertEquals(0, CalculatriceModulaire.multiplication( 15, 0, 15));
	    assertEquals(0, CalculatriceModulaire.multiplication(45, 7, 15));
	    assertEquals(0, CalculatriceModulaire.multiplication(60, 45, 15));
	}
	
	@Test
	void testMultiplicationCommutativite() {
	    assertEquals(CalculatriceModulaire.multiplication(3, 5, 7), CalculatriceModulaire.multiplication(5, 3, 7));
	}
	
	@Test
	void testMultiplicationModulo2() {
	    assertEquals(1, CalculatriceModulaire.multiplication(1, 1, 2));
	}
	
	@Test
	public void testMultiplicationGrandsNombres() {
		assertEquals(6, CalculatriceModulaire.multiplication(546987123, 321987654, 12));
	}	
	
	@Test
	public void testMultiplicationTresGrandsNombres() {
		assertEquals(7, CalculatriceModulaire.multiplication(Long.MAX_VALUE, 1, 12));
		assertEquals(1, CalculatriceModulaire.multiplication(Long.MAX_VALUE, Long.MAX_VALUE, 12));
		assertEquals(57, CalculatriceModulaire.multiplication(Long.MAX_VALUE, 1, 125));
		assertEquals(4, CalculatriceModulaire.multiplication(Long.MIN_VALUE, 1, 12));
	}	

}
