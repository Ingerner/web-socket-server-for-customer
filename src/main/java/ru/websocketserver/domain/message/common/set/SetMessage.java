package ru.websocketserver.domain.message.common.set;

import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.message.Message;

import javax.validation.constraints.NotEmpty;

import static ru.websocketserver.util.ValidationErrorMessages.SET_PANEL_NOT_EMPTY;

@Getter
@Setter
public abstract class SetMessage extends Message {

    @NotEmpty(message = SET_PANEL_NOT_EMPTY)
    private String panel;

}