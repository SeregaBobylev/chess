package com.example.chess.dto;

public class PlayerRequestRegisterDTO {
    private String login;
    private String email;
    private String password;

    public PlayerRequestRegisterDTO(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public PlayerRequestRegisterDTO() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
