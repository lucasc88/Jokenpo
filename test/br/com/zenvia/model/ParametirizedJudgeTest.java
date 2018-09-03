package br.com.zenvia.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.com.zenvia.enums.Played;
import br.com.zenvia.enums.Status;

@RunWith(Parameterized.class)
public class ParametirizedJudgeTest {

	private Player p1, p2;
	private Status s1, s2;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{ new Player(Played.PAPER), new Player(Played.PAPER), Status.DRAW, Status.DRAW },
			{ new Player(Played.SCISSORS), new Player(Played.SCISSORS), Status.DRAW, Status.DRAW },
			{ new Player(Played.STONE), new Player(Played.STONE), Status.DRAW, Status.DRAW },
			{ new Player(Played.LIZARD), new Player(Played.LIZARD), Status.DRAW, Status.DRAW },
			{ new Player(Played.SPOCK), new Player(Played.SPOCK), Status.DRAW, Status.DRAW },
			
			{ new Player(Played.SCISSORS), new Player(Played.PAPER), Status.VICTORY, Status.DEFEAT },
			{ new Player(Played.PAPER), new Player(Played.STONE), Status.VICTORY, Status.DEFEAT },
			{ new Player(Played.STONE), new Player(Played.LIZARD), Status.VICTORY, Status.DEFEAT },
			{ new Player(Played.LIZARD), new Player(Played.SPOCK), Status.VICTORY, Status.DEFEAT },
			{ new Player(Played.SPOCK), new Player(Played.SCISSORS), Status.VICTORY, Status.DEFEAT },
			{ new Player(Played.SCISSORS), new Player(Played.LIZARD), Status.VICTORY, Status.DEFEAT },
			{ new Player(Played.LIZARD), new Player(Played.PAPER), Status.VICTORY, Status.DEFEAT },
			{ new Player(Played.PAPER), new Player(Played.SPOCK), Status.VICTORY, Status.DEFEAT },
			{ new Player(Played.SPOCK), new Player(Played.STONE), Status.VICTORY, Status.DEFEAT },
			{ new Player(Played.STONE), new Player(Played.SCISSORS), Status.VICTORY, Status.DEFEAT },
			
			{ new Player(Played.PAPER), new Player(Played.SCISSORS), Status.DEFEAT, Status.VICTORY},
			{ new Player(Played.STONE), new Player(Played.PAPER), Status.DEFEAT, Status.VICTORY},
			{ new Player(Played.LIZARD), new Player(Played.STONE), Status.DEFEAT, Status.VICTORY},
			{ new Player(Played.SPOCK), new Player(Played.LIZARD), Status.DEFEAT, Status.VICTORY},
			{ new Player(Played.SCISSORS), new Player(Played.SPOCK), Status.DEFEAT, Status.VICTORY},
			{ new Player(Played.PAPER), new Player(Played.LIZARD), Status.DEFEAT, Status.VICTORY},
			{ new Player(Played.SPOCK), new Player(Played.PAPER), Status.DEFEAT, Status.VICTORY},
			{ new Player(Played.STONE), new Player(Played.SPOCK), Status.DEFEAT, Status.VICTORY},
			{ new Player(Played.SCISSORS), new Player(Played.SPOCK), Status.DEFEAT, Status.VICTORY},
			{ new Player(Played.LIZARD), new Player(Played.SCISSORS), Status.DEFEAT, Status.VICTORY}
			
		});
	}

	public ParametirizedJudgeTest(Player played1, Player played2, Status status1, Status status2) {
		p1 = played1;
		p2 = played2;
		s1 = status1;
		s2 = status2;
	}

	@Test
	public void testVictoryStonePaper() {
		Judge.analyzeMovement(p1, p2);
		Assert.assertEquals("dica: " + p1.getPlayed() + ", "+ p2.getPlayed() ,s1, p1.getStatus());
		Assert.assertEquals(s2, p2.getStatus());
	}
	
}
