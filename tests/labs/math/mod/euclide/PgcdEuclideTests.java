package labs.math.mod.euclide;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test pour PgcdEuclide.pgcdEuclide()
 *
 */

public class PgcdEuclideTests {

	@Test
	public void testPgcdEuclideNegatifNombre1() {
		assertThrows(IllegalArgumentException.class, () -> { PgcdEuclide.pgcdEuclide(-120, 24); });
	}

	@Test
	public void testPgcdEuclideNegatifNombre2() {
		assertThrows(IllegalArgumentException.class, () -> { PgcdEuclide.pgcdEuclide(120, -24); });
	}
	
	@Test
	public void testPgcdEuclideNombre1EgalZero() {
		assertEquals(12, PgcdEuclide.pgcdEuclide(0, 12));
	}
	
	@Test
	public void testPgcdEuclideNombre2EgalZero() {
		assertEquals(12, PgcdEuclide.pgcdEuclide(12, 0));
	}
	

	@Test
	public void testPgcdEuclideNombre1EtNombre2EgalZero() {
		assertEquals(0, PgcdEuclide.pgcdEuclide(0, 0));
	}	
	
	@Test
	public void testPgcdEuclideNombre1EgalNombre2() {
		assertEquals(12, PgcdEuclide.pgcdEuclide(12, 12));
	}

	@Test
	public void testPgcdEuclideCasGeneral1() {
		assertEquals(75, PgcdEuclide.pgcdEuclide(675, 375));
	}
	
	@Test
	public void testPgcdEuclideCasGeneral2() {
		assertEquals(12, PgcdEuclide.pgcdEuclide(96, 36));
	}

	@Test
	public void testPgcdEuclideCasGeneral1Inverse() {
		assertEquals(75, PgcdEuclide.pgcdEuclide(375, 675));
	}
	
	@Test
	public void testPgcdEuclideNombre1MultipleNombre2() {
	    assertEquals(6, PgcdEuclide.pgcdEuclide(48, 6));
	}

	@Test
	public void testPgcdEuclideNombresPremiersEntreEux() {
		assertEquals(1, PgcdEuclide.pgcdEuclide(84, 275));
	}
}
