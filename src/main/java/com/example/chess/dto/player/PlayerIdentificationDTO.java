package com.example.chess.dto.player;

public class PlayerIdentificationDTO {
    private String nickname;
    private String token;

    public PlayerIdentificationDTO() {
    }

    public PlayerIdentificationDTO(String nickname, String token) {
        this.nickname = nickname;
        this.token = token;
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
}
