package chess;

import chess.pieces.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Immutable class for storing state of the game board. Container for pieces
 *
 */
public class Board {

    /**
     * A map of movements positions to pieces at that position
     */
    private Map<Position, Piece> positionToPieceMap;

    /**
     * Create the game state.
     */
    public Board(Map<Position, Piece> pieces) {
        positionToPieceMap = new HashMap<>();
        pieces.entrySet().stream().forEach((e) -> {
            positionToPieceMap.put(e.getKey(), e.getValue());
        });
    }

    /**
     * @param position
     * @return true if no figure on position
     */
    public boolean isPositionFree(Position position) {
        return getPieceAt(position) == null;
    }

    /**
     * @param position
     * @return true if no figure on position
     */
    public boolean isPositionHit(Player player, Position position) {
        Piece piece = getPieceAt(position);
        return piece != null && !piece.getOwner().equals(player);
    }

    /**
     * @param position
     * @return true if no figure on position
     */
    public boolean isPositionFreeOrHit(Player player, Position position) {
        Piece piece = getPieceAt(position);
        return piece == null || piece != null && !piece.getOwner().equals(player);
    }

    /**
     * Get the piece at a given position on the movements
     * @param position The position to inquire about.
     * @return The piece at that position, or null if it does not exist.
     */
    public Piece getPieceAt(Position position) {
        return positionToPieceMap.get(position);
    }

    public Collection<Position> getPlayerPiecesPositions(Player player) {
        return positionToPieceMap.keySet().stream().filter((p) -> {
            return positionToPieceMap.get(p).getOwner().equals(player);

        }).collect(Collectors.toList());
    }

    /**
     * Method to place a piece at a given position.
     * @param piece The piece to place
     * @return new version of board
     */
    public Board movePiece(Position position, Piece piece) {
        throw new NotImplementedException();
//        if (positionToPieceMap.get(position) != null) {
//            // throw
//        }
//        Map<Position, Piece> newMap = new HashMap<>(positionToPieceMap);
//        newMap.remove(position);
//        newMap.put(position, piece);
//        return new Board(newMap.values());
    }

}
