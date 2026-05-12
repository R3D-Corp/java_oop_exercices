package labs.math.matrices_bits.matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class OrMatTest {

	/* --- public Matrix or(Matrix m) --- */
	
	@Test
	public void testOrM_NotSameSize() {
		assertThrows(IllegalArgumentException.class, () -> { MatrixTestUtils.matriceCarree.or(MatrixTestUtils.matriceRect43); }, "Les matrices doivent avoir la m�me taille.");
	}
	
	@Test
	public void testOrM_CarreeWithItself() {
		assertEquals(true, MatrixTestUtils.matriceCarree.equals(MatrixTestUtils.matriceCarree.or(MatrixTestUtils.matriceCarree)));
	}
	
	@Test
	public void testOrM_RectwithItself() {
		assertEquals(true, MatrixTestUtils.matriceRect43.equals(MatrixTestUtils.matriceRect43.or(MatrixTestUtils.matriceRect43)));
	}
	
	@Test
	public void testOrM_CarreeWith0() {
		Matrix matriceCarree0 = new Matrix(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
		assertEquals(true, MatrixTestUtils.matriceCarree.equals(MatrixTestUtils.matriceCarree.or(matriceCarree0)));
	}
	
	@Test
	public void testOrM_CarreeWith1() {
		Matrix matriceCarree1 = new Matrix(new int[][]{{0xFFFFFF, 0xFFFFFF, 0xFFFFFF}, {0xFFFFFF, 0xFFFFFF, 0xFFFFFF}, {0xFFFFFF, 0xFFFFFF, 0xFFFFFF}});
		assertEquals(true, matriceCarree1.equals(MatrixTestUtils.matriceCarree.or(matriceCarree1)));
	}
	
	@Test
	public void testOrM_RectWith0() {
		Matrix matriceRect0 = new Matrix(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
		assertEquals(true, MatrixTestUtils.matriceRect43.equals(MatrixTestUtils.matriceRect43.or(matriceRect0)));
	}
	
	@Test
	public void testOrM_RectWith1() {
		Matrix matriceRect1 = new Matrix(new int[][]{{0xFFFFFF, 0xFFFFFF, 0xFFFFFF}, {0xFFFFFF, 0xFFFFFF, 0xFFFFFF}, {0xFFFFFF, 0xFFFFFF, 0xFFFFFF}, {0xFFFFFF, 0xFFFFFF, 0xFFFFFF}});
		assertEquals(true, matriceRect1.equals(MatrixTestUtils.matriceRect43.or(matriceRect1)));
	}

}
