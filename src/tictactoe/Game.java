package tictactoe;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentTurn;
    private Player winner;
    private boolean finished;
    private int moveCounter;
    private final int totalMoves;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentTurn = player1;
        this.finished = false;
        this.moveCounter = 0;
        this.totalMoves = 9;
    }

    public void makeMove(int row, int column) {
        if (isFinished()) {
            throw new IllegalArgumentException("Game is finished");
        }

        if (row <= 0 || row > board.getBoard().length) {
            throw new IllegalArgumentException("Invalid position to make move");
        }

        // handle indexes ie if they choose row 3 it would need to set in row 2 of array
        row--;
        column--;

        //check someone hasn't moved there already
        if (board.getBoard()[row][column] != '.') {
            throw new IllegalArgumentException("Position already set");
        }


        char identifier = currentTurn.getIdentifier();
        board.getBoard()[row][column] = identifier;

        if (checkForWinningByRow(currentTurn) || checkForColumnWin(currentTurn) || checkForDiagonalWin(currentTurn)) {
            winner();
        }

        currentTurn = currentTurn == player1 ? player2 : player1;
        moveCounter++;

        if(moveCounter == totalMoves){
            setIsFinished(true);
        }
    }

    private boolean checkForWinningByRow(Player player) {
        char identifier = player.getIdentifier();
        int count = 0;

        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                if (board.getBoard()[i][j] == identifier) {
                    count++;
                }
            }

            if (count == 3) return true;
            count = 0;
        }

        return false;
    }

    private boolean checkForColumnWin(Player player) {
        char identifier = player.getIdentifier();
        int count = 0;

        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                if (board.getBoard()[j][i] == identifier) {
                    count++;
                }
            }
            if (count == 3) return true;
            count = 0;
        }

        return false;
    }

    private boolean checkForDiagonalWin(Player player) {
        char identifier = player.getIdentifier();
        return (board.getBoard()[0][0] == identifier && board.getBoard()[1][1] == identifier && board.getBoard()[2][2] == identifier) ||
                (board.getBoard()[0][2] == identifier && board.getBoard()[1][1] == identifier && board.getBoard()[2][0] == identifier);

    }

    private void winner() {
        System.out.println(currentTurn.getIdentifier() + " wins!");
        System.out.println("Winning tictactoe.Board:");
        board.displayBoard();
        finished = true;
        winner = currentTurn;
    }

    public boolean isFinished() {
        return finished;
    }

    private void setIsFinished(boolean finished){
        this.finished = finished;
    }

    public Player getWinner() {
        return winner;
    }
}
