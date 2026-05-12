package labs.algo.labo3.calcul;

import io.Console;

public final class CalculDemo {

	private static final String EXAMPLE = "Entrez un calcul, par exemple : (18 x 25)";
	private static final String PROMPT = " > ";
	private static final String GOODBYE = "Au revoir.";
	
	private CalculDemo() {}
	
	public static void main(String[] args) {
		
		Calcul calc = new Calcul(2);
		System.out.println(EXAMPLE);
		String input = Console.lireString(PROMPT);
		while(!input.isEmpty()) {
			System.out.println(calc.calculer(input));
			input = Console.lireString(PROMPT);
		}
		System.out.println(GOODBYE);
	}

}
