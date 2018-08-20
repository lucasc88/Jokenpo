package br.com.zenvia.app;

import br.com.zenvia.enums.Played;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas
 */
public class AppTest {

    @Test
    public void testGeneratesMovement() {
        Played result = App.generatesMovement();
        assertTrue(result.equals(Played.PAPER) || result.equals(Played.STONE)
                || result.equals(Played.SCISSORS));
    }
}
