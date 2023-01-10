package com.example.chess.model;

import com.example.chess.model.dbModel.Player;
import com.example.chess.model.boaed.Cage;

public class Step {
    private Player player;
    private Cage start;
    private Cage end;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cage getStart() {
        return start;
    }

    public void setStart(Cage start) {
        this.start = start;
    }

    public Cage getEnd() {
        return end;
    }

    public void setEnd(Cage end) {
        this.end = end;
    }
}
