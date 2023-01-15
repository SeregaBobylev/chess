package com.example.chess.model;

import com.example.chess.model.dbModel.Player;
import com.example.chess.model.board.Cage;

public class Step {
    private Player player;
    private Cage start;
    private Cage end;

    public Step(Player player, Cage start, Cage end) {
        this.player = player;
        this.start = start;
        this.end = end;
    }

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

    public boolean checkBoundaries(){
        return start.checkBoundaries() && end.checkBoundaries();
    }
    public boolean isDirectStep(){
        return !isStartPosEqualsEndPos() && start.getCol()==end.getCol();
    }
    public boolean isVerticalStep(){
        return !isStartPosEqualsEndPos() && start.getRow()==end.getRow();
    }
    public boolean isHorizontalStep(){
        return !isStartPosEqualsEndPos() && start.getCol()==end.getCol();
    }
    public boolean isDiagonalStep(){
        return !isStartPosEqualsEndPos() && Math.abs(end.getCol()-start.getCol())==Math.abs(end.getRow()-start.getRow());
    }
    public boolean isStartPosEqualsEndPos(){
        return start.getCol()==end.getCol() && start.getRow()==end.getRow();
    }
}
