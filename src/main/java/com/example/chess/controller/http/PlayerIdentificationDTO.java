package com.example.chess.controller.http;

public class PlayerIdentificationDTO {
    private String nickname;
    private String token;

    public PlayerIdentificationDTO() {
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
