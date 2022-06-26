package ru.websocketserver.service.message;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import ru.websocketserver.domain.incoming.Iam.IamDeviceMessage;
import ru.websocketserver.domain.incoming.Iam.IamPersonMessage;
import ru.websocketserver.domain.incoming.IamMessage;
import ru.websocketserver.domain.outgoing.DataOutgoing;
import ru.websocketserver.exception.MessageException;
import ru.websocketserver.exception.ProcessException;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.PersonManager;
import ru.websocketserver.service.Device;
import ru.websocketserver.service.Person;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ru.websocketserver.util.ErrorMessage.ERROR_SUBSCRIBING_DEVICE;
import static ru.websocketserver.util.MessageId.I_AM;
import static ru.websocketserver.util.ValidationErrorMessages.I_AM_PANEL_PANEL_NOT_ARRAY_FIELD_TYPE;
import static ru.websocketserver.util.ValidationErrorMessages.I_AM_PANEL_PANEL_NOT_PRIMITIVE_FIELD_TYPE;
import static ru.websocketserver.util.ValidationUtil.validateReceivedMessage;

@Service
@RequiredArgsConstructor
public class IamMessageHandler implements MessageHandler {

    private final Gson gson;
    private final PersonManager personManager;
    private final DeviceManager deviceManager;

    @Override
    public void handle(WebSocketSession session, TextMessage message) {
        String messagePayload = message.getPayload();
        IamMessage iamMessage = gson.fromJson(messagePayload, IamMessage.class);
        validateReceivedMessage(iamMessage);
        int clientId = iamMessage.getId();
        JsonElement panelField = gson.fromJson(messagePayload, JsonObject.class).get("panel");
        if (clientId == 0) {
            validatePanelFieldForPanel(panelField);
            IamDeviceMessage deviceMessage = gson.fromJson(messagePayload, IamDeviceMessage.class);
            validateReceivedMessage(deviceMessage);
            registerDevice(session, deviceMessage);
        } else {
            validatePanelFieldForPerson(panelField);
            IamPersonMessage personMessage = gson.fromJson(messagePayload, IamPersonMessage.class);
            validateReceivedMessage(personMessage);
            Person person = registerPerson(session, personMessage);
            sendAllSubscribedDeviceDataToPerson(person);
        }
    }

    @Override
    public String getMessageType() {
        return I_AM;
    }

    private void validatePanelFieldForPanel(JsonElement panelField) {
        if (panelField.isJsonArray()) {
            throw new MessageException(I_AM_PANEL_PANEL_NOT_PRIMITIVE_FIELD_TYPE);
        }
    }

    private void validatePanelFieldForPerson(JsonElement panelField) {
        if (!panelField.isJsonArray()) {
            throw new MessageException(I_AM_PANEL_PANEL_NOT_ARRAY_FIELD_TYPE);
        }
    }

    private Person registerPerson(WebSocketSession session, IamPersonMessage message) {
        Person person = Person.builder()
                .session(session)
                .panels(message.getPanel())
                .build();
        personManager.register(person);
        return person;
    }

    private Device registerDevice(WebSocketSession session, IamDeviceMessage message) {
        Device device = Device.builder()
                .mac(message.getPanel())
                .session(session)
                .build();
        deviceManager.register(device);
        return device;
    }

    private void sendAllSubscribedDeviceDataToPerson(Person person) {
        List<String> macPanels = person.getPanels();
        List<String> notFoundDevices = new ArrayList<>();
        for (String mac : macPanels) {
            Optional<Device> optionalDevice = deviceManager.getByMac(mac);
            if (optionalDevice.isPresent()) {
                Device device = optionalDevice.get();
                DataOutgoing outgoingMessage = DataOutgoing.builder()
                        .deviceMac(device.getMac())
                        .temp(device.getTemp())
                        .backlight(device.getBacklight())
                        .workingHours(device.getWorkingHours())
                        .build();
                person.sendMessage(outgoingMessage);
            } else {
                notFoundDevices.add(mac);
            }
        }
        if (!notFoundDevices.isEmpty()) {
            throw new ProcessException(
                    MessageFormat.format(ERROR_SUBSCRIBING_DEVICE, notFoundDevices)
            );
        }
    }

}