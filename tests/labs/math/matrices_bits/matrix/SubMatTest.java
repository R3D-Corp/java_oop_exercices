package labs.math.matrices_bits.matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class SubMatTest {
	
	/* --- public Matrix sub(Matrix mat) --- */
	
	@Test
	public void testSubMat_TaillesCompatibles() {
		assertNotEquals(null, MatrixTestUtils.matriceRect43.sub(MatrixTestUtils.matriceRect43));
	}
	
	@Test
	public void testSubMat_TaillesIncompatibles() {
		assertThrows(IllegalArgumentException.class, () -> { MatrixTestUtils.matriceRect43.sub(MatrixTestUtils.matriceRect34); },
			"Tailles de matrices incompatibles");
	}
	
	@Test
	public void testSubMat_CasGeneral() {
		Matrix mSub = MatrixTestUtils.matriceRect43.sub(MatrixTestUtils.matriceRect43);
		assertNotEquals(null, mSub);
        assertNotEquals(mSub, MatrixTestUtils.matriceRect43);
        assertEquals(mSub.getNumRows(), MatrixTestUtils.matriceRect43.getNumRows());
        assertEquals(mSub.getNumCols(), MatrixTestUtils.matriceRect43.getNumCols());
        assertEquals(true, mSub.equals(MatrixTestUtils.matriceRect43Nulle));		
	}
}
