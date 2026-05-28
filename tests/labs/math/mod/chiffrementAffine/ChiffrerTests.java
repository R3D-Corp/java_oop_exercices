package labs.math.mod.chiffrementAffine;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



/**
 * Plan de test pour ChiffrementAffine.chiffrer()
 *
 */

public class ChiffrerTests {

	@Test
	public void testChiffrerTexteNull() {
		assertThrows(IllegalArgumentException.class, () -> { ChiffrementAffine.chiffrer(null, 3, 24); });
	}
	
	@Test
	public void testChiffrerTexteVide() {
		assertThrows(IllegalArgumentException.class, () -> { ChiffrementAffine.chiffrer("", 5, 24); });
	}
	
	@Test
	public void testChiffrerNombreANegatif() {
		assertThrows(IllegalArgumentException.class, () -> { ChiffrementAffine.chiffrer("MATH", -3, 24); });
	}
	
	@Test
	public void testChiffrerNombreBNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { ChiffrementAffine.chiffrer("MATH", 5, -24); });
	}
	
	@Test
	public void testChiffrerNombreAPremierAvec26() {
		assertThrows(IllegalArgumentException.class, () -> { ChiffrementAffine.chiffrer("MATH", 4, 24); });
	}
	
	@Test
	public void testChiffrerMinusculesSeules() {
		assertEquals("CHLZMBGD", ChiffrementAffine.chiffrer("dimanche", 53, 25));
	}
	
	@Test
	public void testChiffrerMajusculesSeules() {
		assertEquals("CHLZMBGD", ChiffrementAffine.chiffrer("DIMANCHE", 53, 25));
	}	
	
	@Test
	public void testChiffrerMajusculesMinuscules() {
		assertEquals("CHLZMBGD", ChiffrementAffine.chiffrer("DiMaNcHe", 53, 25));
	}
	
	@Test
	public void testChiffrerAvecEspacesEtCaracteresSpeciaux() {
		assertEquals("FIFI, IE UCSAEPU !!!", ChiffrementAffine.chiffrer("Papa, au secours !!!", 5, 8));
	}
	
	@Test
	public void testChiffrerTexteLong() {
		assertEquals("PK ZXYWPZXYHRJPN VK KP TVZGCPKE GXN OPN TWVNPN VK N'B WXIHYJP", 
				ChiffrementAffine.chiffrer("EN MATHEMATIQUES ON NE COMPREND PAS LES CHOSES ON S'Y HABITUE", 11, 23));
	}
	// Citation de John von Neumann - Mathématicien, Physicien, Scientifique (1903 - 1957)
}
