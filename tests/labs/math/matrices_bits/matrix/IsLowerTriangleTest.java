package labs.math.matrices_bits.matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class IsLowerTriangleTest {
	
    /* --- public boolean isLowerTriangle() --- */

	@Test
	public void testIsLowerTriangle_Singleton() {
		assertEquals(true, MatrixTestUtils.matriceSingleton.isLowerTriangle());
	}
	
	@Test
	public void testIsLowerTriangle_Rect() {
		assertEquals(false, MatrixTestUtils.matriceRect43.isLowerTriangle());
	}
	
	@Test
	public void testIsLowerTriangle_Carree() {
		assertEquals(false, MatrixTestUtils.matriceCarree.isLowerTriangle());
	}
	
	@Test
	public void testIsLowerTriangle_TriangulaireInf() {
		assertEquals(true, MatrixTestUtils.matriceCarreeTriangulaireInf.isLowerTriangle());
	}
	
	@Test
	public void testIsLowerTriangle_TriangulaireSup() {
		assertEquals(false, MatrixTestUtils.matriceCarreeTriangulaireSup.isLowerTriangle());
	}
}
