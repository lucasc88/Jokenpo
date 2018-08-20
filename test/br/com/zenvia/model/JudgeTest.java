package br.com.zenvia.model;

import br.com.zenvia.enums.Played;
import br.com.zenvia.enums.Status;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Lucas
 */
public class JudgeTest {

    private Player p1, p2;

    @Before
    public void init() {
        p1 = new Player();
        p2 = new Player();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAnalyzeMovementPlayersNull() {
        Player p1 = null;
        Player p2 = null;
        Judge.analyzeMovement(p1, p2);
    }

    @Test
    public void testAnalyzeMovementP1WonPaper() {
        p1.setPlayed(Played.PAPER);
        p2.setPlayed(Played.STONE);
        Judge.analyzeMovement(p1, p2);
        Assert.assertEquals(Status.VICTORY, p1.getStatus());
        Assert.assertEquals(Status.DEFEAT, p2.getStatus());
    }

    @Test
    public void testAnalyzeMovementP1WonStone() {
        p1.setPlayed(Played.STONE);
        p2.setPlayed(Played.SCISSORS);
        Judge.analyzeMovement(p1, p2);
        Assert.assertEquals(Status.VICTORY, p1.getStatus());
        Assert.assertEquals(Status.DEFEAT, p2.getStatus());
    }

    @Test
    public void testAnalyzeMovementP1WonScissors() {
        p1.setPlayed(Played.SCISSORS);
        p2.setPlayed(Played.PAPER);
        Judge.analyzeMovement(p1, p2);
        Assert.assertEquals(Status.VICTORY, p1.getStatus());
        Assert.assertEquals(Status.DEFEAT, p2.getStatus());
    }

    @Test
    public void testAnalyzeMovementP2WonScissors() {
        p1.setPlayed(Played.PAPER);
        p2.setPlayed(Played.SCISSORS);
        Judge.analyzeMovement(p1, p2);
        Assert.assertEquals(Status.VICTORY, p2.getStatus());
        Assert.assertEquals(Status.DEFEAT, p1.getStatus());
    }

    @Test
    public void testAnalyzeMovementP2WonPaper() {
        p1.setPlayed(Played.STONE);
        p2.setPlayed(Played.PAPER);
        Judge.analyzeMovement(p1, p2);
        Assert.assertEquals(Status.VICTORY, p2.getStatus());
        Assert.assertEquals(Status.DEFEAT, p1.getStatus());
    }

    @Test
    public void testAnalyzeMovementP2WonStone() {
        p1.setPlayed(Played.SCISSORS);
        p2.setPlayed(Played.STONE);
        Judge.analyzeMovement(p1, p2);
        Assert.assertEquals(Status.VICTORY, p2.getStatus());
        Assert.assertEquals(Status.DEFEAT, p1.getStatus());
    }

    @Test
    public void testAnalyzeMovementDrawPaper() {
        p1.setPlayed(Played.PAPER);
        p2.setPlayed(Played.PAPER);
        Judge.analyzeMovement(p1, p2);
        Assert.assertEquals(Status.DRAW, p1.getStatus());
        Assert.assertEquals(Status.DRAW, p2.getStatus());
    }

    @Test
    public void testAnalyzeMovementDrawStone() {
        p1.setPlayed(Played.STONE);
        p2.setPlayed(Played.STONE);
        Judge.analyzeMovement(p1, p2);
        Assert.assertEquals(Status.DRAW, p1.getStatus());
        Assert.assertEquals(Status.DRAW, p2.getStatus());
    }

    @Test
    public void testAnalyzeMovementDrawScissors() {
        p1.setPlayed(Played.SCISSORS);
        p2.setPlayed(Played.SCISSORS);
        Judge.analyzeMovement(p1, p2);
        Assert.assertEquals(Status.DRAW, p1.getStatus());
        Assert.assertEquals(Status.DRAW, p2.getStatus());
    }

    @Test(expected = NullPointerException.class)
    public void testAnalyzeMovementPlayedNull() {
        p1.setPlayed(null);
        Judge.analyzeMovement(p1, p2);
    }
}
