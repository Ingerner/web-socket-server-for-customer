package ru.websocketserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@EnableWebSocket
@EnableScheduling
@EnableJpaRepositories(basePackages = {"ru.websocketserver.repository"})
@SpringBootApplication
public class WebSocketServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSocketServerApplication.class, args);
    }

}