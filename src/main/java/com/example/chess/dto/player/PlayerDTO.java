package com.example.chess.dto.player;
import java.util.UUID;

public class PlayerDTO {
    private UUID uuid;
    private String nickname;

    public PlayerDTO() {
    }

    public PlayerDTO(UUID uuid, String nickname) {
        this.uuid = uuid;
        this.nickname = nickname;
    }

    public UUID getUuid() {
        return uuid;
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
