package tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void given_identifier_ensure_identifier_is_set_correctly(){
        Player p = new Player('O', "PlayerOne");

        Assert.assertEquals('O', p.getIdentifier());
    }
}
