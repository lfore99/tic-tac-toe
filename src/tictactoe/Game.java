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

        if (!board.isValidRowAndColumn(row, column)) {
            throw new IllegalArgumentException("Invalid position to make move");
        }

        if (board.isPositionAlreadyOccupied(row, column)) {
            throw new IllegalArgumentException("Position already set");
        }


        board.updateBoard(currentTurn, row, column);

        if(board.checkForWinningByRow(currentTurn)){
            GameView.outputWinner(currentTurn, "Row");
            markGameAsFinished(currentTurn);
        }

        if(board.checkForColumnWin(currentTurn)){
            GameView.outputWinner(currentTurn, "Column");
            markGameAsFinished(currentTurn);
        }

        if(board.checkForDiagonalWin(currentTurn)){
            GameView.outputWinner(currentTurn, "Diagonal");
            markGameAsFinished(currentTurn);
        }

        currentTurn = currentTurn == player1 ? player2 : player1;
        moveCounter++;

        if(moveCounter == totalMoves){
            setIsFinished(true);
        }
    }

    public void markGameAsFinished(Player player){
        setIsFinished(true);
        winner = player;
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
