package labs.janken.domains;

import java.util.List;
import java.util.Objects;

import static labs.janken.domains.MoveComparison.*;

/**
 * TODO: ajouter le rôle (exo 1)
 * */
public enum Move {
	STONE("Pierre") {
		@Override
		protected MoveComparison against(Move first) {
			return switch(first) { 
				case STONE -> DRAW; 
				case PAPER -> WON; 
				default -> LOST; 
			}; 
		}
	}, 
	PAPER("Feuille") {
		@Override
		protected MoveComparison against(Move first) {
			return switch(first) { 
				case STONE -> WON; 
				case PAPER -> DRAW; 
				default -> LOST; 
			}; 
		}
	}, 
	SCISSORS("Ciseaux") {
		@Override
		protected MoveComparison against(Move first) {
			return switch(first) { 
				case STONE -> WON; 
				case PAPER -> DRAW; 
				default -> LOST; 
			}; 
		}
	};
	
	private final String symbol;

	Move(String symbol) {
		this.symbol = symbol;
	}

	public static List<Move> valueToList() {
		return List.<Move>of(values());
	}
	
	public static Move getFromInt(int index) {
		return switch(index) {
			case 0 -> Move.STONE;
			case 1 -> Move.PAPER;
			case 2 -> Move.SCISSORS;
			default -> throw new IllegalArgumentException("Invalid index: " + index);
		};
	}

	public static int getSumIndex() {
		return 3;
	}
	
	@Override
	public String toString() {
		return symbol;
	}

	public int toInt() {
		return switch(this) {
			case STONE -> 0;
			case PAPER -> 1;
			case SCISSORS -> 2;
		};
	}


	public MoveComparison versus(Move other) {
		Objects.requireNonNull(other);
		
		return other.against(this);
	}

	private static MoveComparison[][] COMPARATORS = {
			{DRAW, LOST, WON},
			{WON, DRAW, LOST},
			{LOST, WON, DRAW},
	};

	protected abstract MoveComparison against(Move first);
}
