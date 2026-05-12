package labs.math.matrices_bits.matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import labs.math.matrices_bits.matrix.Matrix.MatrixType;

/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class MatrixSizeMinMaxTypeTest {

	/* --- public Matrix(int size, int minValue, int maxValue, short type) --- */

	@Test
	public void testMatrixSizeMinMaxType_SizeZero() {
		assertThrows(IllegalArgumentException.class, () -> { new Matrix(0, 1, 10, MatrixType.SQUARE); }, "La taille ne peut pas être nulle");
	}
	
	@Test
	public void testMatrixSizeMinMaxType_SizeNegatif() {
		assertThrows(IllegalArgumentException.class, () -> {  new Matrix(-5, 1, 10, MatrixType.SQUARE); }, "La taille ne peut pas être négative");
	}
	
	@Test
	public void testMatrixSizeMinMaxType_BornesIncorectes() {
		assertThrows(IllegalArgumentException.class, () -> { new Matrix(10, 10, 9, MatrixType.SQUARE); }, "La borne minimale ne peut pas être supérieure à la borne maximale");
	}
	
	@Test
	public void testMatrixSizeMinMaxType_BornesEgales() {
		try {
			assertNotEquals(null, new Matrix(10, 0, 0, MatrixType.SQUARE),"La borne minimale peut être égale à la borne maximale");
		} catch (IllegalArgumentException ex) {
			fail("La borne minimale peut être égale à la borne maximale");
		}
	}
	
	@Test
	public void testMatrixSizeMinMaxType_UpperTriangle() {
		Matrix m = new Matrix(10, 0, 50, MatrixType.UPPER_TRIANGLE);
		assertEquals(10, m.getNumRows(), "Le nombre de lignes n'est pas correct");
		assertEquals(10, m.getNumCols(), "Le nombre de colonnes n'est pas correct");
		assertEquals(true, m.isUpperTriangle(),"La matrice n'est pas triangulaire supérieure");
		assertEquals(true, MatrixTestUtils.checkContent(m, 0, 50), "Contenu en-dehors des bornes");
	}
	
	@Test
	public void testMatrixSizeMinMaxType_UpperTriangleValue() {
		Matrix t = new Matrix(new int[][]{
			{1, 1, 1, 1, 1},
			{0, 1, 1, 1, 1},
			{0, 0, 1, 1, 1},
			{0, 0, 0, 1, 1},
			{0, 0, 0, 0, 1}});
		Matrix m = new Matrix(5, 1, 1, MatrixType.UPPER_TRIANGLE);
		assertEquals(5, m.getNumRows(), "Le nombre de lignes n'est pas correct");
		assertEquals(5, m.getNumCols(), "Le nombre de colonnes n'est pas correct");
		assertEquals(true, m.isUpperTriangle(),"La matrice n'est pas triangulaire supérieure");
		assertEquals(true, m.equals(t), "Contenu incorrect");
	}
	
	@Test
	public void testMatrixSizeMinMaxType_Diagonal() {
		Matrix m = new Matrix(10, 0, 50, MatrixType.DIAGONAL);
		assertEquals(10, m.getNumRows(), "Le nombre de lignes n'est pas correct");
		assertEquals(10, m.getNumCols(), "Le nombre de colonnes n'est pas correct");
		assertEquals(true, m.isDiagonal(),"La matrice n'est pas diagonale");
		assertEquals(true, MatrixTestUtils.checkContent(m, 0, 50), "Contenu en-dehors des bornes");
	}
	
	@Test
	public void testMatrixSizeMinMaxType_DiagonalValue() {
		Matrix t = new Matrix(new int[][]{
			{3, 0, 0, 0, 0},
			{0, 3, 0, 0, 0},
			{0, 0, 3, 0, 0},
			{0, 0, 0, 3, 0},
			{0, 0, 0, 0, 3}});
		Matrix m = new Matrix(5, 3, 3, MatrixType.DIAGONAL);
		assertEquals(5, m.getNumRows(), "Le nombre de lignes n'est pas correct");
		assertEquals(5, m.getNumCols(), "Le nombre de colonnes n'est pas correct");
		assertEquals(true, m.isDiagonal(), "La matrice n'est pas diagonale");
		assertEquals(true, m.equals(t), "Contenu incorrect");
	}
}
