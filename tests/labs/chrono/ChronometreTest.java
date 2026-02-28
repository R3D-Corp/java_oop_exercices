package labs.chrono;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChronometreTest {

	/*
	 * CONSTRUCTEURS
	 */

	@Test
	void constructeurParDefautDoitInitialiserAZero() {
		Chronometre c = new Chronometre();
		assertEquals("00:00:00", c.toString());
		assertEquals(0, c.toSeconds());
	}

	@Test
	void constructeurAvecValeursValides() {
		Chronometre c = new Chronometre(12, 34, 56);
		assertEquals(12, c.getHour());
		assertEquals(34, c.getMinute());
		assertEquals(56, c.getSecond());
	}

	@Test
	void constructeurValeursLimitesMax() {
		Chronometre c = new Chronometre(99, 59, 59);
		assertTrue(c.isMax());
	}

	@Test
	void constructeurValeursInvalidesDoitLeverException() {
		assertThrows(IllegalArgumentException.class, () -> new Chronometre(-1, 0, 0));
		assertThrows(IllegalArgumentException.class, () -> new Chronometre(0, -1, 0));
		assertThrows(IllegalArgumentException.class, () -> new Chronometre(0, 0, -1));
		assertThrows(IllegalArgumentException.class, () -> new Chronometre(100, 0, 0));
		assertThrows(IllegalArgumentException.class, () -> new Chronometre(0, 60, 0));
		assertThrows(IllegalArgumentException.class, () -> new Chronometre(0, 0, 60));
	}

	/*
	 * AJOUT DE SECONDES
	 */

	@Test
	void ajoutSecondesSimple() {
		Chronometre c = new Chronometre(0, 0, 10);
		c.addSecond(5);
		assertEquals("00:00:15", c.toString());
	}

	@Test
	void ajoutSecondesAvecReportMinutes() {
		Chronometre c = new Chronometre(0, 0, 59);
		c.addSecond(2);
		assertEquals("00:01:01", c.toString());
	}

	@Test
	void ajoutSecondesAvecReportHeures() {
		Chronometre c = new Chronometre(0, 59, 59);
		c.addSecond(2);
		assertEquals("01:00:01", c.toString());
	}

	@Test
	void ajoutSecondesGrandNombre() {
		Chronometre c = new Chronometre();
		c.addSecond(3661); // 1h 1min 1s
		assertEquals("01:01:01", c.toString());
	}

	@Test
	void ajoutSecondesDepassementMax() {
		Chronometre c = new Chronometre(99, 59, 50);
		c.addSecond(20);
		assertTrue(c.isMax());
		assertEquals("99:59:59", c.toString());
	}

	@Test
	void ajoutSecondesNegatifInterdit() {
		Chronometre c = new Chronometre();
		assertThrows(IllegalArgumentException.class, () -> c.addSecond(-1));
	}

	/*
	 * AJOUT DE MINUTES
	 */

	@Test
	void ajoutMinutesSimple() {
		Chronometre c = new Chronometre(1, 10, 0);
		c.addMinute(5);
		assertEquals("01:15:00", c.toString());
	}

	@Test
	void ajoutMinutesAvecReportHeures() {
		Chronometre c = new Chronometre(1, 59, 0);
		c.addMinute(2);
		assertEquals("02:01:00", c.toString());
	}

	@Test
	void ajoutMinutesGrandNombre() {
		Chronometre c = new Chronometre();
		c.addMinute(120); // 2 heures
		assertEquals("02:00:00", c.toString());
	}

	@Test
	void ajoutMinutesDepassementMax() {
		Chronometre c = new Chronometre(98, 59, 59);
		c.addMinute(120);
		assertTrue(c.isMax());
	}

	@Test
	void ajoutMinutesNegatifInterdit() {
		Chronometre c = new Chronometre();
		assertThrows(IllegalArgumentException.class, () -> c.addMinute(-5));
	}

	/*
	 * AJOUT D'HEURES
	 */

	@Test
	void ajoutHeuresSimple() {
		Chronometre c = new Chronometre(5, 0, 0);
		c.addHour(3);
		assertEquals("08:00:00", c.toString());
	}

	@Test
	void ajoutHeuresDepassementMax() {
		Chronometre c = new Chronometre(90, 0, 0);
		c.addHour(20);
		assertTrue(c.isMax());
	}

	@Test
	void ajoutHeuresNegatifInterdit() {
		Chronometre c = new Chronometre();
		assertThrows(IllegalArgumentException.class, () -> c.addHour(-1));
	}

	/*
	 * REINITIALISATION
	 */

	@Test
	void reinitialiserDoitRemettreAZero() {
		Chronometre c = new Chronometre(12, 34, 56);
		c.reset();
		assertEquals("00:00:00", c.toString());
		assertEquals(0, c.toSeconds());
	}

	/*
	 * EST MAX
	 */

	@Test
	void estMaxDoitRetournerFalseSiPasMax() {
		Chronometre c = new Chronometre(99, 59, 58);
		assertFalse(c.isMax());
	}

	@Test
	void estMaxDoitRetournerTrueSiMax() {
		Chronometre c = new Chronometre(99, 59, 59);
		assertTrue(c.isMax());
	}

	/*
	 * EN SECONDES
	 */

	@Test
	void enSecondesCasGeneral() {
		Chronometre c = new Chronometre(2, 30, 15);
		assertEquals(9015, c.toSeconds());
	}

	@Test
	void enSecondesZero() {
		Chronometre c = new Chronometre();
		assertEquals(0, c.toSeconds());
	}

	/*
	 * COMPARAISON
	 */

	@Test
	void comparaisonEgalite() {
		Chronometre c1 = new Chronometre(1, 1, 1);
		Chronometre c2 = new Chronometre(1, 1, 1);
		assertEquals(0, c1.compare(c2));
	}

	@Test
	void comparaisonInferieur() {
		Chronometre c1 = new Chronometre(0, 59, 59);
		Chronometre c2 = new Chronometre(1, 0, 0);
		assertTrue(c1.compare(c2) < 0);
	}

	@Test
	void comparaisonSuperieur() {
		Chronometre c1 = new Chronometre(5, 0, 0);
		Chronometre c2 = new Chronometre(4, 59, 59);
		assertTrue(c1.compare(c2) > 0);
	}

	@Test
	void comparerDoitRetournerValeurNegativeSiReferenceNull() {
		Chronometre c = new Chronometre(1, 0, 0);

		int resultat = c.compare(null);

		assertTrue(resultat < 0);
	}

	/*
	 * FORMAT D'AFFICHAGE
	 */

	@Test
	void toStringDoitToujoursAfficherDeuxChiffres() {
		Chronometre c = new Chronometre(1, 2, 3);
		assertEquals("01:02:03", c.toString());
	}

}
