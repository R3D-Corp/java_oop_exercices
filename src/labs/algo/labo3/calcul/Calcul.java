package labs.algo.labo3.calcul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import io.StringUtils;

/**
 * Calcul.
 * 
 * Pour l'instant, le calcul fonctionne comme décrit dans l'énoncé. 
 */
public class Calcul {

	private static final char PAR_OUVRANTE = '(';
	private static final char AFFECTATION = '=';
	private static final int MAX_OPS = 100;


	private static final Pattern ESPACE_OU_FERME = Pattern.compile("[ )]");
	private static final Pattern IDENTIFIANT = Pattern.compile("[a-zA-Z]+");
	private static final String ID_INVALIDE = "Identifiant invalide : %s";
	
	private static final HashMap<String, Double> REGISTRE = new HashMap<String, Double>();

	private final String format;
	
	// private final Map<String, Double> memoire; // Indice pour la variante 1

	/**
	 * Constructeur
	 * @param precisionAffichage le nombre de chiffres après la virgule dans les résultats.
	 */
	public Calcul(int precisionAffichage) {
		format = "%." + Math.max(0, precisionAffichage) + "f";
		// Variante 1 Initialiser la mémoire
	}
	
	/**
	 * @param entree un calcul correctement formatté (op1 op op2)
	 * @return une chaine de caractère contenant le résultat ou un message d'erreur.
	 */
	public String calculer(String entree) {
		
		// Deque<CellulePile> pile = new ArrayDeque<>(); // FIXME variante 2
		
		int debut = entree.indexOf(PAR_OUVRANTE); // calcule le début de l'expression
		int finOp1 = StringUtils.indexOfPattern(entree, ESPACE_OU_FERME, debut); //équivaut à input.indexOf(SPACE, debut);
		char operator = entree.charAt(finOp1 + 1);
		int finOp2 = StringUtils.indexOfPattern(entree, ESPACE_OU_FERME, finOp1 + 3); //équivaut à input.indexOf(CLOSE_PAR);

		List<String> ops = new ArrayList<String>();
		
		int currentCharetIndex = 0;
		do {
			int start = entree.indexOf(PAR_OUVRANTE);
			currentCharetIndex = StringUtils.indexOfPattern(entree, ESPACE_OU_FERME);
			ops.add(entree.substring(start, currentCharetIndex));
		} while(currentCharetIndex < entree.length());

		String op1 = entree.substring(debut + 1, finOp1);
		String op2 = entree.substring(finOp1 + 3, finOp2);
		
		double resultat = calculer(evaluer(op1), operator, evaluer(op2));
		
		return format.formatted(resultat);
	}

	/**
	 * Evalue une opérande (donne sa valeur si c'est une variable ou essaie de la convertir en double)
	 * @param operande la représentation d'une variable ou d'une constante double.
	 * @return la valeur correspondant à l'opérande
	 */
	private double evaluer(String operande) {
		Double value = REGISTRE.get(operande);
		return value != null ? value : Double.parseDouble(operande);
	}

	/**
	 * Crée en mémoire une correspondance entre la valeur à gauche et la valeur à droite
	 * Ne fais rien si la valeur à gauche n'est pas un identifiant.
	 * 
	 * @param valeurGauche
	 * @param valeurDroite
	 * @return une chaine de caractère représentant l'opération effectuée ou un message d'erreur.
	 */
	private String enregistrer(String valeurGauche, double valeurDroite) {
		REGISTRE.put(valeurGauche, valeurDroite);
		return "";
	}

	/**
	 * Effectue les opérations binaires sur types doubles
	 * @param operande1
	 * @param operator un operateur autorisé (se référer au mode d'emploi).
	 * @param operande2
	 * @return la valeur de operande1 operator operande2
	 * @throws IllegalArgumentException si l'operator n'est pas connu
	 */
	private double calculer(double operande1, char operator, double operande2) {
		return switch (operator) {
		case '+' -> operande1 + operande2;
		case '-' -> operande1 - operande2;
		case '/' -> operande1 / operande2;
		case '%' -> operande1 % operande2;
		case '*' -> operande1 * operande2;
		case 'x' -> operande1 * operande2;
		case '^' -> Math.pow(operande1, operande2);
		default ->
			throw new IllegalArgumentException("Opérateur inattendu: " + operator);
		};
	}
}
