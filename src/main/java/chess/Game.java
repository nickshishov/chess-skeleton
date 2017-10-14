package chess;

import chess.pieces.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class that represents Chess Game. Responsibilities - managing current player and movements.
 */
public class Game {

    /**
     * The current player
     */
    private Player currentPlayer = Player.White;
    private Board board;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Game() {
        this.board = new Board(getStartFigures());
    }

    /**
     *
     * @param board
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     * Stub for move command
     */
    public void move(Position from, Position to) {
        throw new NotImplementedException();
//        Piece piece = board.getPieceAt(from);
//
//        if (piece == null) {
//        }
//
//        if (!piece.getOwner().equals(currentPlayer)) {
//        }
//
//        if ( check piece.getMovements()) { // can be moved?
//        }
//
//        board = board.movePiece(to, piece);
//
//        currentPlayer =
    }

    /**
     * Stub for is Game Over functionality
     * @return true if game is complete
     */
    public boolean isGameDone() {
        throw new NotImplementedException();
    }

    /**
     * @return possible movements of current user
     */
    public List<Move> getPossibleMovements() {
        return board.getPlayerPiecesPositions(currentPlayer).stream().flatMap((position) -> {
            Piece piece = board.getPieceAt(position);

            return piece.getMovements().getPossiblePositions(board, piece.getOwner(), position)
                    .stream()
                    .map((pos) -> {
                        return new Move(position, pos);
                    });

        }).collect(Collectors.toList());
    }

    private Map<Position, Piece> getStartFigures() {
        Map<Position, Piece> figures = new HashMap<>();

        // White Pieces
        figures.put(new Position("a1"), new Rook(Player.White));
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

        return figures;
    }

    /**
     * Visible for CLI. Should be removed todo
     * @return
     */
    public Board getBoard() {
        return board;
    }
}
