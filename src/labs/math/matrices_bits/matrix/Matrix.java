package labs.math.matrices_bits.matrix;

import java.util.Arrays;
import java.util.Random;

import util.Contract;

/**
 * La classe Matrix permet de représenter et de manipuler des matrices
 * de nombres entiers.
 * 
 * @author François Schumacker
 */
public class Matrix {

    // ------------------------------------------------------------------------
    //  Constantes de classe - Types de matrices carrées
    // ------------------------------------------------------------------------


    public enum MatrixType {
        SQUARE,
        LOWER_TRIANGLE,
        UPPER_TRIANGLE,
        DIAGONAL
    }

    // ------------------------------------------------------------------------
    //  Variable d'instance
    // ------------------------------------------------------------------------
    
    private int[][] data; // Contient les données de la matrice

    // ------------------------------------------------------------------------
    //  Constructeurs
    // ------------------------------------------------------------------------
    
    /**
     * Crée une matrice nulle de taille numRows x numCols
     *
     * @param numRows Nombre de lignes
     * @param numCols Nombre de colonnes
     */
	public Matrix(int numRows, int numCols) {
		if (numRows <= 0) {
			throw new IllegalArgumentException("Le nombre de lignes doit être strictement positif");
		}
		if (numCols <= 0) {
			throw new IllegalArgumentException("Le nombre de colonnes doit être strictement positif");
		}
		this.data = new int[numRows][numCols];
	}

    /**
     * Crée une matrice à partir du tableau de int fourni en argument
     *
     * @param data Tableau contenant les données de la matrice
     */
	public Matrix(int[][] data) {
		this(data.length, data[0].length); // Appel au constructeur Matrix(int numRows, int numCols)
		for (int i = 0; i < data.length; i++) {
			if (data[i].length != data[0].length) {
				throw new IllegalArgumentException("Toutes les lignes doivent avoir la même taille");
			}
			for (int j = 0; j < data[0].length; j++) {
				this.set(i, j, data[i][j]);
			}
		}
	}

    /**
     * Crée une matrice de taille numRows x numCols remplie avec value
     *
     * @param numRows Nombre de lignes
     * @param numCols Nombre de colonnes
     * @param value Valeur à attribuer à toutes les cases de la matrice
     */
	public Matrix(int numRows, int numCols, int value) {
    	this(numRows, numCols);
        for(int i=0; i<numRows; i++) {
            for(int j=0; j<numCols; j++) {
                this.data[i][j] = value;
            }
        }
	}

    /**
     * Crée une matrice qui est une copie de celle fournie en argument
     *
     * @param mat La matrice à dupliquer
     */
    public Matrix(Matrix mat) {
        this(mat.data); // Appel au constructeur Matrix(int[][] data)
    }

