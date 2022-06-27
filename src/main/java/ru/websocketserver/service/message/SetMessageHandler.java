package ru.websocketserver.service.message;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import ru.websocketserver.domain.incoming.set.SetMessage;
import ru.websocketserver.exception.ProcessException;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.PersonManager;
import ru.websocketserver.service.Device;

import static ru.websocketserver.util.ErrorMessage.PERSON_DOES_NOT_EXIST;
import static ru.websocketserver.util.ValidationUtil.validateReceivedMessage;

@RequiredArgsConstructor
public class SetMessageHandler<T extends SetMessage> implements MessageHandler {

    private static final Gson gson = new Gson();

    private final Class<T> classMessage;
    private final DeviceManager deviceManager;
    private final PersonManager personManager;

    private final String handleMessage;

    @Override
    public void handle(WebSocketSession session, TextMessage message) {
        checkPersonRegistration(session.getId());
        String messagePayload = message.getPayload();
        T setSourceMessage = gson.fromJson(messagePayload, classMessage);
        validateReceivedMessage(setSourceMessage);
        Device device = deviceManager.getByMac(setSourceMessage.getPanel());
        device.sendMessage(setSourceMessage);
    }

    private void checkPersonRegistration(String sessionId) {
        if (!personManager.isRegisteredBySessionId(sessionId)) {
            throw new ProcessException(PERSON_DOES_NOT_EXIST);
        }
    }

    @Override
    public String getMessageType() {
        return handleMessage;
    }
}