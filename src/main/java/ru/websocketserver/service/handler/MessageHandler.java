package ru.websocketserver.service.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

public interface MessageHandler {

    void handle(WebSocketSession session, TextMessage message);

    String getMessageType();

}
