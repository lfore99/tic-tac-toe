package tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    @Test
    public void given_row_and_column_out_of_bounds_for_grid_make_sure_exception_is_thrown(){
        Player player1 = new Player('O', "Player One");
        Player player2 = new Player('X', "Player Two");
        Board board = new Board(3, 3);
        Game game = new Game(board, player1, player2);

        Assert.assertThrows(IllegalArgumentException.class, () -> game.makeMove(4,4));
        Assert.assertThrows(IllegalArgumentException.class, () -> game.makeMove(0,0));
    }

    @Test
    public void given_valid_row_and_column_ensure_board_sets_identifier_of_player_correctly(){
        Player player1 = new Player('O', "Player One");
        Player player2 = new Player('X', "Player Two");
        Board board = new Board(3, 3);
        Game game = new Game(board, player1, player2);

        game.makeMove(1,1);
        Assert.assertEquals('O', board.getBoard()[0][0]);
    }

    @Test
    public void given_row_and_position_where_identifier_already_exists_make_sure_error_is_throw(){
        Player player1 = new Player('O', "Player One");
        Player player2 = new Player('X', "Player Two");
        Board board = new Board(3, 3);
        Game game = new Game(board, player1, player2);

        game.makeMove(3,3);

        Assert.assertThrows(IllegalArgumentException.class, () -> game.makeMove(3,3));
    }

    @Test
    public void given_valid_row_winner_ensure_game_successfully_detects_winner(){
        Player player1 = new Player('O', "Player One");
        Player player2 = new Player('X', "Player Two");
        Board board = new Board(3, 3);
        Game game = new Game(board, player1, player2);

        game.makeMove(1,1);
        game.makeMove(2,1);
        game.makeMove(1,2);
        game.makeMove(2,2);
        game.makeMove(1,3);

        Assert.assertEquals(player1, game.getWinner());
        Assert.assertEquals('O', board.getBoard()[0][0]);
        Assert.assertEquals('O', board.getBoard()[0][1]);
        Assert.assertEquals('O', board.getBoard()[0][2]);
    }

    @Test
    public void given_valid_column_winner_ensure_game_successfully_detects_winner(){
        Player player1 = new Player('O', "Player One");
        Player player2 = new Player('X', "Player Two");
        Board board = new Board(3, 3);
        Game game = new Game(board, player1, player2);

        game.makeMove(1,1);
        game.makeMove(1,2);
        game.makeMove(2,1);
        game.makeMove(2,2);
        game.makeMove(3,1);

        Assert.assertEquals(player1, game.getWinner());
        Assert.assertEquals('O', board.getBoard()[0][0]);
        Assert.assertEquals('O', board.getBoard()[1][0]);
        Assert.assertEquals('O', board.getBoard()[2][0]);
    }

    @Test
    public void given_valid_diagonal_winner_ensure_game_successfully_detects_winner(){
        Player player1 = new Player('O', "Player One");
        Player player2 = new Player('X', "Player Two");
        Board board = new Board(3, 3);
        Game game = new Game(board, player1, player2);

        game.makeMove(1,1);
        game.makeMove(1,2);
        game.makeMove(2,2);
        game.makeMove(2,3);
        game.makeMove(3,3);

        Assert.assertEquals(player1, game.getWinner());
        Assert.assertEquals('O', board.getBoard()[0][0]);
        Assert.assertEquals('O', board.getBoard()[1][1]);
        Assert.assertEquals('O', board.getBoard()[2][2]);
    }

    @Test
    public void given_other_valid_diagonal_winner_ensure_game_successfully_detects_winner(){
        Player player1 = new Player('O', "Player One");
        Player player2 = new Player('X', "Player Two");
        Board board = new Board(3, 3);
        Game game = new Game(board, player1, player2);

        game.makeMove(1,3);
        game.makeMove(1,2);
        game.makeMove(2,2);
        game.makeMove(2,3);
        game.makeMove(3,1);

        Assert.assertEquals(player1, game.getWinner());
        Assert.assertEquals('O', board.getBoard()[0][2]);
        Assert.assertEquals('O', board.getBoard()[1][1]);
        Assert.assertEquals('O', board.getBoard()[2][0]);
    }

    @Test
    public void given_every_piece_on_board_has_been_chosen_and_no_winner_has_been_found_game_should_end(){
        Player player1 = new Player('O', "Player One");
        Player player2 = new Player('X', "Player Two");
        Board board = new Board(3, 3);
        Game game = new Game(board, player1, player2);

        game.makeMove(1,1);
        game.makeMove(1,2);
        game.makeMove(2,1);
        game.makeMove(2,2);
        game.makeMove(2,3);
        game.makeMove(3,1);
        game.makeMove(1,3);
        game.makeMove(3,3);
        game.makeMove(3,2);

        Assert.assertNull(game.getWinner());
        Assert.assertTrue(game.isFinished());

    }

    @Test
    public void given_every_piece_on_board_has_been_chosen_and_no_winner_has_been_found_and_player_tries_to_still_go_should_throw_error(){
        Player player1 = new Player('O', "Player One");
        Player player2 = new Player('X', "Player Two");
        Board board = new Board(3, 3);
        Game game = new Game(board, player1, player2);

        game.makeMove(1,1);
        game.makeMove(1,2);
        game.makeMove(2,1);
        game.makeMove(2,2);
        game.makeMove(2,3);
        game.makeMove(3,1);
        game.makeMove(1,3);
        game.makeMove(3,3);
        game.makeMove(3,2);

        Assert.assertThrows(IllegalArgumentException.class, () -> game.makeMove(3,3));
        Assert.assertTrue(game.isFinished());

    }
}
