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
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String token;

    public Player(){
    }

    public Player(UUID uuid, String nickname) {
        this.uuid = uuid;
        this.nickname = nickname;
    }

    public Player(UUID uuid, String nickname, String email, String password, String token) {
        this.uuid = uuid;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.token = token;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
