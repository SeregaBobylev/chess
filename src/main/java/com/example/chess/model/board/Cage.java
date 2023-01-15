package com.example.chess.model.board;

import com.example.chess.model.Color;
import com.example.chess.model.figures.Figure;

public class Cage {
    private final Color color;
    private final int col;
    private final int row;
    private Figure figure;

    public Cage(Color color, int col, int row) {
        this.color = color;
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Color getColor() {
        return color;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public boolean checkBoundaries() {
        return true;
    }
}
