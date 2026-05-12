package labs.math.recursion.somme;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test pour SommePuissances.sommePuissancesRecursif()
 *
 */

public class SommePuissancesRecursifTest {
	@Test
	public void testSommePuissancesRecursifNInvalide() {
		try {
			assertEquals(-1, SommePuissances.sommePuissancesRecursif(2, -10), 0.0);
			fail();
		} catch(IllegalArgumentException ex) {
			assertNotNull(ex);
		}
	}

	@Test
	public void testSommePuissancesRecursifXInvalide() {
		try {
			assertEquals(-1, SommePuissances.sommePuissancesRecursif(1, 10), 0.0);
			fail();
		} catch(IllegalArgumentException ex) {
			assertNotNull(ex);
		}
	}

	@Test
	public void testSommePuissancesRecursifXPositif() {
		double x = 3.0;
		double[] resultats = {1.0, 4.0, 13.0, 40.0, 121.0, 364.0, 1093.0, 3280.0, 9841.0, 29524.0};
		for(int n = 0; n < 10; n++) {
			assertEquals(resultats[n], SommePuissances.sommePuissancesRecursif(x, n), 0.0, "Erreur avec x = " + x + " , n = " + n);
		}
	}	

	@Test
	public void testSommePuissancesRecursifXNegatif() {
		double x = -3.0;
		double[] resultats = {1.0, -2.0, 7.0, -20.0, 61.0, -182.0, 547.0, -1640.0, 4921.0, -14762.0};
		for(int n = 0; n < 10; n++) {
			assertEquals(resultats[n], SommePuissances.sommePuissancesRecursif(x, n), 0.0, "Erreur avec x = " + x + " , n = " + n);
		}
	}	
}
