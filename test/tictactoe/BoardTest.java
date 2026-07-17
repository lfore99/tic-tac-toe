package tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class BoardTest {
    @Test
    public void given_row_and_column_ensure_board_is_built_with_correct_size(){
        Board board = new Board(3, 3);

        Assert.assertEquals(3, board.getBoard().length);
        Assert.assertEquals(3, board.getBoard()[0].length);
    }
}
