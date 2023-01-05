package com.example.chess.model.figures;

import com.example.chess.model.Color;
import com.example.chess.model.Step;
import com.example.chess.model.figures.boaed.Board;

public abstract class Figure {
    private Color color;
    private boolean firstMove=false;
    public Figure(Color color) {
        this.color = color;
    }
    public abstract boolean checkStep(Step step, Board board);
    private boolean checkPosition(){
        return false;
    }
}
