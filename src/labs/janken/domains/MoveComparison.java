package labs.janken.domains;

public enum MoveComparison {
	WON, LOST, DRAW;

	MoveComparison opposite() {
		return switch(this) {
		case WON -> LOST;
		case LOST -> WON;
		default -> DRAW;
		};
	}
}
