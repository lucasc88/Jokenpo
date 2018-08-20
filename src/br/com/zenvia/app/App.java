package br.com.zenvia.app;

import br.com.zenvia.enums.Played;
import br.com.zenvia.enums.Status;
import br.com.zenvia.model.Judge;
import br.com.zenvia.model.Player;
import java.util.Random;

/**
 *
 * @author Lucas
 */
public class App {

    private static Player p1, p2;
    private static int won1, drew1, lost1, won2, drew2, lost2;

    public static void main(String[] args) {
        p1 = new Player();
        p1.setName("Player 1");
        p2 = new Player();
        p2.setName("Player 2");

        for (int i = 0; i < 100; i++) {
            p1.setPlayed(generatesMovement());
            p2.setPlayed(generatesMovement());
            Judge.analyzeMovement(p1, p2);
            scoreboard(p1, p2);
        }
        
        System.out.println("After a hundred played -> Final ScoreBoard:");
        System.out.println(p1.getName() + " won: " + won1 + ", drew: " + drew1 + ", lost: " + lost1);
        System.out.println(p2.getName() + " won: " + won2 + ", drew: " + drew2 + ", lost: " + lost2);
    }

    public static Played generatesMovement() {
        Random rand = new Random();
        return Played.values()[rand.nextInt(Status.values().length)];
    }

    private static void scoreboard(Player p1, Player p2) {
        if (p1.getStatus().equals(Status.VICTORY)) {
            won1++;
            lost2++;
        } else if (p2.getStatus().equals(Status.VICTORY)) {
            lost1++;
            won2++;
        } else {
            drew1++;
            drew2++;
        }
    }
}
