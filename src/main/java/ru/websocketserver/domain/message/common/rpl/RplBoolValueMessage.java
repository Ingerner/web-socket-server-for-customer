package ru.websocketserver.domain.message.common.rpl;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static ru.websocketserver.util.ValidationErrorMessages.MESSAGE_VALUE_MIN_VALUE;
import static ru.websocketserver.util.ValidationErrorMessages.RPL_MESSAGE_VALUE_NOT_NULL;
import static ru.websocketserver.util.ValidationErrorMessages.RPL_TWO_VAL_VALUE_MAX_VALUE;

@Getter
@Setter
public class RplBoolValueMessage extends RplMessage {

    @NotNull(message = RPL_MESSAGE_VALUE_NOT_NULL)
    @Min(value = 0, message = MESSAGE_VALUE_MIN_VALUE)
    @Max(value = 1, message = RPL_TWO_VAL_VALUE_MAX_VALUE)
    private Integer value;

}
