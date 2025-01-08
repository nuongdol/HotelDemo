package com.example.hotelDemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
/*
 * bat tinh nang websocket server
 */
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //bat du phong cac trinh duyet web ko ho tro websocket
        //STOMP: simple text oriented messaging protocol: giao thuc nhan tin xac dinh dinh dang va quy tac trao doi du lieu.
        /*
        STOMP:xac dinh cach gui thu chi cho nhung nguoi dung da dang ki mot chu de cu the hoac cach gui thu den mot nguoi dung cu the
        */
        registry.addEndpoint("/ws").setAllowedOrigins("*");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /*
        dinh tuyen thu tu cua khach hang nay den khach hang khac
         */
        registry.setApplicationDestinationPrefixes("/app");//xu ly tin nhan
        registry.enableSimpleBroker("/topic");//thong diep(noi dung tin nhan)
    }
}
