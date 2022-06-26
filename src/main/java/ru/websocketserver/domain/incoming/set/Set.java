package ru.websocketserver.domain.incoming.set;

import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.Message;

import javax.validation.constraints.NotEmpty;

import static ru.websocketserver.util.ValidationErrorMessages.SET_SOURCE_MAC_NOT_EMPTY;

@Getter
@Setter
public abstract class Set extends Message {

    @NotEmpty(message = SET_SOURCE_MAC_NOT_EMPTY)
    private String panel;

}