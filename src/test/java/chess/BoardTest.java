package chess;

import chess.pieces.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class BoardTest {

    private Board board;
    private Piece a1Piece;

    @Before
    public void before() {
        a1Piece = new Rook(Player.White);
        Map<Position, Piece> figures = new HashMap<>();

        // White Pieces
        figures.put(new Position("a1"), a1Piece);
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
    }

    @Test
    public void testFreePosition() {
        assertEquals(false, board.isPositionFree(new Position("a1")));
        assertEquals(true, board.isPositionFree(new Position("a3")));
    }

    @Test
    public void testHitPosition() {
        assertEquals(false, board.isPositionHit(Player.White, new Position("h2")));
        assertEquals(true, board.isPositionHit(Player.White, new Position("a8")));
        assertEquals(false, board.isPositionHit(Player.White, new Position("a3")));
    }

    @Test
    public void testFreeOrHitPosition() {
        assertEquals(false, board.isPositionFreeOrHit(Player.White, new Position("h2")));
        assertEquals(true, board.isPositionFreeOrHit(Player.White, new Position("a8")));
        assertEquals(true, board.isPositionFreeOrHit(Player.White, new Position("a3")));
    }

    @Test
    public void testGetPieceAtPosition() {
        assertEquals(a1Piece, board.getPieceAt(new Position("a1")));
        assertEquals(null, board.getPieceAt(new Position("a3")));
    }

    @Test
    public void testGetPlayerPositions() {
        Collection<Position> pieces = board.getPlayerPiecesPositions(Player.White);

        assertEquals(16, pieces.size());
        pieces.stream().forEach((p) -> {
            assertNotNull(board.getPieceAt(p).getOwner());
            assertEquals(Player.White, board.getPieceAt(p).getOwner());
        });
    }
}
