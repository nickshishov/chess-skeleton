package chess.pieces;

import chess.Movements;
import chess.Player;

/**
 * A base class for chess pieces
 */
public abstract class Piece {

    private final Player owner;

    protected Piece(Player owner) {
        this.owner = owner;
    }

    public char getIdentifier() {
        char id = getIdentifyingCharacter();
        if (owner.equals(Player.White)) {
            return Character.toLowerCase(id);
        } else {
            return Character.toUpperCase(id);
        }
    }

    public Player getOwner() {
        return owner;
    }

    public abstract Movements getMovements();

    protected abstract char getIdentifyingCharacter();
}
