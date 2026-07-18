package tictactoe;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final char identifier;
    private final String name;
    private final Scanner scanner;

    public HumanPlayer(Scanner scanner, char identifier, String name){
        this.scanner = scanner;
        this.identifier = identifier;
        this.name = name;
    }

    @Override
    public Move chooseMove() {
        int row = scanner.nextInt();
        int column = scanner.nextInt();

        return new Move(row, column);
    }

    @Override
    public char getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

}
