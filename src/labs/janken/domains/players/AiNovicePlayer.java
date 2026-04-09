package labs.janken.domains.players;

import java.util.ArrayList;
import java.util.List;
import util.Random;

import labs.janken.domains.Move;
import labs.janken.domains.MoveComparison;

public class AiNovicePlayer extends BasePlayer {

    private record MovePair(Move humanMove, Move aiMove, MoveComparison comparison) {}
    private final ArrayList<MovePair> movesHistory = new ArrayList<MovePair>();

    public AiNovicePlayer(String name) {
        super(name);
    }

    private static Move randomMove() {
        return Move.STONE;
        // return Move.getFromInt(Random.getInclude(1, 3));
    }
    @Override
    public Move nextMove(List<Move> availableMoves) {
        if(movesHistory.isEmpty()) return Move.STONE;
        
        MovePair lastMove = movesHistory.get(movesHistory.size() - 1);
        
        // AI choices (LoL its not called AI but algorithm. Anways)
        // If last move was succesfull then replay your own's last move.
        // If last move was unsucessfull then play the ennemy's last move.
        if(lastMove.comparison == MoveComparison.WON) return lastMove.aiMove; 
        if(lastMove.comparison == MoveComparison.LOST) return lastMove.humanMove;
        if(lastMove.comparison == MoveComparison.DRAW) return randomMove();

        return null;
    }

    @Override
    public void handleTurnOver(Move thisMove, Move otherMove, MoveComparison result) {
        movesHistory.add(new MovePair(otherMove, thisMove, result));
    }

}
