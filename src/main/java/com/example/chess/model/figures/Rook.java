package com.example.chess.model.figures;

import com.example.chess.model.Color;
import com.example.chess.model.Step;
import com.example.chess.model.figures.boaed.Board;
import com.example.chess.model.figures.boaed.Cage;

public class Rook extends Figure {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean checkStep(Step step, Board board) {
//        return (move.isVerticalMove() || )
        return false;
//        return false;
    }

}
