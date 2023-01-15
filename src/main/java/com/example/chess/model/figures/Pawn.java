package com.example.chess.model.figures;

import com.example.chess.model.Color;
import com.example.chess.model.Step;
import com.example.chess.model.board.Board;
import com.example.chess.model.board.Cage;

public class Pawn extends Figure {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    protected boolean checkStepSpecific(Step step, Board board) {
        if(!step.isVerticalStep()) return false;
        if(isHasBeenStep()) return  (Math.abs(step.getEnd().getRow()-step.getStart().getRow())==1 && Math.abs(step.getEnd().getCol()-step.getStart().getCol())<2);
        return (Math.abs(step.getEnd().getRow()-step.getStart().getRow())<3 && Math.abs(step.getEnd().getCol()-step.getStart().getCol())<2);
    }
}
