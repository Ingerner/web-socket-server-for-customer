package ru.websocketserver.domain.message.common.rpl;

import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.message.Message;

import javax.validation.constraints.NotEmpty;

import static ru.websocketserver.util.ValidationErrorMessages.RPL_MESSAGE_USER_SESSION_EMPTY_VALUE;

@Getter
@Setter
public abstract class RplMessage extends Message {

    @NotEmpty(message = RPL_MESSAGE_USER_SESSION_EMPTY_VALUE)
    private String userSession;

}