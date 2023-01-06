package com.example.chess.model.figures;

import com.example.chess.model.Color;
import com.example.chess.model.Step;
import com.example.chess.model.figures.boaed.Board;
import com.example.chess.model.figures.boaed.Cage;

import static java.lang.Math.*;

public class Pawn extends Figure {
    public Pawn(Color color) {
        super(color);
    }

    private boolean firstMove = false;

    @Override
    public boolean checkStep(Step step, Board board) {
        int colStart = step.getStart().getCol();
        int rowStart = step.getStart().getRow();

        int colEnd = step.getEnd().getCol();
        int rowEnd = step.getEnd().getRow();

        Cage cagesBoard[][] = board.getCages();
        Figure figure = step.getStart().getFigure();
        if (figure == null) return false;
        if((Math.abs(colEnd - colStart) != 0 || Math.abs(colEnd - colStart) != 1)) return false;
        if (figure.getColor() == Color.WHITE) {
//            check current Step
            if (rowEnd - 1 == rowStart || !firstMove && rowEnd - 2 == rowStart) {
//            check figure on the way
//                step straight on 2 cages
                if (!firstMove && rowEnd - 2 == rowStart && cagesBoard[colStart][rowStart + 1].getFigure() != null)
                    return false;
                //step straight on 1 cages
                if (cagesBoard[colStart][rowStart + 1].getFigure() != null) return false;
                //step diagonal
                if(cagesBoard[colEnd][rowEnd].getFigure().getColor()==figure.getColor()) return false;
                return true;
            }
        }
        else{
            if (rowEnd + 1 == rowStart || !firstMove && rowEnd + 2 == rowStart) {
//            check figure on the way
//                step straight on 2 cages
                if (!firstMove && rowEnd + 2 == rowStart && cagesBoard[colStart][rowStart - 1].getFigure() != null)
                    return false;
                //step straight on 1 cages
                if (cagesBoard[colStart][rowStart - 1].getFigure() != null) return false;
                //step diagonal
                if(cagesBoard[colEnd][rowEnd].getFigure().getColor()==figure.getColor()) return false;
                return true;
            }
        }
        return false;
    }
}
