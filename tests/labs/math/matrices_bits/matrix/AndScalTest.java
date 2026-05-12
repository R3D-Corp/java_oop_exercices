package labs.math.matrices_bits.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class AndScalTest {

	/* --- public Matrix and(int v) --- */
	
	@Test
	public void testAndV_CarreeWith0() {
		Matrix matriceCarree0 = new Matrix(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
		assertEquals(true, matriceCarree0.equals(MatrixTestUtils.matriceCarree.and(0)));
	}
	
	@Test
	public void testAndV_CarreeWith1() {
		Matrix matriceCarreeRes = new Matrix(new int[][]{{1, 0, 1}, {0, 1, 0}, {1, 0, 1}});
		assertEquals(true, matriceCarreeRes.equals(MatrixTestUtils.matriceCarree.and(1)));
	}
	
	@Test
	public void testAndV_CarreeWithAll1() {
		assertEquals(true, MatrixTestUtils.matriceCarree.equals(MatrixTestUtils.matriceCarree.and(0xFFFFFFFF)));
	}
	
	@Test
	public void testAndV_CarreeWithMoins1() {
		assertEquals(true, MatrixTestUtils.matriceCarree.equals(MatrixTestUtils.matriceCarree.and(-1)));
	}
	
	@Test
	public void testAndV_RectWith0() {
		Matrix matriceRect0 = new Matrix(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
		assertEquals(true, matriceRect0.equals(MatrixTestUtils.matriceRect43.and(0)));
	}
	
	@Test
	public void testAndV_RectWith1() {
		assertEquals(true, MatrixTestUtils.matriceRect43.equals(MatrixTestUtils.matriceRect43.and(0xFFFFFF)));
	}
	

}
