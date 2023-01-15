package com.example.chess.model.figures;

import com.example.chess.model.Color;
import com.example.chess.model.Step;
import com.example.chess.model.board.Board;
import com.example.chess.model.board.Cage;

public class Knight extends Figure{
    public Knight(Color color) {
        super(color);
    }

    @Override
    protected boolean checkStepSpecific(Step step, Board board) {
        return Math.abs(step.getEnd().getCol()-step.getStart().getCol())*Math.abs(step.getEnd().getRow()-step.getStart().getRow())==2;
    }
}
