package com.example.chess.mapper;

import com.example.chess.model.dbModel.Player;
import com.example.chess.dto.player.PlayerDTO;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {
    public Player fromDTO(PlayerDTO playerDTO) {
        if (playerDTO == null) return null;
        return new Player(playerDTO.getUuid(), playerDTO.getNickname());
    }

    public PlayerDTO toDTO(Player player) {
        if (player == null) return null;
        return new PlayerDTO(player.getUuid(), player.getNickname());
    }
}
