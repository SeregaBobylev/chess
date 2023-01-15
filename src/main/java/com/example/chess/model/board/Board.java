package com.example.chess.model.board;

import com.example.chess.model.Color;
import com.example.chess.model.Step;
import com.example.chess.model.figures.*;


public class Board {
    private Cage[][] cages;
    public Board() {
        placeFigures();
    }

    public Cage[][] getCages() {
        return cages;
    }

    public void placeFigures() {
        reset();
        placeHighFigures(Color.WHITE,0);
        placePawns(Color.WHITE, 1);
        placeHighFigures(Color.BLACK,7);
        placePawns(Color.BLACK, 6);
    }

    private void placePawns(Color color, int row) {
        for (int i = 0; i <= 7; i++) {
            cages[i][row].setFigure(new Pawn(color));
        }
    }

    private void placeHighFigures(Color color, int row) {
        cages[0][row].setFigure(new Rook(color));
        cages[7][row].setFigure(new Rook(color));

        cages[1][row].setFigure(new Knight(color));
        cages[6][row].setFigure(new Knight(color));

        cages[2][row].setFigure(new Bishop(color));
        cages[5][row].setFigure(new Bishop(color));

        cages[3][row].setFigure(new Queen(color));
        cages[4][row].setFigure(new King(color));
    }

    public void reset() {
        this.cages = new Cage[8][8];
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                Color color = (col + row) % 2 == 0 ? Color.BLACK : Color.WHITE;
                cages[col][row] = new Cage(color,col,row);
            }
        }
    }
    public boolean isStepDirectAndPathFree(Step step){
        if(step.isDirectStep()) return false;
        int pathLength = Math.max(
          Math.abs(step.getStart().getCol()-step.getEnd().getCol()),
          Math.abs(step.getStart().getRow()-step.getEnd().getRow()));
        int colDirection = step.getEnd().getCol()>step.getStart().getCol()?1:-1;
        int rowDirection = step.getEnd().getRow()>step.getStart().getRow()?1:-1;
        for(int i=1;i<pathLength;i++){
            if(cages[step.getStart().getCol()+i*colDirection][step.getStart().getRow()+i*rowDirection].getFigure()!=null) return false;
        }
        return true;
    }
}
