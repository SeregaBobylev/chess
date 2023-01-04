package com.example.chess.model.boaed;

import com.example.chess.model.Color;
import com.example.chess.model.figures.Figure;
import com.example.chess.model.figures.Pawn;

public class Cage {
    private Color color;
    private Figure figure;

    public Cage(Color color, Figure figure) {
        this.color = color;
        this.figure = figure;
    }

    public Color getColor() {
        return color;
    }
}
