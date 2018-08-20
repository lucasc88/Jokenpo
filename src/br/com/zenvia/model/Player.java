package br.com.zenvia.model;

import br.com.zenvia.enums.Played;
import br.com.zenvia.enums.Status;

/**
 *
 * @author Lucas
 */
public class Player {
    
    private String name;
    private Status status;
    private Played played;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Played getPlayed() {
        return played;
    }

    public void setPlayed(Played played) {
        this.played = played;
    }
}
