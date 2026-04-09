package labs.janken.domains.players;

import java.util.ArrayList;
import java.util.List;
import util.Random;

import labs.janken.domains.Move;
import labs.janken.domains.MoveComparison;

public class AiExperiementedPlayer extends BasePlayer {

    private record MovePair(Move humanMove, Move aiMove, MoveComparison comparison) {}
    private final ArrayList<MovePair> movesHistory = new ArrayList<MovePair>();
    
    public AiExperiementedPlayer(String name) {
        super(name);
    }
    
    private static Move randomMove() {
        return Move.getFromInt(Random.getInclude(1, 3));
    }

    @Override
    public Move nextMove(List<Move> availableMoves) {
        // AI choices (LoL its not called AI but algorithm. Anways)
        //      If First round then PAPER
        //      If Second round
        //          If last move was succesfull then replay your own's last move.
        //          If last move was unsucessfull then play unused move.
        //          If last move was draw then play
        //      If Third+ round and played same move then play best move.
        if(movesHistory.isEmpty()) return Move.PAPER;
        
        
        MovePair lastMove = movesHistory.get(movesHistory.size() - 1);
        if(movesHistory.size() == 1 || (movesHistory.size() == 2 && movesHistory.get(movesHistory.size() - 2).humanMove != lastMove.humanMove)) {
            if(lastMove.comparison == MoveComparison.WON) return lastMove.aiMove; // If sucess then replay it.

            if(lastMove.comparison == MoveComparison.LOST) { // If unscuess play unsued move.
                int missingValue = Move.getSumIndex() - (lastMove.aiMove.toInt() + lastMove.humanMove.toInt()); 
                return Move.getFromInt(missingValue);
            };
            return randomMove(); // If draw then play random move.
        }

        /// Round 3+ or the ennemy is a 'previsible' human
        /// A.I play the counter move of the last previsible move.
        int counterMove = (lastMove.humanMove.toInt() % 3) + 1;
        return Move.getFromInt(counterMove);
    }

    @Override
    public void handleTurnOver(Move thisMove, Move otherMove, MoveComparison result) {
        movesHistory.add(new MovePair(otherMove, thisMove, result));
    }

}
