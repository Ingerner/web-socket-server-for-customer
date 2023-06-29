package ru.websocketserver.domain.message.common.set;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static ru.websocketserver.util.ValidationErrorMessages.STATUS_NOT_NULL;
import static ru.websocketserver.util.ValidationErrorMessages.VALUE_NOT_VALID_VALUE_STATUS;


@Setter
@Getter
public class SetStatusMessage extends SetMessage{
    @NotNull(message = STATUS_NOT_NULL)
    @Min(value = 0, message = VALUE_NOT_VALID_VALUE_STATUS)
    @Max(value = 1, message = VALUE_NOT_VALID_VALUE_STATUS)
    private Integer value;
}
