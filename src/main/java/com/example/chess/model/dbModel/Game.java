package com.example.chess.model.dbModel;

import com.example.chess.model.GameStatus;
import com.example.chess.model.board.Board;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @MapsId
    @ManyToOne
    @JoinColumn
    private Player whitePlayer;

    @MapsId
    @ManyToOne
    @JoinColumn
    private Player blackPlayer;
    @MapsId
    @ManyToOne
    @JoinColumn
    private Player nextTurn;
    @Column
    private GameStatus status;
//    @Column
//    @Convert(converter = ConvertJson.class)
    @Transient
    private Board board;



    public Game(Player whitePlayer, Player blackPlayer, Board board, Player nextTurn, GameStatus status) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.board = board;
        this.nextTurn = nextTurn;
        this.status = status;
    }

    public Game() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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
