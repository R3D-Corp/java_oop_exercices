package labs.math.matrices_bits.matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class FlipVerticalTest {
	
	/* --- public Matrix flipHorizontal() --- */
	
	@Test
	public void testFlipVertical_Rect43() {
		Matrix mFlipH = MatrixTestUtils.matriceRect43.flipVertical();
		assertNotEquals(null, mFlipH);
        assertNotEquals(mFlipH, MatrixTestUtils.matriceRect43);
        assertEquals(mFlipH.getNumRows(), MatrixTestUtils.matriceRect43.getNumRows());
        assertEquals(mFlipH.getNumCols(), MatrixTestUtils.matriceRect43.getNumCols());
        assertEquals(true, mFlipH.equals(MatrixTestUtils.matriceRect43flipV));		
	}
	
	@Test
	public void testFlipVertical_Rect34() {
		Matrix mFlipH = MatrixTestUtils.matriceRect34.flipVertical();
		assertNotEquals(null, mFlipH);
        assertNotEquals(mFlipH, MatrixTestUtils.matriceRect34);
        assertEquals(mFlipH.getNumRows(), MatrixTestUtils.matriceRect34.getNumRows());
        assertEquals(mFlipH.getNumCols(), MatrixTestUtils.matriceRect34.getNumCols());
        assertEquals(true, mFlipH.equals(MatrixTestUtils.matriceRect34flipV));		
	}

}
