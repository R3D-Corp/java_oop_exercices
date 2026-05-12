package labs.math.matrices_bits.matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class MultMatTest {
	
	/* --- public Matrix mult(Matrix mat) --- */
	
	@Test
	public void testMultMat_TaillesCompatibles() {
		assertNotEquals(null, MatrixTestUtils.matriceRect43.mult(MatrixTestUtils.matriceRect32));
	}
	
	@Test
	public void testMultMat_TaillesIncompatibles() {
		assertThrows(IllegalArgumentException.class, () -> { MatrixTestUtils.matriceRect43.mult(MatrixTestUtils.matriceRect43); },
			"Tailles de matrices incompatibles");
	}
	
	@Test
	public void testMultMat_CasGeneral() {
		Matrix mMult = MatrixTestUtils.matriceRect34.mult(MatrixTestUtils.matriceRect43);
		assertNotEquals(null, mMult);
        assertNotEquals(mMult, MatrixTestUtils.matriceRect34);
        assertNotEquals(mMult, MatrixTestUtils.matriceRect43);
        assertEquals(mMult.getNumRows(), MatrixTestUtils.matriceRect34.getNumRows());
        assertEquals(mMult.getNumCols(), MatrixTestUtils.matriceRect43.getNumCols());
        assertEquals(true, mMult.equals(MatrixTestUtils.matrice34x43));		
	}
}
