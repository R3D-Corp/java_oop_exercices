package labs.math.mod.chiffrementAffine;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



/**
 * Plan de test pour ChiffrementAffine.dechiffrer()
 *
 */

public class DechiffrerTests {

	@Test
	public void testDechiffrerTexteNull() {
		assertThrows(IllegalArgumentException.class, () -> { ChiffrementAffine.dechiffrer(null, 3, 24); });
	}
	
	@Test
	public void testDechiffrerTexteVide() {
		assertThrows(IllegalArgumentException.class, () -> { ChiffrementAffine.dechiffrer("", 5, 24); });
	}
	
	@Test
	public void testDechiffrerNombreANegatif() {
		assertThrows(IllegalArgumentException.class, () -> { ChiffrementAffine.dechiffrer("QIZR", -3, 24); });
	}
	
	@Test
	public void testDechiffrerNombreBNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { ChiffrementAffine.dechiffrer("QIZR", 5, -24); });
	}
	
	@Test
	public void testDechiffrerNombreAPremierAvec26() {
		assertThrows(IllegalArgumentException.class, () -> { ChiffrementAffine.dechiffrer("QIZR", 4, 24); });
	}
	
	@Test
	public void testDechiffrerMinusculesSeules() {
		assertEquals("DIMANCHE", ChiffrementAffine.dechiffrer("chlzmbgd", 53, 25));
	}
	
	@Test
	public void testDechiffrerMajusculesSeules() {
		assertEquals("DIMANCHE", ChiffrementAffine.dechiffrer("CHLZMBGD", 53, 25));
	}	
	
	@Test
	public void testDechiffrerMajusculesMinuscules() {
		assertEquals("DIMANCHE", ChiffrementAffine.dechiffrer("cHlZmBgD", 53, 25));
	}
	
	@Test
	public void testDechiffrerAvecEspacesEtCaracteresSpeciaux() {
		assertEquals("PAPA, AU SECOURS !!!", ChiffrementAffine.dechiffrer("Fifi, Ie ucsaepu !!!", 5, 8));
	}
	
	@Test
	public void testDechiffrerTexteLong() {
		assertEquals("EN MATHEMATIQUES ON NE COMPREND PAS LES CHOSES ON S'Y HABITUE", 
				ChiffrementAffine.dechiffrer("PK ZXYWPZXYHRJPN VK KP TVZGCPKE GXN OPN TWVNPN VK N'B WXIHYJP", 11, 23));
	}
	// Citation de John von Neumann - Mathématicien, Physicien, Scientifique (1903 - 1957)
}
