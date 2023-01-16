package com.example.chess.dto;

import java.util.UUID;

public class PlayerResponseDTO {
    private String token;
    private boolean status;
    private UUID uuid;

    public PlayerResponseDTO(String token, boolean status, UUID uuid) {
        this.token = token;
        this.status = status;
        this.uuid = uuid;
    }

    public PlayerResponseDTO() {

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
