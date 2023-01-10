package com.example.chess.service;

import com.example.chess.dao.GameRepository;
import com.example.chess.exception.NotFoundException;
import com.example.chess.model.Step;
import com.example.chess.model.dbModel.Game;
import com.example.chess.model.GameStatus;
import com.example.chess.model.dbModel.Player;
import com.example.chess.model.boaed.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
//    @Autowired
//    private
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
        gameRepository.save(game);
    return game;
    }
    public Game get(UUID uuid){
        Optional<Game> game = gameRepository.findById(uuid);
        if (game.isEmpty()) {
            throw new NotFoundException("Player with uuid " + uuid + " not found!");
        }
        return  game.get();
    }
    public Game connected(UUID uuidGame,Player player){
//        Game game = games.get(uuid);
        Game game = get(uuidGame);
        if(game.getStatus()!=GameStatus.WAIT_PLAYER){
//            exception
        }
        game.setBlackPlayer(player);
        game.setStatus(GameStatus.ACTION);
        return game;
    }
    public Step step(UUID uuidGame,Step step){

        return  step;
    }
}
