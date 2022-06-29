package ru.websocketserver.domain.message.common.rpl;

import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.message.Message;
import ru.websocketserver.domain.message.outgoing.rpl.RplOutgoing;

import javax.validation.constraints.NotEmpty;

import static ru.websocketserver.util.ValidationErrorMessages.RPL_MESSAGE_USER_SESSION_EMPTY_VALUE;

@Getter
@Setter
public abstract class RplIncomingMessage extends Message {

    @NotEmpty(message = RPL_MESSAGE_USER_SESSION_EMPTY_VALUE)
    private String userSession;

    public abstract RplOutgoing convertToOutgoingMessage(String panel);

}