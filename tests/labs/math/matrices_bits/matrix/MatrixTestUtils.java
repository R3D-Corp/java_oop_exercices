package labs.math.matrices_bits.matrix;

/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class MatrixTestUtils {

    /*
     *  MATRICES DE TEST
     */
    static final Matrix matriceSingleton = new Matrix(new int[][]{{9}});
    static final Matrix matriceSingletonIdentite = new Matrix(new int[][]{{1}});
    static final Matrix matriceSingletonNulle = new Matrix(new int[][]{{0}});

    static final Matrix matriceCarree = new Matrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    static final Matrix matriceCarreeBis = new Matrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    static final Matrix matriceCarreeNulle = new Matrix(3, 3);
    static final Matrix matriceCarreeDiagonale = new Matrix(new int[][]{{1, 0, 0}, {0, 5, 0}, {0, 0, 9}});
    static final Matrix matriceCarreeIdentite = new Matrix(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}});
    static final Matrix matriceCarreeSymmetric = new Matrix(new int[][]{{1, 2, 3}, {2, 1, 4}, {3, 4, 1}});
    static final Matrix matriceCarreeNotSymmetric = new Matrix(new int[][]{{1,1,1,1,1},{1,1,1,1,1},{3,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}});
    static final Matrix matriceCarreeNotSymmetricMoitieInf = new Matrix(new int[][]{{1,2,3},{2,4,5},{3,6,7}});
    static final Matrix matriceCarreeNotSymmetricOnLastColumn = new Matrix(new int[][]{{1, 2, 3}, {2, 1, 3}, {3, 4, 1}});
    static final Matrix matriceCarreeTriangulaireInf = new Matrix(new int[][]{{1, 0, 0}, {4, 5, 0}, {7, 8, 9}});
    static final Matrix matriceCarreeTriangulaireSup = new Matrix(new int[][]{{1, 2, 3}, {0, 5, 6}, {0, 0, 9}});
    
    static final Matrix matriceRect43 = new Matrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}});
    static final Matrix matriceRect43mod2 = new Matrix(new int[][]{{1, 0, 1}, {0, 1, 0}, {1, 0, 1}, {0, 1, 0}});
    static final Matrix matriceRect43max5 = new Matrix(new int[][]{{5, 5, 5}, {5, 5, 6}, {7, 8, 9}, {10, 11, 12}});
    static final Matrix matriceRect43mult2 = new Matrix(new int[][]{{2, 4, 6}, {8, 10, 12}, {14, 16, 18}, {20, 22, 24}});
    static final Matrix matriceRect34 = new Matrix(new int[][]{{1, 4, 7, 10}, {2, 5, 8, 11}, {3, 6, 9, 12}});
    static final Matrix matriceRect32 = new Matrix(new int[][]{{1, 2}, {3, 4}, {5, 6}});
    static final Matrix matriceRect43Insert32 = new Matrix(new int[][]{{1, 2, 3}, {4, 1, 2}, {7, 3, 4}, {10, 5, 6}});
    static final Matrix matrice34x43 = new Matrix(new int[][]{{166, 188, 210}, {188, 214, 240}, {210, 240,270}});
    static final Matrix matriceRect43Nulle = new Matrix(4, 3);
    static final Matrix matriceRect43FirstNull = new Matrix(new int[][]{{0, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}});
    
    static final Matrix matriceRect43flipH = new Matrix(new int[][]{{10, 11, 12}, {7, 8, 9}, {4, 5, 6}, {1, 2, 3}});
    static final Matrix matriceRect43flipV = new Matrix(new int[][]{{3, 2, 1}, {6, 5, 4}, {9, 8, 7}, {12, 11, 10}});
    static final Matrix matriceRect34flipH = new Matrix(new int[][]{{3, 6, 9, 12}, {2, 5, 8, 11}, {1, 4, 7, 10}});
    static final Matrix matriceRect34flipV = new Matrix(new int[][]{{10, 7, 4, 1}, {11, 8, 5, 2}, {12, 9, 6, 3}});
    
	static final Matrix matriceCreuse34 = new Matrix(new int[][] { { 0, 0, 0, 1 }, { 2, 0, 0, 0 }, { 0, 0, 0, 0 } });
	static final Matrix matriceNonCreuse34 = new Matrix(new int[][] { { 0, 0, 0, 1 }, { 2, 0, 0, 0 }, { 0, 0, 0, 3 } });
	static final Matrix matriceCreuse55 = new Matrix(new int[][] { { 0, 0, 0, 1, 0 }, { 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 3 }, { 4, 0, 0, 0, 0 }, { 0, 0, 0, 0, 5 } });
    
	/*
	 * METHODES UTILITAIRES
	 */
    public static boolean checkContent(Matrix m, int min, int max) {
        for (int row = 0; row < m.getNumRows(); row++) {
            for (int col = 0; col < m.getNumCols(); col++) {
                if (m.get(row, col) < min || m.get(row, col) > max) {
                    return false;
                }
            }
        }
        return true;
    }
}
