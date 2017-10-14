package chess.pieces;

import chess.Movements;
import chess.Player;

/**
 * The 'Bishop' class
 */
public class Bishop extends Piece {

    public Bishop(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'b';
    }

    @Override
    public Movements getMovements() {
        return Movements.BISHOP;
    }
}
