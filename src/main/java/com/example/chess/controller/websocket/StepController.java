package com.example.chess.controller.websocket;

import com.example.chess.model.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class StepController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @MessageMapping("/chat/{uuidGame}")
    public void processMessage(@Payload Step step, @RequestParam UUID uuidGame, @RequestHeader("uuid") String uuidUser ) {
        System.out.println(uuidUser);
        //Тут проверка шага и тд
        messagingTemplate.convertAndSendToUser(uuidGame.toString(),"/queue/messages", step);
    }
}

