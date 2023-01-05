package com.example.chess.model.figures;

import com.example.chess.model.Color;
import com.example.chess.model.Step;
import com.example.chess.model.figures.boaed.Board;
import com.example.chess.model.figures.boaed.Cage;

public class Pawn extends Figure {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean checkStep(Step step, Board board) {
        int step;
//        start row
        int colStart = step.getStart().getCol();
        int rowStart = step.getStart().getRow();

        int colEnd = step.getEnd().getCol();
        int rowEnd = step.getEnd().getRow();


        return false;
    }

}
