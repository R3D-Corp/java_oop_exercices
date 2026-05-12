package labs.math.matrices_bits.matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class TransposeTest {
	
	/* --- public Matrix transpose(Matrix mat) --- */

	@Test
	public void testTranspose_Singleton() {
		assertEquals(true, MatrixTestUtils.matriceSingleton.equals(MatrixTestUtils.matriceSingleton.transpose()));
	}
	
	@Test
	public void testTranspose_CasGeneral() {
		Matrix mTranposed = MatrixTestUtils.matriceRect34.transpose();
		assertNotEquals(null, mTranposed);
        assertNotEquals(mTranposed, MatrixTestUtils.matriceRect34);
        assertEquals(mTranposed.getNumRows(), MatrixTestUtils.matriceRect34.getNumCols());
        assertEquals(mTranposed.getNumCols(), MatrixTestUtils.matriceRect34.getNumRows());
        assertEquals(true, mTranposed.equals(MatrixTestUtils.matriceRect43));		
	}
}
