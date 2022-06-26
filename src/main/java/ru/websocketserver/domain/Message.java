package ru.websocketserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import static ru.websocketserver.util.ValidationErrorMessages.MESSAGE_NOT_MESSAGE_ID_FIELD;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @NotNull(message = MESSAGE_NOT_MESSAGE_ID_FIELD)
    private String messageId;

}