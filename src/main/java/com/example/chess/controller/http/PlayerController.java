package com.example.chess.controller.http;

import com.example.chess.dto.PlayerRequestAuthDTO;
import com.example.chess.dto.PlayerRequestRegisterDTO;
import com.example.chess.dto.PlayerResponseDTO;
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
//        Cookie cookie = new Cookie("key", playerResponseDTO.getToken());
//        cookie.setMaxAge(60*60*24*30);
//        response.addCookie(cookie);
        return playerResponseDTO;
    }
    @PostMapping("/auth")
    public PlayerResponseDTO auth(@RequestBody PlayerRequestAuthDTO playerRequestAuthDTO ){
        return playerService.auth(playerRequestAuthDTO);
    }
    @PostMapping("/identification")
    public boolean identification(@RequestBody PlayerIdentificationDTO playerIdentificationDTO){
        return  playerService.identification(playerIdentificationDTO);
    }
}
