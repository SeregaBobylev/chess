package com.example.chess;

import com.example.chess.model.boaed.Board;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.socket.config.annotation.*;

import javax.swing.border.Border;
import java.lang.annotation.Annotation;

@SpringBootApplication
public class ChessApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChessApplication.class, args);
    }
//    Board board = new Board();
}