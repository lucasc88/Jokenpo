package br.com.zenvia.model;

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
        if(p1 == null || p2 == null){
            throw new UnsupportedOperationException("Invalid Players");
        }
        switch (p1.getPlayed()) {
            case STONE:
                switch (p2.getPlayed()) {
                    case STONE:
                        p1.setStatus(Status.DRAW);
                        p2.setStatus(Status.DRAW);
                        break;
                    case PAPER:
                        p1.setStatus(Status.DEFEAT);
                        p2.setStatus(Status.VICTORY);
                        break;
                    case SCISSORS:
                        p1.setStatus(Status.VICTORY);
                        p2.setStatus(Status.DEFEAT);
                        break;
                    default:
                        throw new UnsupportedOperationException("Invalid Moviment");
                }
                break;
            case PAPER:
                switch (p2.getPlayed()) {
                    case STONE:
                        p1.setStatus(Status.VICTORY);
                        p2.setStatus(Status.DEFEAT);
                        break;
                    case PAPER:
                        p1.setStatus(Status.DRAW);
                        p2.setStatus(Status.DRAW);
                        break;
                    case SCISSORS:
                        p1.setStatus(Status.DEFEAT);
                        p2.setStatus(Status.VICTORY);
                        break;
                    default:
                        throw new UnsupportedOperationException("Invalid Moviment");
                }
                break;
            case SCISSORS:
                switch (p2.getPlayed()) {
                    case STONE:
                        p1.setStatus(Status.DEFEAT);
                        p2.setStatus(Status.VICTORY);
                        break;
                    case PAPER:
                        p1.setStatus(Status.VICTORY);
                        p2.setStatus(Status.DEFEAT);
                        break;
                    case SCISSORS:
                        p1.setStatus(Status.DRAW);
                        p2.setStatus(Status.DRAW);
                        break;
                    default:
                        throw new UnsupportedOperationException("Invalid Moviment");
                }
                break;
            default:
                throw new UnsupportedOperationException("Invalid Moviment");
        }
    }
}
