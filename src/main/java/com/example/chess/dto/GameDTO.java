package com.example.chess.dto;

import com.example.chess.model.GameStatus;
import com.example.chess.model.figures.boaed.Board;

public class GameDTO {
    private PlayerDTO whitePlayer;
    private PlayerDTO blackPlayer;
    private Board board;
    private PlayerDTO nextTurn;
    private GameStatus status;

    public GameDTO() {
    }
    public GameDTO(PlayerDTO whitePlayer, PlayerDTO blackPlayer, Board board, PlayerDTO nextTurn, GameStatus status) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.board = board;
        this.nextTurn = nextTurn;
        this.status = status;
    }

    public PlayerDTO getWhitePlayer() {
        return whitePlayer;
    }

    public void setWhitePlayer(PlayerDTO whitePlayer) {
        this.whitePlayer = whitePlayer;
    }

    public PlayerDTO getBlackPlayer() {
        return blackPlayer;
    }

    public void setBlackPlayer(PlayerDTO blackPlayer) {
        this.blackPlayer = blackPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public PlayerDTO getNextTurn() {
        return nextTurn;
    }

    public void setNextTurn(PlayerDTO nextTurn) {
        this.nextTurn = nextTurn;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }
}
