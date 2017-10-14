package chess;

import chess.pieces.*;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.*;

/**
 * Basic unit tests for the Board class
 */
public class GameTest {

    private Board board;
    private Game game;

    @Before
    public void setUp() {
        Map<Position, Piece> figures = new HashMap<>();

        // White Pieces
        figures.put(new Position("a1"), new Rook(Player.White));
        figures.put(new Position("b1"), new Knight(Player.White));
        figures.put(new Position("c1"), new Bishop(Player.White));
        figures.put(new Position("d1"), new Queen(Player.White));
        figures.put(new Position("e1"), new King(Player.White));
        figures.put(new Position("f1"), new Bishop(Player.White));
        figures.put(new Position("g1"), new Knight(Player.White));
        figures.put(new Position("h1"), new Rook(Player.White));
        figures.put(new Position("a2"), new Pawn(Player.White));
        figures.put(new Position("b2"), new Pawn(Player.White));
        figures.put(new Position("c2"), new Pawn(Player.White));
        figures.put(new Position("d2"), new Pawn(Player.White));
        figures.put(new Position("e2"), new Pawn(Player.White));
        figures.put(new Position("f2"), new Pawn(Player.White));
        figures.put(new Position("g2"), new Pawn(Player.White));
        figures.put(new Position("h2"), new Pawn(Player.White));

        // Black Pieces
        figures.put(new Position("a8"), new Rook(Player.Black));
        figures.put(new Position("b8"), new Knight(Player.Black));
        figures.put(new Position("c8"), new Bishop(Player.Black));
        figures.put(new Position("d8"), new Queen(Player.Black));
        figures.put(new Position("e8"), new King(Player.Black));
        figures.put(new Position("f8"), new Bishop(Player.Black));
        figures.put(new Position("g8"), new Knight(Player.Black));
        figures.put(new Position("h8"), new Rook(Player.Black));
        figures.put(new Position("a7"), new Pawn(Player.Black));
        figures.put(new Position("b7"), new Pawn(Player.Black));
        figures.put(new Position("c7"), new Pawn(Player.Black));
        figures.put(new Position("d7"), new Pawn(Player.Black));
        figures.put(new Position("e7"), new Pawn(Player.Black));
        figures.put(new Position("f7"), new Pawn(Player.Black));
        figures.put(new Position("g7"), new Pawn(Player.Black));
        figures.put(new Position("h7"), new Pawn(Player.Black));

        board = new Board(figures);
        game = new Game(board);
    }

    @Test
    public void testGetPossibleMovements() {
        // Player is white
        // when
        Collection<Move> moves = game.getPossibleMovements();

        Set<Move> movesSet = new HashSet<>();
        movesSet.add(new Move("a2", "a3"));
        movesSet.add(new Move("a2", "a4"));
        movesSet.add(new Move("b2", "b3"));
        movesSet.add(new Move("b2", "b4"));
        movesSet.add(new Move("c2", "c3"));
        movesSet.add(new Move("c2", "c4"));
        movesSet.add(new Move("d2", "d3"));
        movesSet.add(new Move("d2", "d4"));
        movesSet.add(new Move("e2", "e3"));
        movesSet.add(new Move("e2", "e4"));
        movesSet.add(new Move("f2", "f3"));
        movesSet.add(new Move("f2", "f4"));
        movesSet.add(new Move("g2", "g3"));
        movesSet.add(new Move("g2", "g4"));
        movesSet.add(new Move("h2", "h3"));
        movesSet.add(new Move("h2", "h4"));

        movesSet.add(new Move("b1", "a3"));
        movesSet.add(new Move("b1", "c3"));

        movesSet.add(new Move("g1", "f3"));
        movesSet.add(new Move("g1", "h3"));
        // then
        assertEquals(movesSet, new HashSet<>(moves));

    }

    @Test
    public void testInitialGame() {
        Board board = game.getBoard();

        // White should be the first player
        Player current = game.getCurrentPlayer();
        assertEquals("The initial player should be White", Player.White, current);

        // Spot check a few pieces
        Piece whiteRook = board.getPieceAt(new Position("a1"));
        assertTrue("A rook should be at a1", whiteRook instanceof Rook);
        assertEquals("The rook at a1 should be owned by White", Player.White, whiteRook.getOwner());


        Piece blackQueen = board.getPieceAt(new Position("d8"));
        assertTrue("A queen should be at d8", blackQueen instanceof Queen);
        assertEquals("The queen at d8 should be owned by Black", Player.Black, blackQueen.getOwner());
    }
}
