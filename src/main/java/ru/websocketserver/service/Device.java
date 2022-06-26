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

@Slf4j
@Getter
@Setter
@Builder
public class Device implements Closeable {

    private static final Gson gson = new Gson();

    private String mac;
    private Integer temp;
    private Integer backlight;
    private Integer volume;
    private String workingHours;

    private WebSocketSession session;

    public boolean isEmptyData() {
        return temp == null
                && backlight == null
                && volume == null
                && workingHours == null;
    }

    public void sendMessage(Message message) {
        String json = gson.toJson(message);
        TextMessage textMessage = new TextMessage(json);
        if (session.isOpen()) {
            try {
                session.sendMessage(textMessage);
            } catch (IOException e) {
                log.error("Error sending message for Device with session={}", session.getId());
            }
        } else {
            log.info("Message not sending Device, session with id={} is closed", session.getId());
        }
    }

    @Override
    public void close() throws IOException {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

}