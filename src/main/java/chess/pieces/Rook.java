package chess.pieces;

import chess.Movements;
import chess.Player;

/**
 * The 'Rook' class
 */
public class Rook extends Piece {

    public Rook(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'r';
    }

    @Override
    public Movements getMovements() {
        return Movements.QUEEN;
    }
}
