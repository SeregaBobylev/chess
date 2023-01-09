package com.example.chess.controller.http;

import com.example.chess.dto.PlayerDTO;
import com.example.chess.dto.mapper.PlayerMapper;
import com.example.chess.model.dbModel.Player;
import com.example.chess.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerMapper playerMapper;
    @PostMapping("/register")
    public PlayerDTO create(@RequestBody PlayerDTO player) {
        return playerMapper.toDTO(playerService.create(player));
    }
}
