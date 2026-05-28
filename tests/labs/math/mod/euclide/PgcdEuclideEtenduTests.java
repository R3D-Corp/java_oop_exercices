package labs.math.mod.euclide;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test pour EuclideEtendu.pgcdEuclideEtendu()
 *
 */

public class PgcdEuclideEtenduTests {

	@Test
	public void testPgcdEuclideEtenduNegatifNombre1() {
		assertThrows(IllegalArgumentException.class, () -> { EuclideEtendu.pgcdEuclideEtendu(-120, 24); });
	}

	@Test
	public void testPgcdEuclideEtenduNegatifNombre2() {
		assertThrows(IllegalArgumentException.class, () -> { EuclideEtendu.pgcdEuclideEtendu(120, -24); });
	}
	
	@Test
	public void testPgcdEuclideNombre1EtNombre2EgalZero() {
		assertEquals(0, EuclideEtendu.pgcdEuclideEtendu(0, 0));
	}	
	
	@Test
	public void testPgcdEuclideEtenduNombre1EgalZero() {
		assertEquals(14, EuclideEtendu.pgcdEuclideEtendu(0, 14));
	}
	
	
	@Test
	public void testPgcdEuclideEtenduNombre2EgalZero() {
		assertEquals(12, EuclideEtendu.pgcdEuclideEtendu(12, 0));
	}
	
	@Test
	public void testPgcdEuclideEtenduNombre1EgalNombre2() {
		assertEquals(12, EuclideEtendu.pgcdEuclideEtendu(12, 12));
	}

	@Test
	public void testPgcdEuclideEtenduCasGeneral1() {
		assertEquals(75, EuclideEtendu.pgcdEuclideEtendu(675, 375));
	}
	
	@Test
	public void testPgcdEuclideEtenduCasGeneral2() {
		assertEquals(12, EuclideEtendu.pgcdEuclideEtendu(96, 36));
	}

	@Test
	public void testPgcdEuclideEtenduCasGeneral1Inverse() {
		assertEquals(75, EuclideEtendu.pgcdEuclideEtendu(375, 675));
	}
	
	@Test
	public void testPgcdEuclideEtenduNombre1MultipleNombre2() {
	    assertEquals(6, EuclideEtendu.pgcdEuclideEtendu(48, 6));
	}

	@Test
	public void testPgcdEuclideEtenduNombresPremiersEntreEux() {
		assertEquals(1, EuclideEtendu.pgcdEuclideEtendu(84, 275));
	}
}
