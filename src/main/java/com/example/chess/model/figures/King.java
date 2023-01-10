package com.example.chess.model.figures;

import com.example.chess.model.Color;
import com.example.chess.model.Step;
import com.example.chess.model.boaed.Board;
import com.example.chess.model.boaed.Cage;

public class King extends Figure{
    public King(Color color) {
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

        //        castle check

//        check current step
        if(Math.abs(colEnd-colStart)>2 || Math.abs(rowEnd-rowStart)>2 ) return false;
        if(cagesBoard[colEnd][rowEnd].getFigure().getColor() == figure.getColor()) return false;

        return true;
    }
}
