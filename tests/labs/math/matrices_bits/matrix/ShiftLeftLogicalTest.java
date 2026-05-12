package labs.math.matrices_bits.matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class ShiftLeftLogicalTest {
	
	Matrix matriceBase = new Matrix(new int[][]{{0xFFFFFFFF, 0x00000000}, {0xF0F0F0F0, 0xA5A5A5A5}});
		
	/* -- public Matrix shiftLeft(int n) -- */
	@Test
	public void testShiftLeft_0() {		
		assertEquals(true, matriceBase.equals(matriceBase.shiftLeftLogical(0)));
	}
	
	@Test
	public void testShiftLeft_1() {
		Matrix matriceResult = new Matrix(new int[][]{{0xFFFFFFFE, 0x00000000}, {0xE1E1E1E0, 0x4B4B4B4A}});
		assertEquals(true, matriceResult.equals(matriceBase.shiftLeftLogical(1)));
	}
	
	@Test
	public void testShiftLeft_2() {
		Matrix matriceResult = new Matrix(new int[][]{{0xFFFFFFFC, 0x00000000}, {0xC3C3C3C0, 0x96969694}});
		assertEquals(true, matriceResult.equals(matriceBase.shiftLeftLogical(2)));
	}
	
	@Test
	public void testShiftLeft_3() {
		Matrix matriceResult = new Matrix(new int[][]{{0xFFFFFFF8, 0x00000000}, {0x87878780, 0x2D2D2D28}});
		assertEquals(true, matriceResult.equals(matriceBase.shiftLeftLogical(3)));
	}
	
	@Test
	public void testShiftLeft_4() {
		Matrix matriceResult = new Matrix(new int[][]{{0xFFFFFFF0, 0x00000000}, {0x0F0F0F00, 0x5A5A5A50}});
		assertEquals(true, matriceResult.equals(matriceBase.shiftLeftLogical(4)));
	}
	
	@Test
	public void testShiftLeft_5() {
		Matrix matriceResult = new Matrix(new int[][]{{0xFFFFFFE0, 0x00000000}, {0x1E1E1E00, 0xB4B4B4A0}});
		assertEquals(true, matriceResult.equals(matriceBase.shiftLeftLogical(5)));
	}
	
	@Test
	public void testShiftLeft_6() {
		Matrix matriceResult = new Matrix(new int[][]{{0xFFFFFFC0, 0x00000000}, {0x3C3C3C00, 0x69696940}});
		assertEquals(true, matriceResult.equals(matriceBase.shiftLeftLogical(6)));
	}
	
	@Test
	public void testShiftLeft_7() {
		Matrix matriceResult = new Matrix(new int[][]{{0xFFFFFF80, 0x00000000}, {0x78787800, 0xD2D2D280}});
		assertEquals(true, matriceResult.equals(matriceBase.shiftLeftLogical(7)));
	}
	
	@Test
	public void testShiftLeft_8() {
		Matrix matriceResult = new Matrix(new int[][]{{0xFFFFFF00, 0x00000000}, {0xF0F0F000, 0xA5A5A500}});
		assertEquals(true, matriceResult.equals(matriceBase.shiftLeftLogical(8)));
	}
	
	@Test
	public void testShiftLeft_Negatif() {
		assertThrows(IllegalArgumentException.class, () -> { matriceBase.shiftLeftLogical(-1); }, "Un décalage ne peut pas être négatif");
	}

	@Test
	public void testShiftLeft_33() {
		assertThrows(IllegalArgumentException.class, () -> { matriceBase.shiftLeftLogical(33); }, "Un décalage ne peut pas être supérieur à 32");
	}
}
