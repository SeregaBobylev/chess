package com.example.chess.model;

import com.example.chess.model.dbModel.Player;
import com.example.chess.model.figures.boaed.Board;

public class Game {
    private Player whitePlayer;
    private Player blackPlayer;
    private Board board;
    private Player nextTurn;
    private GameStatus status;

    public Game(Player whitePlayer, Player blackPlayer, Board board, Player nextTurn, GameStatus status) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.board = board;
        this.nextTurn = nextTurn;
        this.status = status;
    }

    public Game() {
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public void setWhitePlayer(Player whitePlayer) {
        this.whitePlayer = whitePlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public void setBlackPlayer(Player blackPlayer) {
        this.blackPlayer = blackPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getNextTurn() {
        return nextTurn;
    }

    public void setNextTurn(Player nextTurn) {
        this.nextTurn = nextTurn;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }
}