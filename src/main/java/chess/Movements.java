package chess;

import chess.traverse.PositionMove;
import chess.traverse.PositionIterator;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Holds figures movements
 */
public enum Movements {

    QUEEN, PAWN, KNIGHT, KING, BISHOP, ROCK;

    public List<Position> getPossiblePositions(Board board, Player player, Position position) {
        switch (this) {
            case KING:
                return getKingPossiblePositions(board, player, position);
            case PAWN:
                return getPawnPossiblePositions(board, player, position);
            case QUEEN:
                return Stream.concat(
                        getBishopPossiblePositions(board, player, position).stream(),
                        getRockPossiblePositions(board, player, position).stream()
                ).collect(Collectors.toList());
            case BISHOP:
                return getBishopPossiblePositions(board, player, position);
            case KNIGHT:
                return getKnightPossiblePositions(board, player, position);
            case ROCK:
                return getRockPossiblePositions(board, player, position);
            default:
                throw new NotImplementedException();
        }
    }

    private List<Position> getKnightPossiblePositions(Board board, Player player, Position position) {
        List<Position> possibleList = new ArrayList<Position>();

        possibleList.add(position.move(1, 2));
        possibleList.add(position.move(2, 1));
        possibleList.add(position.move(2, -1));
        possibleList.add(position.move(1, -2));
        possibleList.add(position.move(-1, -2));
        possibleList.add(position.move(-2, -1));
        possibleList.add(position.move(-2, 1));
        possibleList.add(position.move(-1, 2));

        return possibleList.stream().filter((p) -> {
            return p != null && board.isPositionFreeOrHit(player, p);
        }).collect(Collectors.toList());
    }

    private List<Position> getKingPossiblePositions(Board board, Player player, Position position) {
        List<Position> possibleList = new ArrayList();

        possibleList.add(position.moveDown());
        possibleList.add(position.moveUp());
        possibleList.add(position.moveLeft());
        possibleList.add(position.moveRight());
        possibleList.add(position.moveUpRight());
        possibleList.add(position.moveUpLeft());
        possibleList.add(position.moveDownRight());
        possibleList.add(position.moveDownLeft());

        return possibleList.stream().filter((p) -> {
            return p != null && board.isPositionFreeOrHit(player, p);
        }).collect(Collectors.toList());
    }

    private List<Position> getPawnPossiblePositions(Board board, Player player, Position position) {
        List<Position> movements = new ArrayList();

        List<Position> hitMovements = new ArrayList();

        if (player.equals(Player.Black)) {
            movements.add(position.moveDown());
            hitMovements.add(position.moveDownLeft());
            hitMovements.add(position.moveDownRight());

            if (position.getRow() == 7) {
                movements.add(position.move(0, -2));
            }
        } else {
            movements.add(position.moveUp());

            hitMovements.add(position.moveUpLeft());
            hitMovements.add(position.moveUpRight());

            if (position.getRow() == 2) {
                movements.add(position.move(0, 2));
            }
        }

        return Stream.concat(movements.stream().filter((p) -> {
            return p != null && board.isPositionFree(p);
        }), hitMovements.stream().filter((p) -> {
            return p != null && board.isPositionHit(player, p);
        }) ).collect(Collectors.toList());
    }

    private List<Position> getRockPossiblePositions(Board board, Player player, Position position) {
        List<Position> positions = new ArrayList();
        positions.addAll(getHorizontallyMovements(board, player, position));
        positions.addAll(getVerticallyMovements(board, player, position));
        return positions;
    }

    private List<Position> getBishopPossiblePositions(Board board, Player player, Position position) {
        List<Position> positions = new ArrayList();
        positions.addAll(getDiagonallyUpMovements(board, player, position));
        positions.addAll(getDiagonallyDownMovements(board, player, position));
        return positions;
    }

    private List<Position> getHorizontallyMovements(Board board, Player player, Position position) {
        List<Position> possibleList = new ArrayList();

        possibleList.addAll(traverseBoard(
                board, player, (p) -> {return p.moveRight();}, position)
        );

        possibleList.addAll(traverseBoard(
                board, player, (p) -> {return p.moveLeft();}, position)
        );

        return possibleList;
    }

    private List<Position> getVerticallyMovements(Board board, Player player, Position position) {
        List<Position> possibleList = new ArrayList();

        possibleList.addAll(traverseBoard(
                board, player, (p) -> {return p.moveUp();}, position)
        );

        possibleList.addAll(traverseBoard(
                board, player, (p) -> {return p.moveDown();}, position)
        );

        return possibleList;
    }

    private List<Position> getDiagonallyUpMovements(Board board, Player player, Position position) {
        List<Position> possibleList = new ArrayList();

        possibleList.addAll(traverseBoard(
                board, player, (p) -> {return p.moveUpRight();}, position)
        );

        possibleList.addAll(traverseBoard(
                board, player, (p) -> {return p.moveDownLeft();}, position)
        );

        return possibleList;
    }

    private List<Position> getDiagonallyDownMovements(Board board, Player player, Position position) {
        List<Position> possibleList = new ArrayList();

        possibleList.addAll(traverseBoard(
                board, player, (p) -> {return p.moveDownRight();}, position)
        );

        possibleList.addAll(traverseBoard(
                board, player, (p) -> {return p.moveUpLeft();}, position)
        );

        return possibleList;
    }

    private List<Position> traverseBoard(Board board, Player player, PositionMove positionMove, Position position) {
        List<Position> possibleList = new ArrayList();
        PositionIterator iterator = new PositionIterator(position, positionMove);

        while (iterator.hasNext()) {
            Position nextPosition = iterator.next();
            if (board.isPositionFree(nextPosition)) {
                possibleList.add(nextPosition);
            } else {
                if (board.isPositionFreeOrHit(player, nextPosition)) {
                    possibleList.add(nextPosition);
                }
                break;
            }
        }
        return possibleList;
    }

}
