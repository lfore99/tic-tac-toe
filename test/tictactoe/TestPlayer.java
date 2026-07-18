package tictactoe;


import java.util.ArrayList;
import java.util.List;

public class TestPlayer implements Player {

    private ArrayList<Move> moves;
    private final char identifier;

    public TestPlayer(char identifier){
        this.identifier = identifier;
    }

    @Override
    public Move chooseMove() {
        if(moves.isEmpty()) return null;

        return moves.remove(0);
    }

    @Override
    public char getIdentifier() {
        return identifier;
    }

    @Override
    public String getName() {
        return "PlayerOne";
    }

    public void setMoves(ArrayList<Move> moves) {
        this.moves = moves;
    }

    public List<Move> getMoves() {
        return moves;
    }
}
