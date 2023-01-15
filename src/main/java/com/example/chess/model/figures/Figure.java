package com.example.chess.model.figures;

import com.example.chess.model.Color;
import com.example.chess.model.Step;
import com.example.chess.model.board.Board;

public abstract class Figure {
    private final Color color;
    private boolean hasBeenStep=false;

    public Figure(Color color) {
        this.color = color;
    }

    public boolean isHasBeenStep() {
        return hasBeenStep;
    }

    public void setHasBeenStep(boolean hasBeenStep) {
        this.hasBeenStep = hasBeenStep;
    }

    public Color getColor() {
        return color;
    }
    public boolean checkStep(Step step, Board board){
        return step.checkBoundaries() &&
                isStartSquareContainsThisFigure(step) &&
                isDestinationEmptyOrContainsEnemyFigure(step) &&
                checkStepSpecific(step,board);
    }
    protected abstract boolean checkStepSpecific(Step step, Board board);
    protected boolean isStartSquareContainsThisFigure(Step step){
        return step.getStart().getFigure()==this;
    }
    protected boolean isDestinationEmptyOrContainsEnemyFigure(Step step){
        return step.getEnd().getFigure()==null || step.getEnd().getFigure().getColor()==this.getColor();
    }
}
