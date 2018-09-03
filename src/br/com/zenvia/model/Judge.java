package br.com.zenvia.model;

import br.com.zenvia.enums.Played;
import br.com.zenvia.enums.Status;

/**
 *
 * @author Lucas
 */
public class Judge {

	/**
	 * Method responsible for analyzing and generating results of Jokenpo's
	 * moves
	 *
	 * @param p1
	 * @param p2
	 */
	public static void analyzeMovement(Player p1, Player p2) {
		if (p1 == null || p2 == null) {
			throw new UnsupportedOperationException("Invalid Players");
		}
		if (p1.getPlayed().equals(p2.getPlayed())) {
			p1.setStatus(Status.DRAW);
			p2.setStatus(Status.DRAW);
			return;
		}

		switch (p1.getPlayed()) {
		case STONE:
			checkStonePlayed(p1, p2);
			break;
		case PAPER:
			checkPaperPlayed(p1, p2);
			break;
		case SCISSORS:
			checkScissorsPlayed(p1, p2);
			break;
		case LIZARD:
			checkLizardPlayed(p1,p2);
			break;
		case SPOCK:
			checkSpockPlayed(p1,p2);
			break;
		default:
			throw new UnsupportedOperationException("Invalid Moviment");
		}
	}

	private static void checkSpockPlayed(Player p1, Player p2) {
		if(p2.getPlayed().equals(Played.STONE) || p2.getPlayed().equals(Played.SCISSORS)){
			player1Wins(p1, p2, true);
		} else {
			player1Wins(p1, p2, false);
		}
	}

	private static void checkLizardPlayed(Player p1, Player p2) {
		if(p2.getPlayed().equals(Played.PAPER) || p2.getPlayed().equals(Played.SPOCK)){
			player1Wins(p1, p2, true);
		} else {
			player1Wins(p1, p2, false);
		}
	}

	private static void checkScissorsPlayed(Player p1, Player p2) {
		if(p2.getPlayed().equals(Played.PAPER) || p2.getPlayed().equals(Played.LIZARD)){
			player1Wins(p1, p2, true);
		} else {
			player1Wins(p1, p2, false);
		}
	}

	private static void checkStonePlayed(Player p1, Player p2) {
		if(p2.getPlayed().equals(Played.SCISSORS) || p2.getPlayed().equals(Played.LIZARD)){
			player1Wins(p1, p2, true);
		} else {
			player1Wins(p1, p2, false);
		}
	}
	
	private static void checkPaperPlayed(Player p1, Player p2) {
		if(p2.getPlayed().equals(Played.STONE) || p2.getPlayed().equals(Played.SPOCK)){
			player1Wins(p1, p2, true);
		} else {
			player1Wins(p1, p2, false);
		}
	}
	

	private static void player1Wins(Player p1, Player p2, boolean oneWins) {
		if (oneWins) {
			p1.setStatus(Status.VICTORY);
			p2.setStatus(Status.DEFEAT);
		} else {
			p1.setStatus(Status.DEFEAT);
			p2.setStatus(Status.VICTORY);
		}
	}

}
