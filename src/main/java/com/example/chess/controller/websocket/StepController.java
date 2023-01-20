package com.example.chess.controller.websocket;

import com.example.chess.dto.StepDTO;
import com.example.chess.model.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;

import java.util.UUID;

@Controller
public class StepController {
    @Autowired
    SimpMessagingTemplate messagingTemplate;
    @MessageMapping("/step")
    public void processMessage(@Payload StepDTO stepDTO, @CookieValue("token") String token) {
//         String token
        messagingTemplate.convertAndSendToUser(stepDTO.getUuid().toString(),"/message",stepDTO);
    }
}

