package chess.traverse;

import chess.Position;

import java.util.Iterator;

public class PositionIterator implements Iterator<Position> {

    private Position nextPosition;
    private PositionMove positionMove;

    public PositionIterator(Position position, PositionMove positionMove) {
        this.positionMove = positionMove;
        this.nextPosition = positionMove.next(position);
    }

    @Override
    public boolean hasNext() {
        return nextPosition != null;
    }

    @Override
    public Position next() {
        Position position = nextPosition;
        nextPosition = positionMove.next(nextPosition);
        return position;
    }
}
