package ru.websocketserver.domain.message.common.rpl;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static ru.websocketserver.util.ValidationErrorMessages.MESSAGE_VALUE_MIN_VALUE;
import static ru.websocketserver.util.ValidationErrorMessages.RPL_MESSAGE_VALUE_NOT_NULL;

@Getter
@Setter
public class RplSourceMessage extends RplMessage {

    @NotNull(message = RPL_MESSAGE_VALUE_NOT_NULL)
    @Min(value = 0, message = MESSAGE_VALUE_MIN_VALUE)
    private Integer value;

}