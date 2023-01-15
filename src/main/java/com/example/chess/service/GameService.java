package com.example.chess.service;

import com.example.chess.dao.GameRepository;
import com.example.chess.dto.StepDTO;
import com.example.chess.exception.NotFoundException;
import com.example.chess.model.Step;
import com.example.chess.model.dbModel.Game;
import com.example.chess.model.GameStatus;
import com.example.chess.model.dbModel.Player;
import com.example.chess.model.board.Board;

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
    private HashMap<UUID, Game> games = new HashMap<>();

    public Game create(Player player) {
        Game game = new Game();
        game.setWhitePlayer(player);
        game.setBoard(new Board());
        game.setStatus(GameStatus.WAIT_PLAYER);
        System.out.println(game);
//        UUID uuid = UUID.randomUUID();
        UUID uuid = UUID.fromString("7f74e944-3976-45f6-a677-58b792cdf670");
        System.out.println(uuid);
        game.setUuid(uuid);
        games.put(uuid, game);
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
        return checkValidStep(game, stepDTO,player);
//        check mate
//        checkShah

    }
    private boolean checkValidStep(Game game,StepDTO stepDTO,Player player){
        Step step = mapperFromStep(game,stepDTO,player);
        return step.getStart().getFigure().checkStep(step, game.getBoard());
    }
    private Step mapperFromStep(Game game,StepDTO stepDTO,Player player){
        PairLocation locationStartCage = convertedCharInInteger(stepDTO.getStart());
        PairLocation locationEndCage = convertedCharInInteger(stepDTO.getEnd());
        return new Step(player,
                game.getBoard().getCages()[locationStartCage.col][locationStartCage.row],
                game.getBoard().getCages()[locationEndCage.col][locationEndCage.row]
        );
    }

    private PairLocation convertedCharInInteger(String locationCage) {
        return new PairLocation(chatInInt.get(locationCage.charAt(1)),Integer.parseInt(String.valueOf(locationCage.charAt(0))) - 1);
    }
    record PairLocation(int col, int row) {
    }
}
