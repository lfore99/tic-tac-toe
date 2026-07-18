package tictactoe;

public class Board {
    private final char[][] grid;
    private final static int ROWS = 3;
    private final static int COLUMNS = 3;

    public Board() {
        this.grid = new char[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                grid[i][j] = '.';
            }
        }
    }

    public boolean hasPlayerWon(char identifier) {
        return
                checkForWinningByRow(identifier) ||
                        checkForColumnWin(identifier) ||
                        checkForDiagonalWin(identifier);
    }

    private boolean checkForWinningByRow(char identifier) {
        int count = 0;

        for (char[] chars : grid) {
            for (char aChar : chars) {
                if (aChar == identifier) {
                    count++;
                }
            }

            if (count == 3) return true;
            count = 0;
        }

        return false;
    }

    private boolean checkForColumnWin(char identifier) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[j][i] == identifier) {
                    count++;
                }
            }
            if (count == 3) return true;
            count = 0;
        }

        return false;
    }

    private boolean checkForDiagonalWin(char identifier) {
        return (grid[0][0] == identifier && grid[1][1] == identifier && grid[2][2] == identifier) ||
                (grid[0][2] == identifier && grid[1][1] == identifier && grid[2][0] == identifier);

    }

    public void addToBoard(Player humanPlayer, Move move) {
        if (!isValidRowAndColumn(move)) {
            throw new IllegalArgumentException("Invalid position to make move");
        }

        if (!isPositionAlreadyOccupied(move)) {
            throw new IllegalArgumentException("Position already set");
        }

        grid[move.getRow() - 1][move.getColumn() - 1] = humanPlayer.getIdentifier();
    }

    public boolean isValidRowAndColumn(Move move) {
        if (move.getRow() <= 0 || move.getRow() > grid[0].length) {
            return false;
        }

        if (move.getColumn() <= 0 || move.getColumn() > grid.length) {
            return false;
        }

        return true;
    }

    public boolean isPositionAlreadyOccupied(Move move) {
        return grid[move.getRow() - 1][move.getColumn() - 1] != '.';
    }


    public char[][] getGrid() {
        return grid;
    }
}
