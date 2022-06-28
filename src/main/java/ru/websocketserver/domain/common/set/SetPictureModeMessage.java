package ru.websocketserver.domain.common.set;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static ru.websocketserver.util.ValidationErrorMessages.MESSAGE_VALUE_MIN_VALUE;
import static ru.websocketserver.util.ValidationErrorMessages.PICTURE_MODE_VALUE_MAX;
import static ru.websocketserver.util.ValidationErrorMessages.VALUE_NOT_NULL;

@Getter
@Setter
public class SetPictureModeMessage extends SetMessage {

    @NotNull(message = VALUE_NOT_NULL)
    @Min(value = 0, message = MESSAGE_VALUE_MIN_VALUE)
    @Max(value = 10, message = PICTURE_MODE_VALUE_MAX)
    private Integer value;

}