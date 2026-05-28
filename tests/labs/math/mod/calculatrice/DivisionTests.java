package labs.math.mod.calculatrice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test pour CalculatriceModulaire.division()
 
 */
public class DivisionTests {

/* --- public static long division(long a, long b, long modulo) --- */
	
	@Test
	public void testDivisionInverseModulaireExistePasPgcdDifferentDeUn() {
		assertThrows(ArithmeticException.class, () -> { CalculatriceModulaire.division(8, 3, 15); });
	}
	
	@Test
	public void testDivisionInverseModulaireExistePasDivisionParZero() {
		assertThrows(ArithmeticException.class, () -> { CalculatriceModulaire.division(8, 0, 15); });
	}
	
	@Test
	public void testDivisionInverseModulaireExistePasDivisionParModulo() {
		assertThrows(ArithmeticException.class, () -> { CalculatriceModulaire.division(8, 15, 15); });
	}
	
	@Test
	public void testDivisionBase() {
		assertEquals(4, CalculatriceModulaire.division(2, 8, 15));
	}
	
	@Test
	public void testDivisionSimple() {
		assertEquals(11, CalculatriceModulaire.division(2, 7, 15));
	}	
	
	@Test
	public void testDivisionAEgalUn() {
		assertEquals(13, CalculatriceModulaire.division(1, 7, 15));
	}
	
	@Test
	public void testDivisionAEgalZero() {
		assertEquals(0, CalculatriceModulaire.division(0, 7, 15));
	}
	
	@Test
	public void testDivisionADiviseA() {   // a / a ≡ 1             
		assertEquals(1, CalculatriceModulaire.division(7, 7, 15));
	}
	
	@Test
	public void testDivisionBEgalUn() {
		assertEquals(11, CalculatriceModulaire.division(11, 1, 15));
	}
	
	@Test
	public void testDivisionANegatifBPositif() {
		assertEquals(6, CalculatriceModulaire.division(-3, 7, 15));
	}
	
	@Test
	public void testDivisionAPositifBNegatif() {
		assertEquals(1, CalculatriceModulaire.division(7, -8, 15));
	}
	
	@Test
	public void testDivisionANegatifBNegatif() {
		assertEquals(6, CalculatriceModulaire.division(-3, -8, 15));
	}
	
	@Test
	public void testDivisionADiviseANegatif() {   // a / a ≡ 1             
		assertEquals(1, CalculatriceModulaire.division(-7, -7, 15));
	}
	
	@Test
	void testDivisionMultiplesModulo() {
	    assertEquals(0, CalculatriceModulaire.division(45, 7, 15));
	}

	@Test
	void testDivisionSuiviMultiplication() {    // a/b × b  -> a
	    assertEquals(2, CalculatriceModulaire.multiplication(CalculatriceModulaire.division(2, 7, 15), 7, 15));
	}

	@Test
	void testDivisionModulo2() {
	    assertEquals(1, CalculatriceModulaire.division(1, 1, 2));
	    assertEquals(0, CalculatriceModulaire.division(0, 1, 2));
	}
	
	@Test
	public void testDivisionGrandsNombres() {
		assertEquals(9, CalculatriceModulaire.division(546987123, 321987457, 15));
	}	
	
	@Test
	public void testDivisionTresGrandsNombres() {
		assertEquals(4, CalculatriceModulaire.division(Long.MAX_VALUE, 13, 15));
		assertEquals(1, CalculatriceModulaire.division(Long.MAX_VALUE, Long.MAX_VALUE, 15));
		assertEquals(26, CalculatriceModulaire.division(Long.MAX_VALUE, 7, 125));
		assertEquals(14, CalculatriceModulaire.division(Long.MIN_VALUE, 8, 15));
	}	

}
