package com.example.chess.dao;

import com.example.chess.model.dbModel.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PlayerRepository extends CrudRepository<Player, UUID> {
    List<Player> findByNickname(String nickname);
    List<Player> findByToken(String nickname);


}
