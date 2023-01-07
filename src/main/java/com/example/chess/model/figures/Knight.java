package com.example.chess.model.figures;

import com.example.chess.model.Color;
import com.example.chess.model.Step;
import com.example.chess.model.figures.boaed.Board;
import com.example.chess.model.figures.boaed.Cage;

public class Knight extends Figure{
    public Knight(Color color) {
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
        if((Math.abs(colEnd-colStart)==1 && Math.abs(rowEnd-colStart)==2)
                || (Math.abs(colEnd-colStart)==2 && Math.abs(rowEnd-rowStart)==1)){
            return cagesBoard[colEnd][rowEnd].getFigure().getColor()==figure.getColor()?false:true;
        }
        return false;
    }
}
