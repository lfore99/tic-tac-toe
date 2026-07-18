package tictactoe;

public class Player {
    private final char identifier;
    private final String name;

    public Player(char identifier, String name){
        this.identifier = identifier;
        this.name = name;
    }

    public char getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }
}
