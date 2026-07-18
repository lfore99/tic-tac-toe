package tictactoe;

public class GameView {
    public static void outputWinner(Player player, String reason){
        String result = String.format("%s wins with a %s", player.getName(), reason);
        System.out.println(result);
    }
}
