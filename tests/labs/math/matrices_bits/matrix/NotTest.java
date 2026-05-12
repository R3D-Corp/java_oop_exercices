package labs.math.matrices_bits.matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class NotTest {

	/* -- public Matrix not() -- */
	@Test
	public void testNot() {
		Matrix matriceCarree = new Matrix(new int[][]{{0xFFFFFFFF, 0x00000000, 0xF0F0F0F0}, {0x0F0F0F0F, 0xA5A5A5A5, 0x5A5A5A5A}});
		Matrix matriceCarreeNot = new Matrix(new int[][]{{0x00000000, 0xFFFFFFFF, 0x0F0F0F0F}, {0xF0F0F0F0, 0x5A5A5A5A, 0xA5A5A5A5}});
		assertEquals(true, matriceCarreeNot.equals(matriceCarree.not()));
	}
}
