package labs.math.mod.euclide;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test pour EuclideEtendu.EuclideEtendu()
 *
 */

public class EuclideEtenduTests {

	@Test
	public void testEuclideEtenduNegatifNombre1() {
		assertThrows(IllegalArgumentException.class, () -> { EuclideEtendu.euclideEtendu(-120, 24); });
	}

	@Test
	public void testEuclideEtenduNegatifNombre2() {
		assertThrows(IllegalArgumentException.class, () -> { EuclideEtendu.euclideEtendu(120, -24); });
	}
	
	@Test
	public void testEuclideEtenduNombre1EtNombre2EgalZero() {
		assertArrayEquals(new long[] {0, 1, 0}, EuclideEtendu.euclideEtendu(0, 0));
	}	
	
	@Test
	public void testEuclideEtenduNombre1EgalZero() {
		assertArrayEquals(new long[] {14, 0, 1}, EuclideEtendu.euclideEtendu(0, 14));
	}
	
	
	@Test
	public void testEuclideEtenduNombre2EgalZero() {
		assertArrayEquals(new long[] {24, 1, 0}, EuclideEtendu.euclideEtendu(24, 0));
	}
	
	@Test
	public void testEuclideEtenduNombre1EgalNombre2() {
		assertArrayEquals(new long[] {12, 0, 1}, EuclideEtendu.euclideEtendu(12, 12));
	}

	@Test
	public void testEuclideEtenduCasGeneral1() {
		assertArrayEquals(new long[] {75, -1, 2}, EuclideEtendu.euclideEtendu(675, 375));
	}
	
	@Test
	public void testEuclideEtenduCasGeneral2() {
		assertArrayEquals(new long[] {12, -1, 3}, EuclideEtendu.euclideEtendu(96, 36));
	}

	@Test
	public void testEuclideEtenduCasGeneral1Inverse() {
		assertArrayEquals(new long[] {75, 2, -1}, EuclideEtendu.euclideEtendu(375, 675));
	}
	
	@Test
	public void testEuclideEtenduNombre1MultipleNombre2() {
	    assertArrayEquals(new long[] {6, 0, 1}, EuclideEtendu.euclideEtendu(48, 6));
	}

	@Test
	public void testEuclideEtenduNombresPremiersEntreEux() {
		assertArrayEquals(new long[] {1, -36, 11}, EuclideEtendu.euclideEtendu(84, 275));
	}
	
	@Test
	public void testEuclideEtenduGrandsEntiers() {
		assertArrayEquals(new long[] {3, -5331823359L, 15617623568L}, EuclideEtendu.euclideEtendu(123472563891L, 42153269829L));
	}
	
	@Test
	public void testEuclideEtenduGrandsEntiersPgcdUn() {
		assertArrayEquals(new long[] {1, -1600487250, 4688041159L}, EuclideEtendu.euclideEtendu(12347256389L, 4215326989L));
	}
}
