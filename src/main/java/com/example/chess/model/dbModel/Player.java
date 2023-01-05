package com.example.chess.model.dbModel;

import jakarta.persistence.*;
import java.util.UUID;
@Entity
@Table
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @Column(name = "nickname")
    private String nickname;

    public UUID getUuid() {
        return uuid;
    }
    public Player(){
    }

    public Player(UUID uuid, String nickname) {
        this.uuid = uuid;
        this.nickname = nickname;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
