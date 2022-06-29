package ru.websocketserver.domain.message.common.rpl;

import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.message.outgoing.rpl.RplOutgoing;
import ru.websocketserver.domain.message.outgoing.rpl.RplValueOutgoingMessage;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static ru.websocketserver.util.ValidationErrorMessages.MESSAGE_VALUE_MIN_VALUE;
import static ru.websocketserver.util.ValidationErrorMessages.PICTURE_MODE_VALUE_MAX;
import static ru.websocketserver.util.ValidationErrorMessages.VALUE_NOT_NULL;

@Getter
@Setter
public class RplPictureModeIncomingMessage extends RplIncomingMessage {

    @NotNull(message = VALUE_NOT_NULL)
    @Min(value = 0, message = MESSAGE_VALUE_MIN_VALUE)
    @Max(value = 10, message = PICTURE_MODE_VALUE_MAX)
    private Integer value;

    @Override
    public RplOutgoing convertToOutgoingMessage(String panel) {
        final RplValueOutgoingMessage outgoingMessage = new RplValueOutgoingMessage();
        outgoingMessage.setMessageId(getMessageId());
        outgoingMessage.setPanel(panel);
        outgoingMessage.setValue(getValue());
        return outgoingMessage;
    }

}
