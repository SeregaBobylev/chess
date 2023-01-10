package com.example.chess.dto.mapper;

import com.example.chess.dao.GameRepository;
import com.example.chess.dto.StepDTO;
import com.example.chess.model.Step;
import com.example.chess.model.boaed.Board;
import com.example.chess.model.dbModel.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class StepMapper {
    @Autowired
    private GameRepository gameRepository;
    private HashMap<Character, Integer> chatInInt = new HashMap<>() {{
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
//        gameRepository.findById();

        Board board =
        return null;
    }

    private int convertedCharInInteger(char symbol) {
        return chatInInt.get(symbol);
    }
}
