package ru.websocketserver.handler;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ru.websocketserver.domain.Message;
import ru.websocketserver.domain.outgoing.Error;
import ru.websocketserver.exception.ValidationException;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;

import static ru.websocketserver.util.ValidationUtil.validateReceivedMessage;

@Slf4j
@Component
public class WebSocketHandler extends TextWebSocketHandler {
    private static final Validator validator;

    private final Gson gson = new Gson();

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        try {
            session.sendMessage(new TextMessage("Who?"));
        } catch (IOException e) {
           log.error("Error sending message for session {}", session.getId());
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        try {
            final Message receivedMessage = gson.fromJson(message.getPayload(), Message.class);
            validateReceivedMessage(receivedMessage);
        } catch (ValidationException e) {
            String errors = String.join("\n", e.getErrors());
            sendErrorResponse(session, errors);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        log.info("closed");
    }

    private void sendErrorResponse(WebSocketSession session, String message) {
        Error error = new Error();
        error.setMessageId("error");
        error.setError(message);

        TextMessage json = new TextMessage(gson.toJson(error));
        try {
            session.sendMessage(json);
        } catch (IOException e) {
            log.error("Fail sending errors for session {}", session.getId()) ;
        }
    }

}