package ru.websocketserver.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import static ru.websocketserver.util.ValidationErrorMessages.MESSAGE_NOT_MESSAGE_ID_FIELD;

@Getter
@Setter
public class Message {

    @NotNull(message = MESSAGE_NOT_MESSAGE_ID_FIELD)
    private String messageId;

}