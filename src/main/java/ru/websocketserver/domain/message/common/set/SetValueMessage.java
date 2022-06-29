package ru.websocketserver.domain.message.common.set;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static ru.websocketserver.util.ValidationErrorMessages.VALUE_NOT_NULL;
import static ru.websocketserver.util.ValidationErrorMessages.VALUE_NOT_VALID_VALUE;

@Getter
@Setter
public class SetValueMessage extends SetMessage {

    @NotNull(message = VALUE_NOT_NULL)
    @Min(value = 0, message = VALUE_NOT_VALID_VALUE)
    @Max(value = 100, message = VALUE_NOT_VALID_VALUE)
    private Integer value;

}
