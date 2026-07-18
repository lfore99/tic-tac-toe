package tictactoe;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentTurn;
    private Player winner;
    private boolean finished;
    private int moveCounter;
    private static final int TOTAL_MOVES = 9;


    public Game(Player player1, Player player2) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.currentTurn = player1;
        this.finished = false;
        this.moveCounter = 0;
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
        moveCounter++;

        if(board.hasPlayerWon(currentTurn.getIdentifier())){
            GameView.outputWinner(currentTurn);
            setIsFinished();
            setWinner(currentTurn);
            return;
        }

        if(moveCounter == TOTAL_MOVES){
            setIsFinished();
        }

        switchPlayer();
    }

    private void switchPlayer(){
        currentTurn = currentTurn == player1 ? player2 : player1;
    }

    public boolean isFinished() {
        return finished;
    }

    private void setIsFinished(){
        this.finished = true;
    }

    public Player getWinner() {
        return winner;
    }

    public Board getBoard() {
        return board;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
