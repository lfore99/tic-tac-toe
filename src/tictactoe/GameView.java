package tictactoe;

public class GameView {
    public static void outputWinner(Player player){
        String result = String.format("%s wins", player.getName());
        System.out.println(result);
    }
}
