package labs.math.recursion.suite;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test : Suite.java -> suiteIteratif()
 *
 */
public class TermesSuiteIteratifTest {
	
	@Test
	public void testSuiteIteratifNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { TermesSuite.termesSuiteIteratif(-10); });
	}
	@Test
	public void testSuiteIteratifNul() {
		assertThrows(IllegalArgumentException.class, () -> { TermesSuite.termesSuiteIteratif(0); });
	}

	@Test
	public void testSuiteIteratif() {
		for (int i = 1; i <= 20; i++) {
			assertEquals(3 * factorielle(i), TermesSuite.termesSuiteIteratif(i));
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
