package com.example.chess.model.figures;

import com.example.chess.model.Color;
import com.example.chess.model.Step;
import com.example.chess.model.board.Board;

public class Bishop extends Figure{
    public Bishop(Color color) {
        super(color);
    }

    @Override
    protected boolean checkStepSpecific(Step step, Board board) {
        return step.isDiagonalStep() && board.isStepDirectAndPathFree(step);
    }

}
