package com.example.chess.service;

import com.example.chess.model.Game;
import com.example.chess.model.GameStatus;
import com.example.chess.model.figures.boaed.Board;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    public Game create(){
        Game game = new Game();
        game.setBoard(new Board());
        game.setStatus(GameStatus.WAIT_PLAYER);
        return game;
    }
}
