package com.example.chess.dto.mapper;

import com.example.chess.model.Game;
import com.example.chess.dto.GameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {
    @Autowired
    PlayerMapper playerMapper;

    public Game fromDTO(GameDTO gameDTO) {
        if (gameDTO == null) return null;
        return new Game(
                playerMapper.fromDTO(gameDTO.getWhitePlayer()),
                playerMapper.fromDTO(gameDTO.getBlackPlayer()),
                gameDTO.getBoard(),
                playerMapper.fromDTO(gameDTO.getNextTurn()),
                gameDTO.getStatus()
        );
    }

    public GameDTO toDTO(Game game) {
        if (game == null) return null;
        return new GameDTO(
                playerMapper.toDTO(game.getWhitePlayer()),
                playerMapper.toDTO(game.getBlackPlayer()),
                game.getBoard(),
                playerMapper.toDTO(game.getNextTurn()),
                game.getStatus()
        );
    }
}
