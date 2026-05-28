package labs.math.mod.calculatrice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import labs.math.mod.euclide.EuclideEtendu;

/**
 * Plan de test pour CalculatriceModulaire.inverseModulaire()
 
 */
public class InverseModulaireTests {

/* --- public static long inverseModulaire(long a, long modulo)-- */
	
	@Test
	public void testInverseModulaireExistePasPgcdDifferentDeUn() {
		assertThrows(ArithmeticException.class, () -> { CalculatriceModulaire.inverseModulaire(3, 15); });
	}
	
	@Test
	public void testInverseModulaireExistePasInverseDeZero() {
		assertThrows(ArithmeticException.class, () -> { CalculatriceModulaire.inverseModulaire(0, 15); });
	}
	
	@Test
	public void testInverseModulaireExistePasANegatifPgcdDifferentDeUn() {
		assertThrows(ArithmeticException.class, () -> { CalculatriceModulaire.inverseModulaire(-3, 15); });
	}
	
	@Test
	public void testInverseModulaireExistePasMultipleModulo() {
		assertThrows(ArithmeticException.class, () -> { CalculatriceModulaire.inverseModulaire(45, 15); });
	}
	
	@Test
	public void testInverseModulaireBase() {
		assertEquals(8, CalculatriceModulaire.inverseModulaire(2, 15));
	}
	
	@Test
	public void testInverseModulaireIdentique() {
		assertEquals(5, CalculatriceModulaire.inverseModulaire(5, 12));
	}
	
	@Test
	public void testInverseModulaireDeUn() {
		assertEquals(1, CalculatriceModulaire.inverseModulaire(1, 15));
	}
		
	@Test
	public void testInverseModulaireANegatif() {
		assertEquals(7, CalculatriceModulaire.inverseModulaire(-2, 15));
	}
	
	@Test
	public void testInverseModulaireANegatifIdentique() {
		assertEquals(5, CalculatriceModulaire.inverseModulaire(-7, 12));
	}
	
	@Test
	void testInverseModulairePropriete() {   // a × a⁻¹ doit valoir 1
	    long modulo = 15;
	    for (long a = 1; a < modulo; a++) {
	        if (EuclideEtendu.pgcdEuclideEtendu(a, modulo) == 1) {
	            long invA = CalculatriceModulaire.inverseModulaire(a, modulo);
	            assertEquals(1, CalculatriceModulaire.multiplication(a, invA, modulo));
	        }
	    }
	}

	@Test
	void testInverseModulaireModuloPremier() {
		int modulo = 11;
		long[] res = {1, 6, 4, 3, 9, 2, 8, 7, 5, 10};
	    for (int a = 1; a < modulo; a++) {
            assertEquals(res[a - 1], CalculatriceModulaire.inverseModulaire(a, modulo));
	    }
	}
	
	@Test
	void testInverseModulaireModulo2() {
	    assertEquals(1, CalculatriceModulaire.inverseModulaire(1, 2));
	}
	
	@Test
	public void testInverseModulaireGrandsNombres() {
		assertEquals(7, CalculatriceModulaire.inverseModulaire(546987313, 15));
	}	
	
	@Test
	public void testInverseModulaireTresGrandsNombres() {
		assertEquals(13, CalculatriceModulaire.inverseModulaire(Long.MAX_VALUE, 15));
		assertEquals(68, CalculatriceModulaire.inverseModulaire(Long.MAX_VALUE, 125));
		assertEquals(13, CalculatriceModulaire.inverseModulaire(Long.MIN_VALUE, 15));
	}	

}
