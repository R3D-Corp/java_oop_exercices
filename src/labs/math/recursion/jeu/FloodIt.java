package labs.math.recursion.jeu;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;


/**
 * Implémentation du jeu « Flood-It » (https://unixpapa.com/floodit/) avec contexte graphique (Java Swing).
 * 
 * Le but du jeu est d'obtenir une grille d'une seule couleur. 
 * 
 * Choisissez une couleur en cliquant sur un bouton de la palette située au-dessus de la grille ; 
 * la zone connectée (4-connexité) au coin supérieur gauche (0,0) est alors « inondée » par cette couleur. 
 * Vous disposez d'un nombre limité de coups pour y parvenir.
 */

public class FloodIt extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	// Paramètres du jeu
    private static final int NB_ROWS = 14;
    private static final int NB_COLS = 14;
    private static final int NB_COULEURS = 6;
    private static final int MAX_COUPS = 25;
    
    private final int[][] grille = new int[NB_ROWS][NB_COLS];    
    private int nbCoups = 0;
    private boolean gameOver = false;

    // Palette de 6 couleurs 
    private final Color[] palette = {
            new Color(0xFF0000), // rouge
            new Color(0x00B0F0), // bleu
            new Color(0x00B800), // vert
            new Color(0xF6EB0A), // jaune
            new Color(0x9E227B), // violet
            new Color(0xA95007)  // marron
    };
    
    private final Random randGen = new Random();

    // Paramètres Interface 
    private JPanel gridPanel;
    private JPanel[][] cellViews;
    private JLabel movesLabel;
    private JLabel statusLabel;
    private JButton[] colorButtons;
    private JButton resetButton;    


    /* ========================== LOGIQUE DU JEU ========================== */

	/**
	 * Initialise la grille du Flood-It. <p>
	 * Chaque case de la grille est remplie avec une couleur choisie aléatoirement
	 * parmi les valeurs possibles (0 à NB_COULEURS - 1). <br>
	 * Cette méthode remet également à zéro : <br>
	 *    - le compteur de coups ({@code coups}), <br>
	 *    - l'état de fin de partie ({@code gameOver}).
	 */
    private void initialisationGrille() {
        
        for (int row = 0; row < NB_ROWS; row++) {
            for (int col = 0; col < NB_COLS; col++) {
                grille[row][col] = randGen.nextInt(NB_COULEURS);
            }
        }
        nbCoups = 0;
        gameOver = false;
    }
    
    
    /**
	 * Réalise un coup du jeu Flood-It. <br>
	 * La couleur de la zone connectée au coin supérieur gauche (0,0) est remplacée par la couleur choisie.
	 * 
	 * @param couleurSelectionnee la nouvelle couleur (sélectionnée par le joueur)
	 */
    private void jouerUnCoup(int couleurSelectionnee) {
    	floodFillRecursif(0, 0, grille[0][0], couleurSelectionnee);
        nbCoups++;
    	// NE PAS MODIFIER LE CODE CI-DESSOUS

        // Mise à jour de l'affichage
        refreshGrid();

        // Analyse du statut de la partie
        if (estGagne()) {
            gameOver = true;
            setPaletteEnabled(false);
            statusLabel.setText("Gagné en " + nbCoups + " coup(s) !");
        } else if (nbCoups >= MAX_COUPS) {
            gameOver = true;
            setPaletteEnabled(false);
            statusLabel.setText("Perdu ! Limite de " + MAX_COUPS + " coups atteinte.");
        } else {
            statusLabel.setText("À toi de jouer !");
        }
        movesLabel.setText("Coups : " + nbCoups + " / " + MAX_COUPS);
    }
    
    
	/**
	 * Effectue un recoloriage récursif de la grille (flood-fill) à partir de la case située aux coordonnées indiquées. <p>
	 * Cette méthode recolorie toutes les cases connectées (haut, bas, gauche, droite)
	 * ayant la couleur {@code couleurARemplacer} avec la couleur {@code nouvelleCouleur}.
	 *
	 * @param row                le numéro de la ligne de la case de départ
	 * @param col                le numéro de la colonne de la case de départ
	 * @param couleurARemplacer  la couleur à remplacer
	 * @param nouvelleCouleur    la nouvelle couleur à appliquer
	 */  
    
    private void floodFillRecursif(int row, int col, int couleurARemplacer, int nouvelleCouleur) {
            grille[row][col] = nouvelleCouleur;
            // Up..
            if(estDansGrille(row+1, col) && getColor(row+1, col) == couleurARemplacer) {
                setColor(row+1, col, nouvelleCouleur);
                floodFillRecursif(row+1, col, couleurARemplacer, nouvelleCouleur);
            }
            // Down
            if(estDansGrille(row-1, col) && getColor(row-1, col) == couleurARemplacer) {
                setColor(row-1, col, nouvelleCouleur);
                floodFillRecursif(row-1, col, couleurARemplacer, nouvelleCouleur);
            }
            // Left
            if(estDansGrille(row, col+1) && getColor(row, col+1) == couleurARemplacer) {
                setColor(row, col+1, nouvelleCouleur);
                floodFillRecursif(row, col+1, couleurARemplacer, nouvelleCouleur);
            }

            // Right
            if(estDansGrille(row, col-1) && getColor(row, col-1) == couleurARemplacer) {
                setColor(row, col-1, nouvelleCouleur);
                floodFillRecursif(row, col-1, couleurARemplacer, nouvelleCouleur);
            }
    }
    

	/**
	 * Vérifie si la coordonnée (ligne, colonne) est dans les limites de la grille de jeu.
	 * 
	 * @param row  le numéro de la ligne à tester
	 * @param col  le numéro de la colonne à tester
	 * @return true si la case est dans la grille, false sinon.
	 */
    private boolean estDansGrille(int row, int col) {
    	return (row >= 0 && row < grille.length) && (col >= 0 && col < grille[0].length); // <- A modifier !
    }

    private int getColor(int row, int col) {
        return grille[row][col];
    }

    private void setColor(int row, int col, int newColor) {
        grille[row][col] = newColor;
    }

	/**
	 * Vérifie si la partie est gagnée.
	 * 
	 * @return true si toutes les cases de la grille ont la même couleur que la case (0,0), false sinon.
	 */
    private boolean estGagne() {
    	int colorIndex = grille[0][0];

        for(int[] ligne : grille) {
            for(int colonne : ligne) {
                if(colorIndex != colonne) return false;
            }
        }
    	return true;  // <- A modifier !
    }

    
