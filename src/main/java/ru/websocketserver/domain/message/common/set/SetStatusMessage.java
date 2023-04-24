package ru.websocketserver.domain.message.common.set;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import static ru.websocketserver.util.ValidationErrorMessages.STATUS_NOT_NULL;

@Setter
@Getter
public class SetStatusMessage extends SetMessage{
    @NotNull(message = STATUS_NOT_NULL)
    private boolean status;
}
