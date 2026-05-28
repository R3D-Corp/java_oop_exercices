package labs.math.mod.calculatrice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test pour CalculatriceModulaire.addition()
 
 */
public class AdditionTests {

	/* --- public static long addition(long a, long b, long modulo) --- */
	
	@Test
	public void testAdditionBase() {
		assertEquals(8, CalculatriceModulaire.addition(5, 3, 12));
	}
	
	@Test
	public void testAdditionSimple() {
		assertEquals(2, CalculatriceModulaire.addition(8, 6, 12));
	}
	
	@Test
	public void testAdditionAPlusBEgalModulo() {
		assertEquals(0, CalculatriceModulaire.addition(7, 5, 12));
	}
	
	@Test
	public void testAdditionAEgalZeroBEgalZero() {
		assertEquals(0, CalculatriceModulaire.addition(0, 0, 12));
	}
	
	@Test
	public void testAdditionAEgalZero() {
		assertEquals(2, CalculatriceModulaire.addition(0, 14, 12));
	}
	
	@Test
	public void testAdditionANegatifBPositif() {
		assertEquals(4, CalculatriceModulaire.addition(-3, 19, 12));
	}
	
	@Test
	public void testAdditionANegatifBNegatif() {
		assertEquals(2, CalculatriceModulaire.addition(-3, -19, 12));
	}
	
	@Test
	public void testAdditionANegatifBZero() {
		assertEquals(8, CalculatriceModulaire.addition(-28, 0, 12));
	}
	
	@Test
	void testAdditionOppose() {
	    assertEquals(0, CalculatriceModulaire.addition(7, 5, 12));  // 7 + (-7) ≡ 0
	}
	
	@Test
	void testAdditionMultiplesModulo() {
	    assertEquals(0, CalculatriceModulaire.addition( 15, 0, 15));
	    assertEquals(7, CalculatriceModulaire.addition(45, 7, 15));
	    assertEquals(0, CalculatriceModulaire.addition(60, 45, 15));
	}	

	@Test
	void testAdditionCommutativite() {
	    assertEquals(CalculatriceModulaire.addition(3, 5, 7), CalculatriceModulaire.addition(5, 3, 7));
	}
	
	@Test
	void testAdditionModulo2() {
	    assertEquals(0, CalculatriceModulaire.addition(1, 1, 2));
	}
	
	@Test
	public void testAdditionGrandsNombres() {
		assertEquals(9, CalculatriceModulaire.addition(546987123, 321987654, 12));
	}	
	
	@Test
	public void testAdditionTresGrandsNombres() {
		assertEquals(8, CalculatriceModulaire.addition(Long.MAX_VALUE, 1, 12));
		assertEquals(2, CalculatriceModulaire.addition(Long.MAX_VALUE, Long.MAX_VALUE, 12));
		assertEquals(14, CalculatriceModulaire.addition(Long.MAX_VALUE, Long.MAX_VALUE, 123));
		assertEquals(5, CalculatriceModulaire.addition(Long.MIN_VALUE, 1, 12));
	}	

}
