package tictactoe;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class HumanPlayerTest {

    @Test
    public void given_identifier_ensure_identifier_is_set_correctly() {
        Scanner scanner = new Scanner(System.in);
        Player p = new HumanPlayer(scanner, 'O', "PlayerOne");

        Assert.assertEquals('O', p.getIdentifier());
    }

    @Test
    public void given_input_stream_ensure_we_get_correct_move_object_created() {
        InputStream stream = new ByteArrayInputStream("1 2".getBytes());
        Scanner scanner = new Scanner(stream);

        Player p = new HumanPlayer(scanner, '0', "PlayerOne");
        Move move = p.chooseMove();

        Assert.assertEquals(1, move.getRow());
        Assert.assertEquals(2, move.getColumn());
    }
}
