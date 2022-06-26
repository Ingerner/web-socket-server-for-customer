package ru.websocketserver.service.message;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import ru.websocketserver.domain.incoming.DataIncoming;
import ru.websocketserver.domain.outgoing.DataOutgoing;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.SubscribeManager;
import ru.websocketserver.service.Device;

import static ru.websocketserver.util.MessageId.DATA;
import static ru.websocketserver.util.ValidationUtil.validateReceivedMessage;

@Service
@RequiredArgsConstructor
public class DataMessageHandler implements MessageHandler {

    private final Gson gson;
    private final DeviceManager deviceManager;
    private final SubscribeManager subscribeManager;

    @Override
    public void handle(WebSocketSession session, TextMessage message) {
        String messagePayload = message.getPayload();
        DataIncoming dataDevice = gson.fromJson(messagePayload, DataIncoming.class);
        validateReceivedMessage(dataDevice);

        Device device = deviceManager.getBySessionId(session.getId());
        setDeviceData(device, dataDevice);
        DataOutgoing outgoingMessage = getOutgoingMessage(device);
        subscribeManager.sendAllMessageDeviceSubscribers(device.getMac(), outgoingMessage);
    }

    @Override
    public String getMessageType() {
        return DATA;
    }

    private void setDeviceData(Device device, DataIncoming incomingData) {
        device.setTemp(incomingData.getTemp());
        device.setBacklight(incomingData.getBacklight());
        device.setVolume(incomingData.getVolume());
        device.setWorkingHours(incomingData.getWorkingHours());
    }

    private DataOutgoing getOutgoingMessage(Device device) {
        return DataOutgoing.builder()
                .deviceMac(device.getMac())
                .temp(device.getTemp())
                .backlight(device.getBacklight())
                .volume(device.getVolume())
                .workingHours(device.getWorkingHours())
                .build();
    }

}