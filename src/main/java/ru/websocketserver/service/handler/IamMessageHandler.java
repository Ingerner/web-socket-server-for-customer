package ru.websocketserver.service.handler;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import ru.websocketserver.domain.message.incoming.iam.IamDeviceMessage;
import ru.websocketserver.domain.message.incoming.iam.IamMessage;
import ru.websocketserver.domain.message.incoming.iam.IamPersonMessage;
import ru.websocketserver.domain.message.outgoing.DataOutgoing;
import ru.websocketserver.exception.MessageException;
import ru.websocketserver.exception.ProcessException;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.PersonManager;
import ru.websocketserver.domain.Device;
import ru.websocketserver.domain.Person;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ru.websocketserver.util.ErrorMessage.CLIENT_WITH_CURRENT_SESSION_REGISTERED_AS_DEVICE;
import static ru.websocketserver.util.ErrorMessage.CLIENT_WITH_CURRENT_SESSION_REGISTERED_AS_PERSON;
import static ru.websocketserver.util.ErrorMessage.ERROR_SUBSCRIBING_DEVICE;
import static ru.websocketserver.util.MessageId.I_AM;
import static ru.websocketserver.util.ValidationErrorMessages.I_AM_PANEL_NULL_VALUE;
import static ru.websocketserver.util.ValidationErrorMessages.I_AM_PANEL_PANEL_EMPTY_VALUE;
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
        if (clientId == 0) {
            addDevice(session, messagePayload);
        } else {
            addPerson(session, messagePayload);
        }
    }

    @Override
    public String getMessageType() {
        return I_AM;
    }

    private void addPerson(WebSocketSession session, String messagePayload) {
        if (deviceManager.isRegisteredBySessionId(session.getId())) {
            throw new ProcessException(CLIENT_WITH_CURRENT_SESSION_REGISTERED_AS_DEVICE);
        }
        JsonElement panelField = gson.fromJson(messagePayload, JsonObject.class).get("panel");
        validatePanelFieldForPerson(panelField);
        IamPersonMessage personMessage = gson.fromJson(messagePayload, IamPersonMessage.class);
        validateReceivedMessage(personMessage);
        Person person = registerPerson(session, personMessage);
        sendAllSubscribedDeviceDataToPerson(person);
    }

    private void addDevice(WebSocketSession session, String messagePayload) {
        if (personManager.isRegisteredBySessionId(session.getId())) {
            throw new ProcessException(CLIENT_WITH_CURRENT_SESSION_REGISTERED_AS_PERSON);
        }
        JsonElement panelField = gson.fromJson(messagePayload, JsonObject.class).get("panel");
        validatePanelFieldForPanel(panelField);
        IamDeviceMessage deviceMessage = gson.fromJson(messagePayload, IamDeviceMessage.class);
        validateReceivedMessage(deviceMessage);
        registerDevice(session, deviceMessage);
    }

    private void validatePanelFieldForPanel(JsonElement panelField) {
        if (panelField == null) {
            throw new MessageException(I_AM_PANEL_PANEL_EMPTY_VALUE);
        }
        if (panelField.isJsonArray()) {
            throw new MessageException(I_AM_PANEL_PANEL_NOT_PRIMITIVE_FIELD_TYPE);
        }
    }

    private void validatePanelFieldForPerson(JsonElement panelField) {
        if (panelField == null) {
            throw new MessageException(I_AM_PANEL_NULL_VALUE);
        }
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
            Optional<Device> optionalDevice = deviceManager.getByMacOfOptional(mac);
            if (optionalDevice.isPresent()) {
                Device device = optionalDevice.get();
                if (!device.isEmptyData()) {
                    DataOutgoing outgoingMessage = DataOutgoing.builder()
                            .deviceMac(device.getMac())
                            .temp(device.getTemp())
                            .backlight(device.getBacklight())
                            .workingHours(device.getWorkingHours())
                            .build();
                    person.sendMessage(outgoingMessage);
                }
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