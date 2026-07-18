package tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    private TestPlayer playerOne;
    private TestPlayer playerTwo;

    @Before
    public void run() {
        this.playerOne = new TestPlayer('O');
        this.playerTwo = new TestPlayer('X');
    }


    @Test
    public void given_row_and_column_out_of_bounds_for_grid_make_sure_exception_is_thrown() {
        List<Move> movesForPlayer1 = List.of(new Move(0, 0));

        playerOne.setMoves(new ArrayList<>(movesForPlayer1));

        Game game = new Game(playerOne, playerTwo);

        Assert.assertThrows(IllegalArgumentException.class, () -> game.makeMove());
    }

    @Test
    public void given_valid_row_and_column_ensure_board_sets_identifier_of_player_correctly() {
        List<Move> movesForPlayer1 = List.of(new Move(1, 1));

        playerOne.setMoves(new ArrayList<>(movesForPlayer1));

        Game game = new Game(playerOne, playerTwo);

        game.makeMove();

        Assert.assertEquals('O', game.getBoard().getGrid()[0][0]);
    }

    @Test
    public void given_row_and_position_where_identifier_already_exists_make_sure_error_is_throw() {
        List<Move> movesForPlayer1 = List.of(new Move(1, 1));
        List<Move> movesForPlayer2 = List.of(new Move(1, 1));

        playerOne.setMoves(new ArrayList<>(movesForPlayer1));
        playerTwo.setMoves(new ArrayList<>(movesForPlayer2));

        Game game = new Game(playerOne, playerTwo);

        game.makeMove();

        Assert.assertThrows(IllegalArgumentException.class, () -> game.makeMove());
    }

    @Test
    public void given_valid_row_winner_ensure_game_successfully_detects_winner() {
        List<Move> movesForPlayer1 = List.of(new Move(1, 1), new Move(1, 2), new Move(1, 3));
        List<Move> movesForPlayer2 = List.of(new Move(2, 1), new Move(2, 2));

        playerOne.setMoves(new ArrayList<>(movesForPlayer1));
        playerTwo.setMoves(new ArrayList<>(movesForPlayer2));

        Game game = new Game(playerOne, playerTwo);

        for (int i = 0; i < movesForPlayer1.size() + movesForPlayer2.size(); i++) {
            game.makeMove();
        }

        Assert.assertEquals(playerOne, game.getWinner());
        Assert.assertEquals('O', game.getBoard().getGrid()[0][0]);
        Assert.assertEquals('O', game.getBoard().getGrid()[0][1]);
        Assert.assertEquals('O', game.getBoard().getGrid()[0][2]);
    }

    @Test
    public void given_valid_column_winner_ensure_game_successfully_detects_winner() {
        List<Move> movesForPlayer1 = List.of(new Move(1, 1), new Move(2, 1), new Move(3, 1));
        List<Move> movesForPlayer2 = List.of(new Move(1, 2), new Move(2, 2));

        playerOne.setMoves(new ArrayList<>(movesForPlayer1));
        playerTwo.setMoves(new ArrayList<>(movesForPlayer2));

        Game game = new Game(playerOne, playerTwo);

        for (int i = 0; i < movesForPlayer1.size() + movesForPlayer2.size(); i++) {
            game.makeMove();
        }

        Assert.assertEquals(playerOne, game.getWinner());
        Assert.assertEquals('O', game.getBoard().getGrid()[0][0]);
        Assert.assertEquals('O', game.getBoard().getGrid()[1][0]);
        Assert.assertEquals('O', game.getBoard().getGrid()[2][0]);
    }

    @Test
    public void given_valid_diagonal_winner_ensure_game_successfully_detects_winner() {
        List<Move> movesForPlayer1 = List.of(new Move(1, 1), new Move(2, 2), new Move(3, 3));
        List<Move> movesForPlayer2 = List.of(new Move(1, 2), new Move(2, 1));

        playerOne.setMoves(new ArrayList<>(movesForPlayer1));
        playerTwo.setMoves(new ArrayList<>(movesForPlayer2));

        Game game = new Game(playerOne, playerTwo);

        for (int i = 0; i < movesForPlayer1.size() + movesForPlayer2.size(); i++) {
            game.makeMove();
        }

        Assert.assertEquals(playerOne, game.getWinner());
        Assert.assertEquals('O', game.getBoard().getGrid()[0][0]);
        Assert.assertEquals('O', game.getBoard().getGrid()[1][1]);
        Assert.assertEquals('O', game.getBoard().getGrid()[2][2]);
    }

    @Test
    public void given_other_valid_diagonal_winner_ensure_game_successfully_detects_winner() {
        List<Move> movesForPlayer1 = List.of(new Move(1, 3), new Move(2, 2), new Move(3, 1));
        List<Move> movesForPlayer2 = List.of(new Move(1, 2), new Move(2, 3));

        playerOne.setMoves(new ArrayList<>(movesForPlayer1));
        playerTwo.setMoves(new ArrayList<>(movesForPlayer2));

        Game game = new Game(playerOne, playerTwo);

        for (int i = 0; i < movesForPlayer1.size() + movesForPlayer2.size(); i++) {
            game.makeMove();
        }

        Assert.assertEquals(playerOne, game.getWinner());
        Assert.assertEquals('O', game.getBoard().getGrid()[0][2]);
        Assert.assertEquals('O', game.getBoard().getGrid()[1][1]);
        Assert.assertEquals('O', game.getBoard().getGrid()[2][0]);
    }

    @Test
    public void given_every_piece_on_board_has_been_chosen_and_no_winner_has_been_found_game_should_end() {
        List<Move> movesForPlayer1 = List.of(new Move(1, 3), new Move(2, 1), new Move(2, 2), new Move(3, 2), new Move(3, 3));
        List<Move> movesForPlayer2 = List.of(new Move(1, 1), new Move(1, 2), new Move(2, 3), new Move(3, 1));

        playerOne.setMoves(new ArrayList<>(movesForPlayer1));
        playerTwo.setMoves(new ArrayList<>(movesForPlayer2));

        Game game = new Game(playerOne, playerTwo);


        for (int i = 0; i < movesForPlayer1.size() + movesForPlayer2.size(); i++) {
            game.makeMove();
        }

        Assert.assertThrows(IllegalArgumentException.class, () -> game.makeMove());
        Assert.assertTrue(game.isFinished());

    }

    @Test
    public void given_every_piece_on_board_has_been_chosen_and_no_winner_has_been_found_and_player_tries_to_still_go_should_throw_error() {
        List<Move> movesForPlayer1 = List.of(new Move(1, 3), new Move(2, 1), new Move(2, 2), new Move(3, 2), new Move(3, 3));
        List<Move> movesForPlayer2 = List.of(new Move(1, 1), new Move(1, 2), new Move(2, 3), new Move(3, 1), new Move(3, 2));

        playerOne.setMoves(new ArrayList<>(movesForPlayer1));
        playerTwo.setMoves(new ArrayList<>(movesForPlayer2));

        Game game = new Game(playerOne, playerTwo);


        for (int i = 0; i < movesForPlayer1.size() + movesForPlayer2.size() - 1; i++) {
            game.makeMove();
        }

        Assert.assertThrows(IllegalArgumentException.class, () -> game.makeMove());
        Assert.assertTrue(game.isFinished());

    }
}
