package com.example.chess.mapper;

import com.example.chess.dto.player.PlayerRequestRegisterDTO;
import com.example.chess.dto.player.PlayerResponseDTO;
import com.example.chess.model.dbModel.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerRegisterMapper {
    public Player fromRequestDTO(PlayerRequestRegisterDTO playerRequestRegisterDTO){
        Player player =  new Player();
        player.setEmail(playerRequestRegisterDTO.getEmail());
        player.setNickname(playerRequestRegisterDTO.getLogin());
        player.setPassword(playerRequestRegisterDTO.getPassword());
        player.setToken((playerRequestRegisterDTO.getPassword()+playerRequestRegisterDTO.getEmail()));
        return player;
    }
    public PlayerResponseDTO toResponseDTO(Player player){
        return new PlayerResponseDTO(player.getToken(), true,player.getUuid(), player.getNickname());
    }
}
