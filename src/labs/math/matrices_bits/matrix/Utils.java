package labs.math.matrices_bits.matrix;

import java.awt.image.BufferedImage;

import labs.math.matrices_bits.graphics.Image;

public class Utils {
	/**
     * Chargement d'un fichier contenant une image bitmap dans
     * une matrice de nombres entiers (Matrix)
     * @param filename Nom du fichier contenant l'image
     * @return Objet de type Matrix
     */
    public static Matrix loadImage(String filename) {
        Matrix matrix = null;
        BufferedImage img = Image.loadImage(filename);
        if (img!=null) {
	        matrix = new Matrix(img.getHeight(), img.getWidth());
	        for (int y = 0; y < matrix.getNumRows(); y++) {
	            for (int x = 0; x < matrix.getNumCols(); x++) {
	                matrix.set(y, x, img.getRGB(x, y) & 0xFFFFFF);
	            }
	        }
        }
        return matrix;
    }

    /**
     * Conversion Matrix vers BufferedImage
     * @param m Matrice à convertir
     * @return Objet de type BufferedImage
     */
    public static BufferedImage matrixToImage(Matrix m) {
        BufferedImage bm = new BufferedImage(m.getNumCols(), m.getNumRows(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < m.getNumRows(); y++) {
            for (int x = 0; x < m.getNumCols(); x++) {
                bm.setRGB(x, y, (int) m.get(y, x));
            }
        }
        return bm;
    }

    /**
     * Affiche le contenu de la matrice M en tant qu'image dans une fenêtre
     * @param m Matrice à afficher en tant qu'image
     */
    public static void displayMatrix(Matrix m) {
    	displayMatrix(m, null);
	}

    /**
     * Affiche le contenu de la matrice M en tant qu'image dans une fenêtre
     * et attribue un titre à cette fenêtre
     * @param m Matrice à afficher en tant qu'image
     * @param title Le titre de la fenêtre
     */
    public static void displayMatrix(Matrix m, String title) {
    	if (m == null) return;
//		DrawingPanel p = new DrawingPanel(m.getNumCols(), m.getNumRows());
//		if (title != null) p.setTitle(title);
//		Graphics g = p.getGraphics();
//		g.drawImage(matrix2Image(m), 0, 0, null);
    	Image.displayImage(matrixToImage(m), title);
	}

}
