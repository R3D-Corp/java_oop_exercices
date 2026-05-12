package labs.math.matrices_bits.matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class OrScalTest {
	
	/* --- public Matrix or(int v) --- */
	
	@Test
	public void testOrV_CarreeWith0() {
		assertEquals(true, MatrixTestUtils.matriceCarree.equals(MatrixTestUtils.matriceCarree.or(0)));
	}
	
	@Test
	public void testOrV_CarreeWith1() {
		Matrix matriceCarree1 = new Matrix(new int[][]{{0xFFFFFF, 0xFFFFFF, 0xFFFFFF}, {0xFFFFFF, 0xFFFFFF, 0xFFFFFF}, {0xFFFFFF, 0xFFFFFF, 0xFFFFFF}});
		assertEquals(true, matriceCarree1.equals(MatrixTestUtils.matriceCarree.or(0xFFFFFF)));
	}
	
	@Test
	public void testOrV_RectWith0() {
		assertEquals(true, MatrixTestUtils.matriceRect43.equals(MatrixTestUtils.matriceRect43.or(0)));
	}
	
	@Test
	public void testOrV_RectWith1() {
		Matrix matriceRect1 = new Matrix(new int[][]{{0xFFFFFF, 0xFFFFFF, 0xFFFFFF}, {0xFFFFFF, 0xFFFFFF, 0xFFFFFF}, {0xFFFFFF, 0xFFFFFF, 0xFFFFFF}, {0xFFFFFF, 0xFFFFFF, 0xFFFFFF}});
		assertEquals(true, matriceRect1.equals(MatrixTestUtils.matriceRect43.or(0xFFFFFF)));
	}

}