    /**
     * Crée une matrice de taille numRows x numCols remplie de nombres aléatoires
     *
     * @param numRows Nombre de lignes
     * @param numCols Nombre de colonnes
     * @param minValue Valeur aléatoire minimum
     * @param maxValue Valeur aléatoire maximum
     * @return Matrice aléatoire
     */
	public Matrix(int numRows, int numCols, int minValue, int maxValue) {
		this(numRows, numCols); // Appel au constructeur Matrix(int numRows, int numCols)
		if (minValue > maxValue) {
			throw new IllegalArgumentException("La borne minimale est supérieure à la borne maximale !");
		}
		Random rnd = new Random();

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				this.set(i, j, rnd.nextInt(maxValue - minValue + 1) + minValue);
			}
		}
	}

    /**
     * Crée une matrice carrée d'un type donné, remplie de nombres aléatoires 
     *
     * @param size Taille de la matrice carrée
     * @param minValue Valeur aléatoire minimum
     * @param maxValue Valeur aléatoire maximum
     * @param type Type de la matrice à créer
     * @return Matrice carrée aléatoire du type choisi
     */
    public Matrix(int size, int minValue, int maxValue, MatrixType type) {
		this(size, size); // Appel au constructeur Matrix(int numRows, int numCols)
		if (minValue > maxValue) {
			throw new IllegalArgumentException("La borne minimale est supérieure à la borne maximale !");
		}
		Random rnd = new Random();

		switch (type) {
		case SQUARE: // Matrice carrée
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					this.set(i, j, rnd.nextInt(maxValue - minValue + 1) + minValue);
				}
			}
			break;
		case LOWER_TRIANGLE: // Matrice triangulaire inférieure
			for (int i = 0; i < size; i++) {
				for (int j = 0; j <= i; j++) {
					this.set(i, j, rnd.nextInt(maxValue - minValue + 1) + minValue);
				}
			}
			break;
        case UPPER_TRIANGLE:
            for(int i=0; i < size; i++) {
                for(int j=size - 1; j >= i; j--) {
					this.set(i, j, rnd.nextInt(maxValue - minValue + 1) + minValue);
                }
            }
            break;
		case DIAGONAL: 
            for(int i=0; i< size; i++) {
                this.set(i, i, rnd.nextInt(maxValue - minValue +1) + minValue);
            }
            break;
    	default:
    		throw new IllegalArgumentException("Type de matrice inconnu");
        }
    }
    // ------------------------------------------------------------------------
    //  Accesseurs et mutateurs
    // ------------------------------------------------------------------------
    
    /**
     * Renvoie le nombre de lignes de la matrice
     *
     * @return Nombre de lignes
     */
    public int getNumRows() {
        return this.data.length;
    }

    /**
     * Renvoie le nombre de colonnes de la matrice
     *
     * @return Nombre de colonnes
     */
    public int getNumCols() {
        return this.data[0].length;
    }

    /**
     * Renvoie la valeur stockée dans la case (row, col)
     *
     * @param row Numéro de ligne
     * @param col Numéro de colonne
     * @return Valeur stockée
     */
    public int get(int row, int col) {
        return this.data[row][col];
    }

    /**
     * Stocke une valeur dans la case (row, col)
     *
     * @param row Numéro de ligne
     * @param col Numéro de colonne
     * @param value Valeur à stocker
     */
    public void set(int row, int col, int value) {
        this.data[row][col] = value;
    }

    // ------------------------------------------------------------------------
    //  Méthodes de test
    // ------------------------------------------------------------------------

    /**
     * Teste si la matrice est égale à celle fournie en paramètre
     * 
     * @param mat   Matrice
     * @return true si les matrices sont égales
     */
    public boolean equals(Matrix mat) {
        return Arrays.deepEquals(this.data, mat.data);
        // Solution alternative
//        if (!this.hasSameSize(mat)) return false;
//        for (int i = 0; i < this.getNumRows(); i++) {
//            for (int j = i; j < this.getNumCols(); j++) {
//                if (this.get(i,j) != mat.get(i,j)) return false;
//            }
//        }
//        return true;
    }

    /**
     * Teste si la matrice a la même taille que celle fournie en paramètre
     * 
     * @param mat   Matrice
     * @return true si les matrices ont la même taille
     */
    public boolean hasSameSize(Matrix mat) {
        return (this.getNumRows() == mat.getNumRows() &&
                this.getNumCols() == mat.getNumCols());
    }
    
    /**
     * Teste si la matrice est carrée
     * 
     * @return true si la matrice est carrée
     */
    public boolean isSquare() {
        return (this.getNumRows() == this.getNumCols());
    }

    /**
     * Teste si la matrice est une matrice diagonale
     * 
     * @return true si la matrice est une matrice diagonale
     */
    public boolean isDiagonal() {
        if (!this.isSquare()) return false;
        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                if (i != j && this.get(i, j) != 0) return false;
            }
        }
        return true;
    }

    /**
     * Teste si la matrice est triangulaire
     * 
     * @return true si la matrice est triangulaire
     */
    public boolean isTriangle() {
        return isLowerTriangle() || isUpperTriangle();
    }

    /**
     * Teste si la matrice est triangulaire inférieure<br>
     * Note: les cases au-dessus de la diagonale sont nulles
     * 
     * @return true si la matrice est triangulaire inférieure
     */
    public boolean isLowerTriangle() {
        if(this.getNumRows() != this.getNumCols()) return false;

        for(int i=0; i<this.getNumRows(); i++) {
            for(int j=this.getNumRows() - 1; j>i; j--) {
                if(this.get(i,j) != 0) return false;
            }
        }
        return true;
    }

    /**
     * Teste si la matrice est triangulaire supérieure<br>
     * Note: les cases en-dessous de la diagonale sont nulles
     * 
     * @return true si la matrice est triangulaire supérieure
     */
    public boolean isUpperTriangle() {
        if (!this.isSquare()) return false;
        for (int i = 1; i < this.getNumRows(); i++) {
            for (int j = 0; j < i; j++) {
                if (this.get(i, j) != 0) return false;
            }
        }
        return true;
    }

    // ------------------------------------------------------------------------
    //  Opérations sur les matrices
    // ------------------------------------------------------------------------

    /**
     * Addition de deux matrices<br>
     *   R = THIS + M<br>
     *   r(i, j) = this(i, j) + m(i,j)
     *   
     * @param m Matrice à ajouter à THIS
     * @return  Matrice de résultat R
     */
    public Matrix add(Matrix m) {
        // On vérifie que les 2 matrices ont la même taille
        if (!this.hasSameSize(m)) {
            throw new IllegalArgumentException("Les matrices doivent avoir la même taille !");
        }
        // Création de la matrice de résultat
        Matrix r = new Matrix(this.getNumRows(), this.getNumCols());
        // Addition des 2 matrices
        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                r.set(i, j, this.get(i, j) + m.get(i, j));
            }
        }
        return r;
    }

    /**
     * ET logique de deux matrices<br>
     *   R = THIS AND M<br>
     *   r(i, j) = this(i, j) & m(i, j)
     *   
     * @param m Matrice dont on veut faire le ET logique avec THIS
     * @return  Matrice de résultat R
     */
	public Matrix and(Matrix m) {
		// On vérifie que les 2 matrices ont la même taille
		if (!this.hasSameSize(m)) {
			throw new IllegalArgumentException("Les matrices doivent avoir la même taille !");
		}
		// Création de la matrice de résultat
		Matrix r = new Matrix(this.getNumRows(), this.getNumCols());
		// ET logique des 2 matrices
		for (int i = 0; i < this.getNumRows(); i++) {
			for (int j = 0; j < this.getNumCols(); j++) {
				r.set(i, j, this.get(i, j) & m.get(i, j));
			}
		}
		return r;
	}
    
    /**
     * Symétrie verticale
     * 
     * @return Matrice symétrique de THIS par rapport à l'axe vertical
     */
    public Matrix flipVertical() {
        int[][] result = new int[this.getNumRows()][this.getNumCols()];

        for(int i=0; i<this.getNumRows(); i++) {
            for(int j=0; j<this.getNumCols(); j++) {
                result[i][this.getNumCols() - 1 - j] = this.get(i, j);
            }
        }
        return new Matrix(result);
    }
   
    /**
     * Insère une matrice dans la matrice courante à partir de la position spécifiée.<br>
     *   R = THIS avec M insérée à la position (insertRow, insertCol)<br>
     *   r(i, j) = this(i, j) sauf pour<br>
     *   r(insertRow + x, insertCol + y) = mat(x, y)
     *   
     * @param insertRow Indice de la première ligne à laquelle il faut insérer la matrice M
     * @param insertCol Indice de la première colonne à laquelle il faut insérer la matrice M
     * @param m Matrice à insérer dans THIS
     * @return  Matrice de résultat R
     */
    public Matrix insertIntoThis(int insertRow, int insertCol, Matrix m) {
        Contract.require(insertRow>=0, "Arg. insertRow >= 0 require");
        Contract.require(insertCol>=0, "Arg. insertCol >= 0 require");
        Contract.require(insertRow + m.getNumRows() <= this.getNumRows(), "L'insertion ne devrait pas dépasser la taille de la matrice originale.");
        Contract.require(insertCol + m.getNumCols() <= this.getNumCols(), "L'insertion ne devrait pas dépasser la taille de la matrice originale.");

        int[][] result = new int[this.getNumRows()][this.getNumCols()];

        for(int i=0; i<this.getNumRows(); i++) {
            for(int j=0; j<this.getNumCols(); j++) {

                result[i][j] = this.get(i, j);
            }
        }
        for(int x = 0; x<m.getNumRows(); x++) {
            for(int y = 0; y<m.getNumCols(); y++) {
                result[insertRow+x][insertCol+y] = m.get(x, y);
            }
        }

        return new Matrix(result);
    }
    
    /**
     * Multiplication de deux matrices<br>
     *   R = THIS x MAT avec THIS:MxN MAT:NxP et R:MxP<br>
     *   r(i, j) = somme pour k allant de 0 à N-1 de this(i, k) * mat(k, j)
     *   
     * @param mat matrice
     * @return  matrice résultat
     */
    public Matrix mult(Matrix mat) {
        Contract.require(this.getNumCols() == mat.getNumRows(), "n == p require");

        int[][] result = new int[this.getNumRows()][mat.getNumCols()];

        for(int i=0; i<this.getNumRows(); i++) {
            for(int j=0; j<mat.getNumCols(); j++) {
                int sum=0;
                for(int k = 0; k<this.getNumCols(); k++) {
                    sum += this.get(i, k) * mat.get(k, j);
                }
                result[i][j] = sum;
            }
        }
        return new Matrix(result);
    }
    
    /**
     * OU logique de deux matrices<br>
     *   R = THIS OR M<br>
     *   r(i, j) = this(i, j) | m(i, j)
     *   
     * @param m Matrice dont on veut faire le OU logique avec THIS
     * @return  Matrice de résultat R
     */
	public Matrix or(Matrix m) {
        if(this.getNumRows() != m.getNumRows() || this.getNumCols() != m.getNumCols()) throw new IllegalArgumentException("La matrice à soustraitre doit posséder les mêmes dimensions");
        int[][] result = new int[this.getNumRows()][this.getNumCols()];

        for(int i=0; i<this.getNumRows(); i++) {
            for(int j=0; j<this.getNumCols(); j++) {
                result[i][j] = this.get(i, j) | m.get(i, j);
            }
        }
        return new Matrix(result);
	}
    
    /**
     * Soustraction de deux matrices<br>
     *   R = THIS - M<br>
     *   r(i, j) = this(i, j) - m(i, j)
     *   
     * @param m Matrice à soustraire de THIS
     * @return  Matrice de résultat R
     */
    public Matrix sub(Matrix m) {
        if(this.getNumRows() != m.getNumRows() || this.getNumCols() != m.getNumCols()) throw new IllegalArgumentException("La matrice à soustraitre doit posséder les mêmes dimensions");
        int[][] result = new int[this.getNumRows()][this.getNumCols()];

        for(int i=0; i<this.getNumRows(); i++) {
            for(int j=0; j<this.getNumCols(); j++) {
                result[i][j] = this.get(i, j) - m.get(i, j);
            }
        }
        return new Matrix(result);
    }
    
    /**
     * Renvoie la matrice transposée<br>
     *   R = THIS'<br>
     *   r(i, j) = this(j, i)
     *   
     * @return Matrice transposée
     */
    public Matrix transpose() {
        int[][] result = new int[this.getNumCols()][this.getNumRows()];

        for(int i=0; i<this.getNumRows(); i++) {
            for(int j=0; j<this.getNumCols(); j++) {
                result[j][i] = this.get(i, j);
            }
        }
        return new Matrix(result);
    }

    // ------------------------------------------------------------------------
    //  Opérations matrices / scalaire
    // ------------------------------------------------------------------------

    /**
     * Addition d'un nombre à tous les éléments d'une matrice<br>
     *   R = THIS + v<br>
     *   r(i, j) = this(i, j) + v
     *   
     * @param v Valeur scalaire
     * @return  Matrice de résultat
     */
    public Matrix add(int v) {
        Matrix r = new Matrix(this.getNumRows(), this.getNumCols());
        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                r.set(i, j, this.get(i, j) + v);
            }
        }
        return r;
    }
    
    /**
     * ET logique entre un nombre et chaque élément d'une matrice<br>
     *   R = THIS & v<br>
     *   r(i, j) = this(i, j) & v
     *   
     * @param v Valeur scalaire
     * @return  Matrice de résultat
     */
    public Matrix and(int v) {
        int[][] result = new int[this.getNumRows()][this.getNumCols()];

        for(int i=0; i<this.getNumRows(); i++) {
            for(int j=0; j<this.getNumCols(); j++) {
                result[i][j] = this.get(i, j) & v;
            }
        }
        return new Matrix(result);
    }
    
    /**
     * NOT logique (complément) de chaque élément d'une matrice<br>
     *   R = NOT(THIS)<br>
     *   r(i, j) = ~this(i, j)
     *   
     * @return  Matrice de résultat
     */
    public Matrix not() {
        int[][] result = new int[this.getNumRows()][this.getNumCols()];

        for(int i=0; i<this.getNumRows(); i++) {
            for(int j=0; j<this.getNumCols(); j++) {
                result[i][j] = ~this.get(i, j);
            }
        }
        return new Matrix(result);
    }
    
    /**
     * OU logique entre un nombre et chaque élément d'une matrice<br>
     *   R = THIS | v<br>
     *   r(i, j) = this(i, j) | v
     *   
     * @param v Valeur scalaire
     * @return  Matrice de résultat
     */
    public Matrix or(int v) {
        int[][] result = new int[this.getNumRows()][this.getNumCols()];

        for(int i=0; i<this.getNumRows(); i++) {
            for(int j=0; j<this.getNumCols(); j++) {
                result[i][j] = this.get(i, j) | v;
            }
        }
        return new Matrix(result);
    }
    
    /**
     * Décalage logique à gauche de chaque élément d'une matrice<br>
     *   R = THIS << n <br>
     *   r(i, j) = this(i, j) << n
     *   
     * @param n Valeur du décalage à gauche
     * @return  Matrice de résultat
     */
    public Matrix shiftLeftLogical(int n) {
        int[][] result = new int[this.getNumRows()][this.getNumCols()];

        for(int i=0; i<this.getNumRows(); i++) {
            for(int j=0; j<this.getNumCols(); j++) {
                result[i][j] = this.get(i, j) << n;
            }
        }

        return new Matrix(result);
    }
    
    // ------------------------------------------------------------------------
    //  Méthodes utilitaires
    // ------------------------------------------------------------------------
    
    /**
     * Imprime la matrice à l'écran avec un format par défaut
     */
    public void print() {
        print(6);
    }

    /**
     * Imprime la matrice à l'écran avec le nombre de chiffre demandés
     *
     * @param numDigits Nombre de chiffres
     */
    public void print(int numDigits) {
        String format = "%" + numDigits + "d  ";

        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                System.out.printf(format, this.get(i, j));
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Imprime la matrice à l'écran en considérant que chaque élément
     * est un caractère ASCII (entre 32 et 126). Les autres valeurs
     * sont remplacées par un caractère '.'
     */
    public void printAscii() {
        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                if (this.get(i, j) >= 32 && this.get(i, j) < 127) {
                    System.out.printf("%c", this.get(i, j));
                } else {
                    System.out.printf(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
