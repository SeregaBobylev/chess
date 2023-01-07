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
        int colStart = step.getStart().getCol();
        int rowStart = step.getStart().getRow();

        int colEnd = step.getEnd().getCol();
        int rowEnd = step.getEnd().getRow();

        Cage cagesBoard[][] = board.getCages();
        Figure figure = step.getStart().getFigure();
        if (colStart == colEnd) {
//            in right
            if (rowStart < rowEnd) {

                for (int row = rowStart + 1; row < rowEnd; row++) {
                    if (cagesBoard[colStart][row].getFigure() != null) return false;
                }
            } else {
                for (int row = rowEnd - 1; row > rowEnd; row--) {
                    if (cagesBoard[colStart][row].getFigure() != null) return false;
                }
            }
            return cagesBoard[colEnd][rowEnd].getFigure().getColor() != figure.getColor();
        }
        if (rowStart == rowEnd) {
            if (colStart < colEnd) {

                for (int col = rowStart + 1; col < rowEnd; col++) {
                    if (cagesBoard[col][rowEnd].getFigure() != null) return false;
                }
            } else {
                for (int col = rowEnd - 1; col > rowEnd; col--) {
                    if (cagesBoard[col][rowEnd].getFigure() != null) return false;
                }
            }
            return cagesBoard[colEnd][rowEnd].getFigure().getColor() != figure.getColor();
        }
        return false;
    }

}
