package com.example.chess.controller.http;

import com.example.chess.dto.GameDTO;
import com.example.chess.dto.mapper.GameMapper;
import com.example.chess.model.dbModel.Player;
import com.example.chess.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    GameService gameService;
    @Autowired
    GameMapper gameMapper;
    @PostMapping("/create")
    public GameDTO createGame(@RequestBody Player player){
        return gameMapper.toDTO(gameService.create());
    }
    @PostMapping("/connected/{uuid}")
    public GameDTO connectedGame(@RequestBody Player player){
//        search game and return games
        return gameMapper.toDTO(gameService.create());
    }
}
