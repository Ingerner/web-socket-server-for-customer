package ru.websocketserver.service;

import com.google.gson.Gson;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import ru.websocketserver.domain.Message;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

@Slf4j
@Getter
@Setter
@Builder
public class Person implements Closeable {

    private static final Gson gson = new Gson();

    private List<String> panels;
    private WebSocketSession session;

    public void sendMessage(Message message) {
        String json = gson.toJson(message);
        TextMessage textMessage = new TextMessage(json);
        if (session.isOpen()) {
            try {
                session.sendMessage(textMessage);
            } catch (IOException e) {
                log.error("Error sending message for Person with session={}", session.getId());
            }
        } else {
            log.info("Message not sending Person, session with id={} is closed", session.getId());
        }
    }

    @Override
    public void close() throws IOException {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

}