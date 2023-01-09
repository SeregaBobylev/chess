package com.example.chess.service;

import com.example.chess.model.Game;
import com.example.chess.model.GameStatus;
import com.example.chess.model.dbModel.Player;
import com.example.chess.model.figures.boaed.Board;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class GameService {
    private HashMap<UUID,Game> games = new HashMap<>();
    public Game create(Player player){
        Game game = new Game();
        game.setWhitePlayer(player);
        game.setBoard(new Board());
        game.setStatus(GameStatus.WAIT_PLAYER);
        System.out.println(game);
        UUID uuid = UUID.randomUUID();
        game.setUuid(uuid);
        games.put(uuid,game);
    return game;
    }
    public Game connected(UUID uuid,Player player){
        Game game = games.get(uuid);
        System.out.println(game);
        game.setBlackPlayer(player);
        game.setStatus(GameStatus.ACTION);
        return game;
    }
}
