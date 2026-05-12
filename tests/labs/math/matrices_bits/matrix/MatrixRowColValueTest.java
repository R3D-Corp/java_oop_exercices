package labs.math.matrices_bits.matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class MatrixRowColValueTest {
   
    /* --- public Matrix(int numRows, int numCols, int value) --- */
    
	@Test
	public void testMatrixRowColValue_RowZero() {
		assertThrows(IllegalArgumentException.class, () -> { new Matrix(0, 10); }, "Le nombre de lignes ne peut pas être nul");
	}
	
	@Test
	public void testMatrixRowColValue_RowNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { new Matrix(-5, 10); }, "Le nombre de lignes ne peut pas être négatif");
	}
	
	@Test
	public void testMatrixRowColValue_ColZero() {
		assertThrows(IllegalArgumentException.class, () -> { new Matrix(0, 10); }, "Le nombre de colonnes ne peut pas être nul");
	}
	
	@Test
	public void testMatrixRowColValue_ColNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { new Matrix(-5, 10); }, "Le nombre de colonnes ne peut pas être négatif");
	}
	
	@Test
	public void testMatrixRowColValue_CasGeneral() {
		Matrix m = new Matrix(5, 10, 3);
		assertEquals(5, m.getNumRows(), "Nombre de lignes incorrect");
		assertEquals(10, m.getNumCols(), "Nombre de colonnes incorrect");
        for (int i = 0; i< m .getNumRows(); i++) {
            for (int j = 0; j < m.getNumCols(); j++) {
                assertEquals(3, m.get(i, j), "Contenu incorrect");
            }
        }
	}
}
