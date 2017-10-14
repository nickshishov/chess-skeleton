package chess.pieces;

import chess.Movements;
import chess.Player;

/**
 * The Queen
 */
public class Queen extends Piece{

    public Queen(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'q';
    }

    @Override
    public Movements getMovements() {
        return Movements.QUEEN;
    }
}
