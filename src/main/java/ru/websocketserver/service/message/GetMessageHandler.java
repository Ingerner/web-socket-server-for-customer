package ru.websocketserver.service.message;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import ru.websocketserver.domain.incoming.GetMessageIncoming;
import ru.websocketserver.domain.outgoing.GetMessageOutgoing;
import ru.websocketserver.exception.ProcessException;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.PersonManager;
import ru.websocketserver.service.Device;

import static ru.websocketserver.util.ErrorMessage.PERSON_DOES_NOT_EXIST;
import static ru.websocketserver.util.ValidationUtil.validateReceivedMessage;

@RequiredArgsConstructor
public class GetMessageHandler implements MessageHandler {

    private static final Gson gson = new Gson();


    private final PersonManager personManager;
    private final DeviceManager deviceManager;
    private final String handleMessage;

    @Override
    public void handle(WebSocketSession session, TextMessage message) {
        checkPersonRegistration(session.getId());
        String messagePayload = message.getPayload();
        GetMessageIncoming incomingMessage = gson.fromJson(messagePayload, GetMessageIncoming.class);
        validateReceivedMessage(incomingMessage);
        Device device = deviceManager.getByMac(incomingMessage.getPanel());
        GetMessageOutgoing outgoingMessage = constructGetMessageOutgoing(incomingMessage, session.getId());
        device.sendMessage(outgoingMessage);
    }

    private void checkPersonRegistration(String sessionId) {
        if (!personManager.isRegisteredBySessionId(sessionId)) {
            throw new ProcessException(PERSON_DOES_NOT_EXIST);
        }
    }

    private static GetMessageOutgoing constructGetMessageOutgoing(GetMessageIncoming incomingMessage, String sessionId) {
        GetMessageOutgoing outgoingMessage = new GetMessageOutgoing();
        outgoingMessage.setMessageId(incomingMessage.getMessageId());
        outgoingMessage.setUserSession(sessionId);
        return outgoingMessage;
    }

    @Override
    public String getMessageType() {
        return handleMessage;
    }

}