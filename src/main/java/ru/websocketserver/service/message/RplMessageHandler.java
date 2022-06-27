package ru.websocketserver.service.message;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import ru.websocketserver.domain.common.rpl.RplMessage;
import ru.websocketserver.exception.ProcessException;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.PersonManager;
import ru.websocketserver.service.Person;

import static ru.websocketserver.util.ErrorMessage.DEVICE_DOES_NOT_EXIST;
import static ru.websocketserver.util.ValidationUtil.validateReceivedMessage;

@RequiredArgsConstructor
public class RplMessageHandler<T extends RplMessage> implements MessageHandler {

    private final Gson gson = new Gson();

    private final Class<T> classMessage;
    private final PersonManager personManager;
    private final DeviceManager deviceManager;
    private final String handleMessage;

    @Override
    public void handle(WebSocketSession session, TextMessage message) {
        checkDeviceRegistration(session.getId());
        String messagePayload = message.getPayload();
        T rplMessage = gson.fromJson(messagePayload, classMessage);
        validateReceivedMessage(rplMessage);
        String personSession = rplMessage.getUserSession();
        Person person = personManager.getBySessionId(personSession);
        person.sendMessage(rplMessage);
    }

    @Override
    public String getMessageType() {
        return handleMessage;
    }

    private void checkDeviceRegistration(String sessionId) {
        if (!deviceManager.isRegisteredBySessionId(sessionId)) {
            throw new ProcessException(DEVICE_DOES_NOT_EXIST);
        }
    }
}
