package com.example.chess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.socket.config.annotation.*;

import java.lang.annotation.Annotation;

@SpringBootApplication
public class ChessApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChessApplication.class, args);
    }

}
record GreetingRequrest(String name){}
record GreetingResponse(String message){}

@Controller
class GreetingsWebSocketController{
    @MessageMapping("/chat")
    @SendTo("/topic/greeting")
    GreetingResponse greet(GreetingRequrest requrest){
//        Assert.isTrue(Character.);
        return new GreetingResponse("Hello, "+requrest.name()+"!");
    }
}
@Configuration
@EnableWebSocketMessageBroker
class GreetingWebSocketConfiguration implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/chat").withSockJS();
    }
}