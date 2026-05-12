package labs.math.matrices_bits.matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class InsertIntoThisTest {
	
	/* --- public Matrix insertIntoThis(int insertRow, int insertCol, Matrix m) --- */

	@Test
	public void testInsertIntoThis_InsertRowNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { MatrixTestUtils.matriceRect43.insertIntoThis(-5, 0, MatrixTestUtils.matriceSingleton); },
			"insertRow ne peut pas être négatif");
	}
	
	@Test
	public void testInsertIntoThis_InsertRowTropGrand() {
		assertThrows(IllegalArgumentException.class, () -> { MatrixTestUtils.matriceRect43.insertIntoThis(0, 4, MatrixTestUtils.matriceSingleton); },
			"insertRow est trop grand");
	}
	
	@Test
	public void testInsertIntoThis_InsertColNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { MatrixTestUtils.matriceRect43.insertIntoThis(0, -5, MatrixTestUtils.matriceSingleton); },
			"insertCol ne peut pas être négatif");
	}
	
	@Test
	public void testInsertIntoThis_InsertColTropGrand() {
		assertThrows(IllegalArgumentException.class, () -> { MatrixTestUtils.matriceRect43.insertIntoThis(0, 4, MatrixTestUtils.matriceSingleton); },
			"insertCol est trop grand");
	}
	
	@Test
	public void testInsertIntoThis_PasAssezDeLignes() {
		assertThrows(IllegalArgumentException.class, () -> { MatrixTestUtils.matriceRect43.insertIntoThis(2, 0, MatrixTestUtils.matriceRect32); },
			"nombre de lignes insuffisant");
	}
	
	@Test
	public void testInsertIntoThis_PasAssezDeColonnes() {
		assertThrows(IllegalArgumentException.class, () -> { MatrixTestUtils.matriceRect43.insertIntoThis(0, 3, MatrixTestUtils.matriceRect32); },
			"nombre de colonnes insuffisant");
	}
	
	@Test
	public void testInsertIntoThis_CasGeneral() {
		Matrix mInsert = MatrixTestUtils.matriceRect43.insertIntoThis(1, 1, MatrixTestUtils.matriceRect32);
		assertNotEquals(null, mInsert);
        assertNotEquals(mInsert, MatrixTestUtils.matriceRect43);
        assertNotEquals(mInsert, MatrixTestUtils.matriceRect32);
        assertEquals(mInsert.getNumRows(), MatrixTestUtils.matriceRect43.getNumRows());
        assertEquals(mInsert.getNumCols(), MatrixTestUtils.matriceRect43.getNumCols());
        assertEquals(true, mInsert.equals(MatrixTestUtils.matriceRect43Insert32));		
	}
}
