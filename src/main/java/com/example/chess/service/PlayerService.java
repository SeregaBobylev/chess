package com.example.chess.service;

import com.example.chess.dao.PlayerRepository;
import com.example.chess.dto.PlayerDTO;
import com.example.chess.dto.mapper.PlayerMapper;
import com.example.chess.exception.NotFoundException;
import com.example.chess.model.dbModel.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {
    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private PlayerRepository playerRepository;


    public Player get(UUID uuid) {
        Optional<Player> player = playerRepository.findById(uuid);
        if (player.isEmpty()) {
            throw new NotFoundException("Player with uuid " + uuid + " not found!");
        }
        return player.get();
    }

    public List<Player> getAll() {
        return (List<Player>) playerRepository.findAll();
    }


    public Player delete(UUID uuid) {
        Player player = get(uuid);
        playerRepository.delete(player);
        return player;
    }


    public Player create(PlayerDTO playerDTO) {

        Player player = playerMapper.fromDTO(playerDTO);
        return playerRepository.save(player);
}
}
