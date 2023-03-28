package ru.websocketserver.service.handler;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import ru.websocketserver.domain.Device;
import ru.websocketserver.domain.DeviceTurning;
import ru.websocketserver.domain.message.incoming.SetMassageIncoming;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.service.DeviceTurningService;

import static ru.websocketserver.util.MessageId.SET_TURNING_DEVICE;
import static ru.websocketserver.util.ValidationUtil.validateReceivedMessage;

@Service
@RequiredArgsConstructor
public class SetTurningDeviceHandler implements MessageHandler {

    private final Gson gson;
    private final DeviceManager deviceManager;
    private final DeviceTurningService turningService;



    @Override
    @SneakyThrows
    public void handle(WebSocketSession session, TextMessage message) {
        String messagePayload = message.getPayload();
        DeviceTurning massageIncoming = gson.fromJson(messagePayload, DeviceTurning.class);
        validateReceivedMessage(massageIncoming);
        Device device = deviceManager.getBySessionId(session.getId());
        device.getMac();
        session.close();


    }


    @Override
    public String getMessageType() {
        return SET_TURNING_DEVICE;
    }
}
