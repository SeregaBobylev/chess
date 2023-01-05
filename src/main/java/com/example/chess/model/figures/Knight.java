package com.example.chess.model.figures;

import com.example.chess.model.Color;
import com.example.chess.model.Step;
import com.example.chess.model.figures.boaed.Board;

public class Knight extends Figure{
    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean checkStep(Step step, Board board) {
        return false;
    }
}
