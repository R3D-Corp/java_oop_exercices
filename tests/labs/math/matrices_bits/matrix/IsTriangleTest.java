package labs.math.matrices_bits.matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class IsTriangleTest {
	
    /* --- public boolean isTriangle() --- */
	
	@Test
	public void testIsTriangle_Singleton() {
		assertEquals(true, MatrixTestUtils.matriceSingleton.isTriangle());
	}
	
	@Test
	public void testIsTriangle_Rect() {
		assertEquals(false, MatrixTestUtils.matriceRect43.isTriangle());
	}
	
	@Test
	public void testIsTriangle_Carree() {
		assertEquals(false, MatrixTestUtils.matriceCarree.isTriangle());
	}
	
	@Test
	public void testIsTriangle_TriangulaireInf() {
		assertEquals(true, MatrixTestUtils.matriceCarreeTriangulaireInf.isTriangle());
	}
	
	@Test
	public void testIsTriangle_TriangulaireSup() {
		assertEquals(true, MatrixTestUtils.matriceCarreeTriangulaireSup.isTriangle());
	}
}
