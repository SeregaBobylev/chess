package com.example.chess.model;

public enum Color {
    WHITE,BLACK;
    public Color inverse(){
        return this == Color.BLACK?Color.WHITE:Color.BLACK;
    }
}
