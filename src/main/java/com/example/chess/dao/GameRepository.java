package com.example.chess.dao;

import com.example.chess.model.dbModel.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface GameRepository extends CrudRepository<Game,UUID> {
}
