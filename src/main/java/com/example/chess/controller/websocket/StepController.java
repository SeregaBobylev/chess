package com.example.chess.controller.websocket;

import ch.qos.logback.classic.pattern.MessageConverter;
import com.example.chess.dto.StepDTO;
import com.example.chess.model.Step;
import com.example.chess.service.GameService;
import com.example.chess.service.PlayerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.DefaultContentTypeResolver;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.List;
import java.util.UUID;

@Controller
public class StepController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    @MessageMapping("/chat/{uuidGame}")
    public void processMessage(@Payload Step step, @RequestParam UUID uuidGame,@RequestHeader("uuid") String uuidUser ) {
        System.out.println(uuidUser);
        //Тут проверка шага и тд
        messagingTemplate.convertAndSendToUser(uuidGame.toString(),"/queue/messages", step);
    }
}

