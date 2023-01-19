package com.example.chess.dto.player;

public class PlayerRequestAuthDTO {
    private String login;
    private String password;

    public PlayerRequestAuthDTO() {
    }

    public PlayerRequestAuthDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
