package labs.math.matrices_bits.monalisa;

import labs.math.matrices_bits.matrix.Matrix;
import labs.math.matrices_bits.matrix.Utils;

/**
 * Mona Lisa a besoin de vacances
 * 
 * @author François Schumacker
 */
public class MonaLisa {

	/**
	 * @param args
	 *             the command line arguments
	 */
	public static void main(String[] args) {
		System.out.println("Mona Lisa a besoin de vacances !\n");
		System.out.println("Chargement des images...");

		Matrix mMonaLisa = Utils.loadImage("data/math/img/monalisa/mona_lisa.jpg");
		Matrix mLunettes = Utils.loadImage("data/math/img/monalisa/lunettes.png").flipVertical().transpose();
		Matrix mPlage = Utils.loadImage("data/math/img/monalisa/plage.jpg");

		Matrix mMasqueMonaLisa = Utils.loadImage("data/math/img/monalisa/masque_mona_lisa.png");
		Matrix mMasqueLunette = new Matrix(mPlage.getNumRows(), mPlage.getNumCols(), 0, 0).insertIntoThis(65, 205,mLunettes.not());
		Matrix fondRose = new Matrix(mPlage.getNumRows(), mPlage.getNumCols(), 0xFF00FF);

		System.out.println("Incrustation de Mona Lisa sur la plage...");

		// 1. Détourage de la zone d'incrustation
		Matrix mPlageAndMask = mPlage.and(mMasqueMonaLisa);
		Matrix mJonconde = mMasqueMonaLisa.not().and(mMonaLisa);
		Matrix mPlageAndJonconde = mPlageAndMask.add(mJonconde);

		System.out.println("Incrustation des lunettes roses...");
		Matrix pinkGlasses = fondRose.and(mMasqueLunette);
		Matrix mPlageAndJoncondeLunettes = mPlageAndJonconde.and(mMasqueLunette.not()).add(pinkGlasses);
		
		Utils.displayMatrix(mPlageAndJoncondeLunettes);
	}
}