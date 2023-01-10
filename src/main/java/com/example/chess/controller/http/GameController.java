package com.example.chess.controller.http;

import com.example.chess.dto.GameDTO;
import com.example.chess.dto.StepDTO;
import com.example.chess.dto.mapper.GameMapper;
import com.example.chess.dto.mapper.PlayerMapper;
import com.example.chess.dto.mapper.StepMapper;
import com.example.chess.model.dbModel.Player;
import com.example.chess.service.GameService;
import com.example.chess.service.PlayerService;
import org.hibernate.dialect.SybaseDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    GameService gameService;

    @Autowired
    GameMapper gameMapper;
    @Autowired
    PlayerMapper playerMapper;
    @Autowired
    PlayerService playerService;

    @Autowired
    StepMapper stepMapper;

    @PostMapping("/create")
    public GameDTO createGame(@RequestBody Player player){
        return gameMapper.toDTO(gameService.create(player));
    }
    @PostMapping("/connected/{uuid}")
    public GameDTO connectedGame(@PathVariable UUID uuid,@RequestBody Player player){
        System.out.println(player);
        return gameMapper.toDTO(gameService.connected(uuid,player));
    }
    @PostMapping("/{uuidPlayer}/step")
    public Boolean step(@PathVariable UUID uuidGame,@PathVariable UUID uuidPlayer,@RequestBody StepDTO stepDTO){
        Player player = playerService.get(uuidPlayer);
        return (gameService.step(uuidGame,stepMapper.fromDTO(stepDTO,player)));

    }

}
