package com.example.chess.model.figures;

import com.example.chess.model.Color;

public abstract class Figure {
    private Color color;

    public Figure(Color color) {
        this.color = color;
    }
}
