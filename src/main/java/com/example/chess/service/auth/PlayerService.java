package com.example.chess.service.auth;

import com.example.chess.controller.http.PlayerIdentificationDTO;
import com.example.chess.dto.PlayerRequestAuthDTO;
import com.example.chess.dao.PlayerRepository;
import com.example.chess.dto.PlayerRequestRegisterDTO;
import com.example.chess.dto.PlayerResponseDTO;
import com.example.chess.mapper.PlayerMapper;
import com.example.chess.exception.NotFoundException;
import com.example.chess.mapper.PlayerRegisterMapper;
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
    @Autowired
    private PlayerRegisterMapper playerRegisterMapper;


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

    public PlayerResponseDTO register(PlayerRequestRegisterDTO playerRequestRegisterDTO) {
        return playerRegisterMapper.toResponseDTO(playerRepository.save(playerRegisterMapper.fromRequestDTO(playerRequestRegisterDTO)));
    }

    public PlayerResponseDTO auth(PlayerRequestAuthDTO playerRequestAuthDTO) {
        Player player =  playerRepository.findByNickname(playerRequestAuthDTO.getLogin()).get(0);
        return new PlayerResponseDTO(player.getToken(), true,player.getUuid());
    }

    public boolean identification(PlayerIdentificationDTO playerIdentificationDTO) {
        Player player =  playerRepository.findByNickname(playerIdentificationDTO.getNickname()).get(0);
        return player.getToken().equals(playerIdentificationDTO.getToken());
    }
}
