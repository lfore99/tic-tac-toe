package tictactoe;

public interface Player {
    Move chooseMove();
    char getIdentifier();
    String getName();
}
