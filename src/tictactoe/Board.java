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
