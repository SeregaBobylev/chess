package com.example.chess.model.figures;

import com.example.chess.model.Color;
import com.example.chess.model.Step;
import com.example.chess.model.board.Board;

public class Rook extends Figure {
    public Rook(Color color) {
        super(color);
    }

    @Override
    protected boolean checkStepSpecific(Step step, Board board) {
        return (step.isVerticalStep() || step.isHorizontalStep()) && board.isStepDirectAndPathFree(step);
    }
}
