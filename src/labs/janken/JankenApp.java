package labs.janken;

import io.Console;
import labs.janken.domains.JankenGame;
import labs.janken.domains.players.*;
import labs.janken.views.ConsoleGameView;

public class JankenApp {

	private static final int HUMAN_VS_HUMAN = 1;
	private static final int HUMAN_VS_NOVICE = 2;
	private static final int HUMAN_VS_EXPERIMENTED = 3;
	private static final int QUIT_ITEM = 4;

	public static void main(String[] args) {
		Console.println("POO - labo 05 - Janken");
		Console.println("=".repeat(22));

		var ui = new ConsoleGameView();
		boolean quitRequested = false;
		do {
			printMenu();
			int userChoice = Console.readInt("Votre choix", 1, QUIT_ITEM);
			
			JankenGame game = switch(userChoice) {
			case HUMAN_VS_HUMAN -> new JankenGame(new HumanPlayer("Player 1", ui), new HumanPlayer("Player 2", ui), ui);
			case HUMAN_VS_NOVICE -> new JankenGame(new HumanPlayer("Player 1", ui), new AiNovicePlayer("Ordinateur Facile"), ui);
			case HUMAN_VS_EXPERIMENTED -> new JankenGame(new HumanPlayer("Player 1", ui), new AiExperiementedPlayer("Ordinateur Difficile"), ui);
			default -> null;
			};
			
			if(game != null) {
				game.run(); //lance la partie
			}
			
			quitRequested = userChoice == QUIT_ITEM;
		} while(!quitRequested);
		
		Console.println("👋 Au revoir");
	}

	private static void printMenu() {
		Console.println("1) Humain vs Humain");
		Console.println("2) Humain vs Ordinateur Facile");
		Console.println("3) Humain vs Ordinateur Difficile");
		Console.println("4) Quitter");
	}

}
