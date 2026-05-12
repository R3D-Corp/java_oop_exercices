package labs.math.recursion.suite;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test : Suite.java -> suiteRecursif()
 *
 */
public class TermesSuiteRecursifTest {
	
	@Test
	public void testSuiteRecursifNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { TermesSuite.termesSuiteRecursif(-10); });
	}
	@Test
	public void testSuiteRecursifNul() {
		assertThrows(IllegalArgumentException.class, () -> { TermesSuite.termesSuiteRecursif(0); });
	}

	@Test
	public void testSuiteRecursif() {
		for (int i = 1; i <= 20; i++) {
			assertEquals(3 * factorielle(i), TermesSuite.termesSuiteRecursif(i));
		}
	}
	
	public static long factorielle(int n) {
		long fact = 1;
		for (long i = 2; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}

}
