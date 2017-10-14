package chess;

/**
 * Describes a position on the Chess Board. Immutable
 */
public class Position {

    public static final int MIN_ROW = 1;
    public static final int MAX_ROW = 8;
    public static final int MIN_COLUMN = 1;
    public static final int MAX_COLUMN = 8;
    private final int row;
    private final int column;

    /**
     * Create a new position object
     *
     * @param column The column
     * @param row The row
     */
    public Position(char column, int row) {
        this.row = row;
        this.column = column - 'a' + 1;
    }

    public Position(int column, int row) {
        this.row = row;
        this.column = column;
    }

    /**
     * Create a new Position object by parsing the string
     * @param colrow The column and row to use.  I.e. "a1", "h7", etc.
     */
    public Position(String colrow) {
        this(colrow.toCharArray()[0], Character.digit(colrow.toCharArray()[1], 10));
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Position moveUp() {
        if (!checkPosition(column, row + 1)) {
            return null;
        }
        return new Position(column, row + 1);
    }

    public Position moveDown() {
        if (!checkPosition(column, row - 1)) {
            return null;
        }
        return new Position(column, row - 1);
    }

    public Position moveLeft() {
        if (!checkPosition(column - 1, row)) {
            return null;
        }
        return new Position(column - 1, row );
    }

    public Position moveRight() {
        if (!checkPosition(column + 1, row)) {
            return null;
        }
        return new Position(column + 1, row );
    }

    public Position moveUpLeft() {
        if (!checkPosition(column - 1, row + 1)) {
            return null;
        }
        return new Position(column - 1, row + 1 );
    }

    public Position moveUpRight() {
        if (!checkPosition(column + 1, row + 1)) {
            return null;
        }
        return new Position(column + 1, row + 1 );
    }

    public Position moveDownLeft() {
        if (!checkPosition(column - 1, row - 1)) {
            return null;
        }
        return new Position(column - 1, row - 1 );
    }

    public Position moveDownRight() {
        if (!checkPosition(column + 1, row - 1)) {
            return null;
        }
        return new Position(column + 1, row - 1);
    }

    public Position move(int column, int row) {
        if (!checkPosition(this.column + column, this.row + row)) {
            return null;
        }
        return new Position(this.column + column, this.row + row);
    }

    private boolean checkPosition(int column, int row) {
        return column <= MAX_COLUMN && column >= MIN_COLUMN && row <= MAX_ROW && row >= MIN_ROW;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (column != position.column) return false;

        //noinspection RedundantIfStatement
        if (row != position.row) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        return result;
    }

    @Override
    public String toString() {
        return "" + (char) (column + 'a' - 1) + row;
    }

}
