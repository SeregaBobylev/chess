package com.example.chess.dto.mapper;

import com.example.chess.dao.GameRepository;
import com.example.chess.dto.StepDTO;
import com.example.chess.model.Step;
import com.example.chess.model.boaed.Board;
import com.example.chess.model.boaed.Cage;
import com.example.chess.model.dbModel.Game;
import com.example.chess.model.dbModel.Player;
import com.example.chess.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class StepMapper {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameService gameService;

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

    public StepDTO toDTO(Step step) {

        return null;
    }

    public Step fromDTO(StepDTO stepDTO, Player player) {
        Game game = gameService.getMap(stepDTO.getUuid());
        int[] locationStartCage =  convertedCharInInteger(stepDTO.getStart());
        int[] locationEndCage =  convertedCharInInteger(stepDTO.getEnd());
        Cage startCage =  game.getBoard().getCages()[locationStartCage[0]][locationStartCage[1]];
        Cage endCage =  game.getBoard().getCages()[locationEndCage[0]][locationEndCage[1]];
        return new Step(player,startCage,endCage);
    }

    private int[] convertedCharInInteger(String locationCage) {
        int[] result = new int[2];
        result[0]=Integer.parseInt(String.valueOf(locationCage.charAt(0)))-1;
        result[1]=chatInInt.get(locationCage.charAt(1));
        return result;
    }
}
