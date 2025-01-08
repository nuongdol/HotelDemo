package com.example.hotelDemo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RestController;
import com.example.hotelDemo.model.ChatMessage;

@RestController
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        //add username in websocket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

    @MessageMapping("/chat")
    @SendTo("topic/messages")
    public ChatMessage receiveMessage(ChatMessage message) throws Exception{
        //simulate some processing
        Thread.sleep(1000);
        return new ChatMessage("Hello " + message.getContent() + "!" );
    }
}