/* ============================ UI ============================ */


	/**
	 * Met en place l’interface graphique du jeu Flood-It. <br>
	 * (composants Swing nécessaires à l’affichage et à l’interaction avec le joueur)
	 */
    private void buildUI() {
    	
        // Bandeau supérieur : boutons couleurs + reset + infos 
        JPanel top = new JPanel(new BorderLayout(8, 8));
        top.setBorder(BorderFactory.createEmptyBorder(8, 8, 0, 8));

        // Palette
        JPanel palettePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        colorButtons = new JButton[NB_COULEURS];
        for (int i = 0; i < NB_COULEURS; i++) {
            int colorIdx = i;
            JButton b = new JButton();
            b.setPreferredSize(new Dimension(28, 28));
            b.setBackground(palette[i]);
            b.setFocusPainted(false);
            b.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            b.setToolTipText("Choisir la couleur " + (i + 1));
            b.addActionListener((ActionEvent e) -> jouerUnCoup(colorIdx));  // le choix d'une couleur déclenche le coloriage
            colorButtons[i] = b;
            palettePanel.add(b);
        }

        // Infos / actions
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        movesLabel = new JLabel("Coups : 0 / " + MAX_COUPS);
        resetButton = new JButton("Réinitialiser");
        resetButton.addActionListener(e -> {
            initialisationGrille();
            refreshGrid();
            setPaletteEnabled(true);
            movesLabel.setText("Coups : 0 / " + MAX_COUPS);
            statusLabel.setText("Nouvelle partie");
        });
        infoPanel.add(movesLabel);
        infoPanel.add(resetButton);

        top.add(palettePanel, BorderLayout.WEST);
        top.add(infoPanel, BorderLayout.EAST);
        add(top, BorderLayout.NORTH);

        // --- Grille ---
        gridPanel = new JPanel(new GridLayout(NB_ROWS, NB_COLS, 1, 1));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        gridPanel.setBackground(Color.DARK_GRAY);

        cellViews = new JPanel[NB_ROWS][NB_COLS];
        Dimension cellSize = new Dimension(24, 24);

        for (int row = 0; row < NB_ROWS; row++) {
            for (int col = 0; col < NB_COLS; col++) {
                JPanel cell = new JPanel();
                cell.setPreferredSize(cellSize);
                cell.setBackground(palette[grille[row][col]]);
                cell.setBorder(null); // le gap est géré par le GridLayout avec hgap/vgap = 1
                cellViews[row][col] = cell;
                gridPanel.add(cell);
            }
        }
        add(gridPanel, BorderLayout.CENTER);

        // --- Barre d'état ---
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBorder(BorderFactory.createEmptyBorder(0, 8, 8, 8));
        statusLabel = new JLabel("Remplis le tableau de manière à ce qu'il soit d'une seule couleur en ≤ " + MAX_COUPS + " coups.");
        bottom.add(statusLabel, BorderLayout.WEST);
        add(bottom, BorderLayout.SOUTH);
    }


	/**
	 * Met à jour l’affichage graphique de la grille.
	 */
    private void refreshGrid() {
        for (int row = 0; row < NB_ROWS; row++)
            for (int col = 0; col < NB_COLS; col++)
                cellViews[row][col].setBackground(palette[grille[row][col]]);
        gridPanel.revalidate();
        gridPanel.repaint();
    }


	/**
	 * Active ou désactive tous les boutons de la palette de couleurs. <br>
	 * Cette méthode permet de bloquer la saisie du joueur lorsqu'une partie
	 * est terminée (victoire ou défaite) ou lors de la réinitialisation du jeu.	 
	 *
	 * @param enabled true pour activer les boutons de couleur,
	 *                false pour les désactiver
	 */
    private void setPaletteEnabled(boolean enabled) {
        for (JButton b : colorButtons) b.setEnabled(enabled);
    }
    

	/**
	 * Construit et initialise la fenêtre principale du jeu Flood-It.
	 */
    public FloodIt() {
    	
        setTitle("Flood-It");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initialisationGrille();
        buildUI();

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    /**
	 * Programme principal
	 */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(FloodIt::new);
    }
}
