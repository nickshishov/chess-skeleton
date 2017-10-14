package chess;

import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Basic Unit Tests for the Position class
 */
public class PositionTest {

    @Test
    public void testStringParsingConstructor() {
        Position pos = new Position("d5");

        assertEquals("The column should be 'd'", 4, pos.getColumn());
        assertEquals("The row should be 5", 5, pos.getRow());
    }

    @Test
    public void testPositionEquality() {
        Position one = new Position('a', 1);
        Position other = new Position('a', 1);

        assertEquals("The positions should equal each other", one, other);
    }

    @Test
    public void testCheckPosition() {
        // give
        Position position = new Position("a1");
        // when
        Position newPosition = position.moveLeft();
        // then
        assertEquals("Position should not be moved out of board", null, newPosition);
    }

    @Test
    public void testMoveLeftOutOfPosition() {
        // give
        Position position = new Position("a1");
        // when
        Position newPosition = position.moveLeft();
        // then
        assertEquals("Position should not be moved out of board", null, newPosition);
    }

    @Test
    public void testMoveLeftPosition() {
        // give
        Position position = new Position("b1");
        // when
        Position newPosition = position.moveLeft();
        // then
        assertEquals("Position should not be moved left", "a1", newPosition.toString());
    }

    @Test
    public void testMoveUpOutOfPosition() {
        // give
        Position position = new Position("a8");
        // when
        Position newPosition = position.moveUp();
        // then
        assertEquals("Position should not be moved out of board", null, newPosition);
    }

    @Test
    public void testMoveUpPosition() {
        // give
        Position position = new Position("a1");
        // when
        Position newPosition = position.moveUp();
        // then
        assertEquals("Position should not be moved left", "a2", newPosition.toString());
    }

    @Test
    public void testMoveDownOutOfPosition() {
        // give
        Position position = new Position("a1");
        // when
        Position newPosition = position.moveDown();
        // then
        assertEquals("Position should not be moved out of board", null, newPosition);
    }

    @Test
    public void testMoveDownPosition() {
        // give
        Position position = new Position("a8");
        // when
        Position newPosition = position.moveDown();
        // then
        assertEquals("Position should not be moved left", "a7", newPosition.toString());
    }

    @Test
    public void testMoveUpRightOutOfPosition() {
        // give
        Position position = new Position("h8");
        // when
        Position newPosition = position.moveUpRight();
        // then
        assertEquals("Position should not be moved out of board", null, newPosition);
    }

    @Test
    public void testMoveUpRightPosition() {
        // give
        Position position = new Position("a1");
        // when
        Position newPosition = position.moveUpRight();
        // then
        assertEquals("Position should not be moved left", "b2", newPosition.toString());
    }

    @Test
    public void testMoveUpLeftOutOfPosition() {
        // give
        Position position = new Position("a1");
        // when
        Position newPosition = position.moveUpLeft();
        // then
        assertEquals("Position should not be moved out of board", null, newPosition);
    }

    @Test
    public void testMoveUpLeftPosition() {
        // give
        Position position = new Position("h1");
        // when
        Position newPosition = position.moveUpLeft();
        // then
        assertEquals("Position should not be moved left", "g2", newPosition.toString());
    }

    @Test
    public void testMoveDownLeftOutOfPosition() {
        // give
        Position position = new Position("a1");
        // when
        Position newPosition = position.moveDownLeft();
        // then
        assertEquals("Position should not be moved out of board", null, newPosition);
    }

    @Test
    public void testMoveDownLeftPosition() {
        // give
        Position position = new Position("h8");
        // when
        Position newPosition = position.moveDownLeft();
        // then
        assertEquals("Position should not be moved left", "g7", newPosition.toString());
    }

    @Test
    public void testMoveDownRightOutOfPosition() {
        // give
        Position position = new Position("h1");
        // when
        Position newPosition = position.moveDownRight();
        // then
        assertEquals("Position should not be moved out of board", null, newPosition);
    }

    @Test
    public void testMoveDownRightPosition() {
        // give
        Position position = new Position("a1");
        // when
        Position newPosition = position.moveDownRight();
        // then
        assertEquals("Position should not be moved left", "b2", newPosition.toString());
    }

    // todo: check "check" methods
}
