package tictactoe;

public class Board {
    private final char[][] board;

    public Board(int row, int columns){
        this.board = new char[row][columns];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < columns; j++){
                board[i][j] = '.';
            }
        }
    }

    public boolean checkForWinningByRow(Player player) {
        char identifier = player.getIdentifier();
        int count = 0;

        for (char[] chars : board) {
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

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == identifier) {
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
        return (board[0][0] == identifier && board[1][1] == identifier && board[2][2] == identifier) ||
                (board[0][2] == identifier && board[1][1] == identifier && board[2][0] == identifier);

    }

    public boolean isValidRowAndColumn(int row, int column){
        if(row <= 0 || row > board[0].length){
            return false;
        }

        if(column <= 0 || column > board.length) {
            return false;
        }

        return true;
    }

    public boolean isPositionAlreadyOccupied(int row, int column){
        return board[row - 1][column - 1] != '.';
    }

    public void updateBoard(Player player, int row, int column){
        board[row - 1][column - 1] = player.getIdentifier();
    }


    public char[][] getBoard() {
        return board;
    }

    public void displayBoard() {
        System.out.println();
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print("|");
                System.out.print(aChar);
            }
            System.out.print("|");
            System.out.println();
        }
    }
}
