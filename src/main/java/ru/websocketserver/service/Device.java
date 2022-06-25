package ru.websocketserver.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.io.Closeable;
import java.io.IOException;

@Getter
@Setter
public class Device implements Closeable {

    private String mac;
    private Integer temp;
    private Integer backlight;
    private Integer volume;
    private String workingHours;

    private WebSocketSession session;

    @Override
    public void close() throws IOException {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

}