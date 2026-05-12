package labs.math.matrices_bits.calcmat;

import labs.math.matrices_bits.matrix.Matrix;
import labs.math.matrices_bits.matrix.Matrix.MatrixType;

/**
 * Manipulation de matrices triangulaires
 * 
 * @author François Schumacker
 */
public class MatricesTriangulaires {
	/*
	 * Matrices de départ
	 */
	
	// Matrice 10x10 triangulaire supérieure de 1
	private static final Matrix mTriangleSup = new Matrix(10, 1, 1, MatrixType.UPPER_TRIANGLE);

	// Matrice 10x10 diagonale de 1 (= matrice unité)
	private static final Matrix mIdentite = new Matrix(10, 1, 1, MatrixType.DIAGONAL);

	// Matrice 10x10 de 1
	private static final Matrix mUns = new Matrix(10, 1, 1, MatrixType.SQUARE);

	/**
	 * Programme principal à compléter en fonction de l'énoncé.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Opérations matricielles...\n");
		
		// 1. mTriangleSup x mIdentite -> neutre
		System.out.println("1. mTriangleSup x mIdentite -> neutre\n");
		mIdentite.mult(mTriangleSup).print(2);

		// 2. mUns x mTriangleSup -> valeurs croissantes en colonnes 
		System.out.println("2. mUns x mTriangleSup -> valeurs croissantes en colonnes\n");
		mUns.mult(mTriangleSup).print(2);
		
		// 3. mTriangleSup x mTriangleSup -> diagonales supérieures croissantes
		System.out.println("3. mTriangleSup x mTriangleSup -> diagonales supérieures croissantes\n");
		mTriangleSup.mult(mTriangleSup).print(2);
		
		// 4. Matrice triangulaire inférieure de 1
		System.out.println("4. Matrice triangulaire inférieure de 1\n");
		mTriangleSup.transpose().print(2);
		
		// 5. Matrice carrée de valeurs décroissantes de 10 à 1 en colonnes 
		System.out.println("5. Matrice carrée de valeurs décroissantes de 10 à 1 en colonnes\n");
		mUns.mult(mTriangleSup.transpose()).print(2);

		
		// 6. Matrice carrée avec diagonales symétriques et croissantes
		System.out.println("6. Matrice carrée avec diagonales symétriques et croissantes\n");
		Matrix test = mTriangleSup.mult(mTriangleSup);
		test.add(test.transpose()).sub(mIdentite)
		.print(2);
	}
}