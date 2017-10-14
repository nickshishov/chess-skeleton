package chess.traverse;

import chess.Position;

public interface PositionMove {

    Position next(Position position);
}
