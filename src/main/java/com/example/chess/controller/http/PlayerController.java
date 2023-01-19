package com.example.chess.controller.http;

import com.example.chess.dto.player.PlayerIdentificationDTO;
import com.example.chess.dto.player.PlayerRequestAuthDTO;
import com.example.chess.dto.player.PlayerRequestRegisterDTO;
import com.example.chess.dto.player.PlayerResponseDTO;
import com.example.chess.mapper.PlayerMapper;
import com.example.chess.service.auth.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerMapper playerMapper;
    @PostMapping("/register")
    public PlayerResponseDTO register(@RequestBody PlayerRequestRegisterDTO playerRequestRegisterDTO) {
        PlayerResponseDTO playerResponseDTO = playerService.register(playerRequestRegisterDTO);
        return playerResponseDTO;
    }
    @PostMapping("/auth")
    public PlayerResponseDTO auth(@RequestBody PlayerRequestAuthDTO playerRequestAuthDTO ){
//        PlayerResponseDTO playerResponseDTO = new PlayerResponseDTO("123456",true,);
        return playerService.auth(playerRequestAuthDTO);
    }
    @PostMapping("/identification")
    public boolean identification(@RequestBody PlayerIdentificationDTO playerIdentificationDTO){
        System.out.println(11111);
        return  playerService.identification(playerIdentificationDTO);
    }
}
