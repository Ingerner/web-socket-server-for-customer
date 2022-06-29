package ru.websocketserver.domain.message.common.rpl;

import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.message.outgoing.rpl.RplOutgoing;
import ru.websocketserver.domain.message.outgoing.rpl.RplValueOutgoingMessage;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static ru.websocketserver.util.ValidationErrorMessages.MESSAGE_VALUE_MIN_VALUE;
import static ru.websocketserver.util.ValidationErrorMessages.RPL_MESSAGE_VALUE_NOT_NULL;

@Getter
@Setter
public class RplSourceIncomingMessage extends RplIncomingMessage {

    @NotNull(message = RPL_MESSAGE_VALUE_NOT_NULL)
    @Min(value = 0, message = MESSAGE_VALUE_MIN_VALUE)
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