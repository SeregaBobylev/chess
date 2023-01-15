package com.example.chess.model.figures;

import com.example.chess.model.Color;
import com.example.chess.model.Step;
import com.example.chess.model.board.Board;

public class Queen extends Figure{
    public Queen(Color color) {
        super(color);
    }

    @Override
    protected boolean checkStepSpecific(Step step, Board board) {
        return board.isStepDirectAndPathFree(step);
    }

}
