package com.example.chess.dto.player;

import java.util.UUID;

public class PlayerResponseDTO {
    private String token;
    private boolean status;
    private UUID uuid;
    private String nickname;

    public PlayerResponseDTO(String token, boolean status, UUID uuid, String nickname) {
        this.token = token;
        this.status = status;
        this.uuid = uuid;
        this.nickname = nickname;
    }

    public PlayerResponseDTO() {

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
