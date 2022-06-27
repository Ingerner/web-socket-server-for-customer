package ru.websocketserver.domain.common.rpl;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static ru.websocketserver.util.ValidationErrorMessages.PRL_SOURCE_VALUE_MIN_VALUE;
import static ru.websocketserver.util.ValidationErrorMessages.RPL_SOURCE_VALUE_NOT_NULL;

@Getter
@Setter
public class RplSourceMessage extends RplMessage {

    @NotNull(message = RPL_SOURCE_VALUE_NOT_NULL)
    @Min(value = 0, message = PRL_SOURCE_VALUE_MIN_VALUE)
    private Integer value;

}