package tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class BoardTest {
    @Test
    public void given_row_and_column_ensure_board_is_built_with_correct_size(){
        Board board = new Board();

        Assert.assertEquals(3, board.getGrid().length);
        Assert.assertEquals(3, board.getGrid()[0].length);
    }
}
