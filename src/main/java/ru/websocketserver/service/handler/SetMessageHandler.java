package ru.websocketserver.service.handler;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import ru.websocketserver.domain.message.common.set.SetMessage;
import ru.websocketserver.exception.ProcessException;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.PersonManager;
import ru.websocketserver.domain.Device;

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
        T setMessage = gson.fromJson(messagePayload, classMessage);
        validateReceivedMessage(setMessage);
        Device device = deviceManager.getByMac(setMessage.getPanel());
        device.sendMessage(setMessage);
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