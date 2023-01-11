package com.example.chess.service;

import com.example.chess.dao.GameRepository;
import com.example.chess.dto.StepDTO;
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
    private final HashMap<Character, Integer> chatInInt = new HashMap<>() {{
        put('a', 0);
        put('b', 1);
        put('c', 2);
        put('d', 3);
        put('e', 4);
        put('f', 5);
        put('g', 6);
        put('h', 7);
    }};
    @Autowired
    private GameRepository gameRepository;
    //    @Autowired
//    private
    private HashMap<UUID, Game> games = new HashMap<>();

    public Game create(Player player) {
        Game game = new Game();
        game.setWhitePlayer(player);
        game.setBoard(new Board());
        game.setStatus(GameStatus.WAIT_PLAYER);
        System.out.println(game);
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        game.setUuid(uuid);
        games.put(uuid, game);
//        No work
//        gameRepository.save(game);
        return game;
    }

    public Game get(UUID uuid) {
        Optional<Game> game = gameRepository.findById(uuid);
        if (game.isEmpty()) {
            throw new NotFoundException("Player with uuid " + uuid + " not found!");
        }
        return game.get();
    }

    public Game getMap(UUID uuid) {
        return games.get(uuid);
    }

    //
    public Game connected(UUID uuidGame, Player player) {
//        Game game = games.get(uuid);
        Game game = getMap(uuidGame);
        if (game.getStatus() != GameStatus.WAIT_PLAYER) {
//            exception
        }
        game.setBlackPlayer(player);
        game.setStatus(GameStatus.ACTION);
        return game;
    }

    public Boolean step(UUID uuidGame, StepDTO stepDTO, Player player) {
        Game game = getMap(uuidGame);
        PairLocation locationStartCage = convertedCharInInteger(stepDTO.getStart());
        PairLocation locationEndCage = convertedCharInInteger(stepDTO.getEnd());
        Step step = new Step(player,
                game.getBoard().getCages()[locationStartCage.col][locationStartCage.row],
                game.getBoard().getCages()[locationEndCage.col][locationEndCage.row]
        );
        return step.getStart().getFigure().checkStep(step, games.get(uuidGame).getBoard());
    }

    private PairLocation convertedCharInInteger(String locationCage) {
        return new PairLocation(Integer.parseInt(String.valueOf(locationCage.charAt(0))) - 1, chatInInt.get(locationCage.charAt(1)));
    }

    class PairLocation {
        public final int col;
        public final int row;

        public PairLocation(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }
}
