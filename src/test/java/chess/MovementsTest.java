package chess;

import chess.pieces.*;
import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertEquals;

public class MovementsTest {

    // White pawn
    @Test
    public void testBlackPawnPossiblePositions() {
        // give
        Map<Position, Piece> figures = new HashMap<>();

        // White Pieces
        figures.put(new Position("b6"), new Pawn(Player.White));
        figures.put(new Position("c5"), new Rook(Player.White));

        Board board = new Board(figures);
        // when
        List<Position> positions = Movements.PAWN.getPossiblePositions(
                board, Player.Black, new Position("b6")
        );
        // then
        Set<Position> possibleMovements = new HashSet<>();
        possibleMovements.add(new Position("c5"));
        possibleMovements.add(new Position("b5"));

        assertEquals(possibleMovements, new HashSet<>(positions));
    }

    @Test
    public void testBlackPawnPossiblePositionsFirstTurn() {
        // give
        Map<Position, Piece> figures = new HashMap<>();

        // White Pieces
        figures.put(new Position("b7"), new Pawn(Player.White));

        Board board = new Board(figures);
        // when
        List<Position> positions = Movements.PAWN.getPossiblePositions(
                board, Player.Black, new Position("b7")
        );
        // then
        Set<Position> possibleMovements = new HashSet<>();
        possibleMovements.add(new Position("b6"));
        possibleMovements.add(new Position("b5"));

        assertEquals(possibleMovements, new HashSet<>(positions));
    }

    // King
    @Test
    public void testGetKingPossiblePositions() {
        // give
        Map<Position, Piece> figures = new HashMap<>();

        // White Pieces
        figures.put(new Position("f8"), new King(Player.White));
        figures.put(new Position("e8"), new Rook(Player.White));

        // Black Pieces
        figures.put(new Position("g8"), new Rook(Player.Black));

        Board board = new Board(figures);
        // when
        List<Position> positions = Movements.KING.getPossiblePositions(
                board, Player.White, new Position("f8")
        );
        // then
        Set<Position> possibleMovements = new HashSet<>();
        possibleMovements.add(new Position("e7"));
        possibleMovements.add(new Position("f7"));
        possibleMovements.add(new Position("g7"));
        possibleMovements.add(new Position("g8"));

        assertEquals(possibleMovements, new HashSet<>(positions));
    }

    // Knight
    @Test
    public void testKnightPossiblePositions() {
        // give
        Map<Position, Piece> figures = new HashMap<>();

        // White Pieces
        figures.put(new Position("g3"), new Knight(Player.White));
        figures.put(new Position("h5"), new Rook(Player.White));

        // Black Pieces
        figures.put(new Position("f5"), new Rook(Player.Black));

        Board board = new Board(figures);
        // when
        List<Position> positions = Movements.KNIGHT.getPossiblePositions(
                board, Player.White, new Position("g3")
        );
        // then
        Set<Position> possibleMovements = new HashSet<>();
        possibleMovements.add(new Position("f5"));
        possibleMovements.add(new Position("e4"));
        possibleMovements.add(new Position("e2"));
        possibleMovements.add(new Position("f1"));
        possibleMovements.add(new Position("h1"));

        assertEquals(possibleMovements, new HashSet<>(positions));
    }

    // BISHOP
    @Test
    public void testBishopPossiblePositions() {
        // give
        Map<Position, Piece> figures = new HashMap<>();

        // White Pieces

        // Black Pieces
        figures.put(new Position("d5"), new Rook(Player.Black));

        Board board = new Board(figures);
        // when
        List<Position> positions = Movements.BISHOP.getPossiblePositions(
                board, Player.White, new Position("b7")
        );
        // then
        Set<Position> possibleMovements = new HashSet<>();
        possibleMovements.add(new Position("a8"));
        possibleMovements.add(new Position("a6"));
        possibleMovements.add(new Position("c8"));
        possibleMovements.add(new Position("c6"));
        possibleMovements.add(new Position("d5"));

        assertEquals(possibleMovements, new HashSet<>(positions));
    }

    // ROCK
    @Test
    public void testRockPossiblePositions() {
        // give
        Map<Position, Piece> figures = new HashMap<>();

        // White Pieces

        // Black Pieces
        figures.put(new Position("b4"), new Rook(Player.Black));

        Board board = new Board(figures);
        // when
        List<Position> positions = Movements.ROCK.getPossiblePositions(
                board, Player.White, new Position("b7")
        );
        // then
        Set<Position> possibleMovements = new HashSet<>();
        possibleMovements.add(new Position("a7"));
        possibleMovements.add(new Position("b8"));
        possibleMovements.add(new Position("b5"));
        possibleMovements.add(new Position("b6"));
        possibleMovements.add(new Position("b4"));
        possibleMovements.add(new Position("c7"));
        possibleMovements.add(new Position("d7"));
        possibleMovements.add(new Position("e7"));
        possibleMovements.add(new Position("f7"));
        possibleMovements.add(new Position("g7"));
        possibleMovements.add(new Position("h7"));

        assertEquals(possibleMovements, new HashSet<>(positions));
    }
}
