package ru.websocketserver.handler;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ru.websocketserver.domain.message.Message;
import ru.websocketserver.domain.message.outgoing.Error;
import ru.websocketserver.exception.ValidationException;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.PersonManager;
import ru.websocketserver.service.handler.MessageHandler;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ru.websocketserver.util.ValidationErrorMessages.UNSUPPORTED_MESSAGE_ID;
import static ru.websocketserver.util.ValidationUtil.validateReceivedMessage;

@Slf4j
@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private final Gson gson = new Gson();

    private final Map<String, MessageHandler> handlers;

    private final PersonManager personManager;
    private final DeviceManager deviceManager;

    public WebSocketHandler(List<MessageHandler> handlers, PersonManager personManager, DeviceManager deviceManager) {
        this.handlers = handlers
                .stream()
                .collect(Collectors.toMap(MessageHandler::getMessageType, MessageHandler.class::cast));
        this.personManager = personManager;
        this.deviceManager = deviceManager;
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
            String messageId = receivedMessage.getMessageId();
            MessageHandler currentHandler = handlers.get(messageId);
            if (currentHandler != null) {
                currentHandler.handle(session, message);
            } else {
                sendErrorResponse(session, MessageFormat.format(UNSUPPORTED_MESSAGE_ID, messageId));
            }
        } catch (ValidationException e) {
            String errors = String.join("\n", e.getErrors());
            sendErrorResponse(session, errors);
        } catch (Exception e) {
            sendErrorResponse(session, e.getMessage());
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        personManager.deleteBySessionId(session.getId());
        deviceManager.deleteBySessionId(session.getId());
    }

    private void sendErrorResponse(WebSocketSession session, String message) {
        Error error = new Error();
        error.setError(message);

        TextMessage json = new TextMessage(gson.toJson(error));
        try {
            session.sendMessage(json);
        } catch (IOException e) {
            log.error("Fail sending errors for session {}", session.getId());
        }
    }

}