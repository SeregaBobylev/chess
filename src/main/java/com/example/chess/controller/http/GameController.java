package com.example.chess.controller.http;

import com.example.chess.dao.PlayerRepository;
import com.example.chess.dto.GameDTO;
import com.example.chess.dto.StepDTO;
import com.example.chess.dto.player.PlayerIdentificationDTO;
import com.example.chess.mapper.GameMapper;
import com.example.chess.mapper.PlayerMapper;
import com.example.chess.model.dbModel.Player;
import com.example.chess.service.GameService;
import com.example.chess.service.auth.PlayerService;
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


    @GetMapping("/create")
    public GameDTO createGame(@CookieValue String token,@CookieValue String nickname){
        return gameMapper.toDTO(gameService.create(new PlayerIdentificationDTO(nickname,token)));
    }
    @PostMapping("/connected/{uuid}")
    public GameDTO connectedGame(@PathVariable UUID uuid,@RequestBody Player player){
        System.out.println(player);
        return gameMapper.toDTO(gameService.connected(uuid,player));
    }
    @PostMapping("/{uuidPlayer}/{uuidGame}/step")
    public Boolean step(@PathVariable UUID uuidGame,@PathVariable UUID uuidPlayer,@RequestBody StepDTO stepDTO){
        Player player = playerService.get(uuidPlayer);
        System.out.println(player);
        return (gameService.step(uuidGame,stepDTO,player));

    }

}
