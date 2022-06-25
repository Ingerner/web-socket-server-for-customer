package ru.websocketserver.service.message;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import ru.websocketserver.domain.Message;
import ru.websocketserver.domain.incoming.IamPanelMessage;
import ru.websocketserver.domain.incoming.IamPersonMessage;
import ru.websocketserver.exception.MessageException;

import static ru.websocketserver.util.MessageId.I_AM;
import static ru.websocketserver.util.ValidationErrorMessages.I_AM_PANEL_PANEL_NOT_ARRAY_FIELD_TYPE;
import static ru.websocketserver.util.ValidationErrorMessages.I_AM_PANEL_PANEL_NOT_PRIMITIVE_FIELD_TYPE;
import static ru.websocketserver.util.ValidationUtil.validateReceivedMessage;

@Service
@RequiredArgsConstructor
public class IamMessageHandler implements MessageHandler {

    private final Gson gson;

    @Override
    public void handle(WebSocketSession session, TextMessage message) {
        String messagePayload = message.getPayload();
        int clientId = gson.fromJson(messagePayload, JsonObject.class)
                .get("id")
                .getAsInt();
        JsonElement panelField = gson.fromJson(messagePayload, JsonObject.class).get("panel");
        Message iamMessage;
        if (clientId == 0) {
            validatePanelFieldForPanel(panelField);
            iamMessage = gson.fromJson(messagePayload, IamPanelMessage.class);
        } else {
            validatePanelFieldForPerson(panelField);
            iamMessage = gson.fromJson(messagePayload, IamPersonMessage.class);
        }
        validateReceivedMessage(iamMessage);
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

}