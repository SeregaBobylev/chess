package com.example.chess.model.boaed;

import com.example.chess.model.Color;
import com.example.chess.model.figures.*;

import java.util.HashMap;

public class Board {
    private int id;//(не точно)
    private Cage[][] cages;
    private HashMap<Integer, Figure> PositionFigureWhite = new HashMap<>() {{
        put(0, new Rook(Color.WHITE));
        put(1, new Knight(Color.WHITE));
        put(2, new Bishop(Color.WHITE));
        put(3, new King(Color.WHITE));
        put(4, new Queen(Color.WHITE));
        put(5, new Bishop(Color.WHITE));
        put(6, new Knight(Color.WHITE));
        put(7, new Rook(Color.WHITE));
    }};
    private HashMap<Integer, Figure> PositionFigureBlack = new HashMap<>() {{
        put(0, new Rook(Color.BLACK));
        put(1, new Knight(Color.BLACK));
        put(2, new Bishop(Color.BLACK));
        put(4, new King(Color.BLACK));
        put(3, new Queen(Color.BLACK));
        put(5, new Bishop(Color.BLACK));
        put(6, new Knight(Color.BLACK));
        put(7, new Rook(Color.BLACK));
    }};

    public Board() {
        boolean blackColorCage = true;
        boolean tempColor;
        for (int i = 0; i < 8; i++) {
            tempColor = blackColorCage ? false : true;
            for (int j = 0; j < 8; j++) {
                setCageFigure(i,j,tempColor);
                tempColor = tempColor ? false : true;
            }
            blackColorCage = blackColorCage ? false : true;
        }
    }


    private void setCageFigure(int i, int j, boolean tempColor) {
        if (j > 2 && j < 6) {
            cages[i][j] = new Cage(tempColor ? Color.WHITE : Color.BLACK, null);
        } else if (j == 1 || j == 6) {
            cages[i][j] = new Cage(tempColor ? Color.WHITE : Color.BLACK, new Pawn(j == 1 ? Color.BLACK : Color.WHITE));
        } else if (j == 0 || j == 7) {
            cages[i][j] = new Cage(tempColor ? Color.WHITE : Color.BLACK, j == 0 ? PositionFigureBlack.get(i) : PositionFigureWhite.get(i));
        }
    }
}
