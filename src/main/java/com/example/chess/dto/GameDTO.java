package com.example.chess.dto;

import com.example.chess.dto.player.PlayerDTO;
import com.example.chess.model.GameStatus;
import com.example.chess.model.board.Board;

import java.util.UUID;

public class GameDTO {
    private UUID uuid;
    private PlayerDTO whitePlayer;
    private PlayerDTO blackPlayer;
    private Board board;
    private PlayerDTO nextTurn;
    private GameStatus status;

    public GameDTO() {
    }

    public GameDTO(PlayerDTO whitePlayer, PlayerDTO blackPlayer, Board board, PlayerDTO nextTurn, GameStatus status, UUID uuid) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.board = board;
        this.nextTurn = nextTurn;
        this.status = status;
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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
