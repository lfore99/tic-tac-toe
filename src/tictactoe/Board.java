package tictactoe;

public class Board {
    private final char[][] grid;
    private static int ROWS = 3;
    private static int COLUMNS = 3;

    public Board(){
        this.grid = new char[ROWS][COLUMNS];
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++){
                grid[i][j] = '.';
            }
        }
    }

    public boolean checkForWinningByRow(Player player) {
        char identifier = player.getIdentifier();
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

    public boolean checkForColumnWin(Player player) {
        char identifier = player.getIdentifier();
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

    public boolean checkForDiagonalWin(Player player) {
        char identifier = player.getIdentifier();
        return (grid[0][0] == identifier && grid[1][1] == identifier && grid[2][2] == identifier) ||
                (grid[0][2] == identifier && grid[1][1] == identifier && grid[2][0] == identifier);

    }

    public boolean isValidRowAndColumn(int row, int column){
        if(row <= 0 || row > grid[0].length){
            return false;
        }

        if(column <= 0 || column > grid.length) {
            return false;
        }

        return true;
    }

    public boolean isPositionAlreadyOccupied(int row, int column){
        return grid[row - 1][column - 1] != '.';
    }

    public void updateBoard(Player player, int row, int column){
        grid[row - 1][column - 1] = player.getIdentifier();
    }


    public char[][] getGrid() {
        return grid;
    }

    public void displayBoard() {
        System.out.println();
        for (char[] chars : grid) {
            for (char aChar : chars) {
                System.out.print("|");
                System.out.print(aChar);
            }
            System.out.print("|");
            System.out.println();
        }
    }
}
