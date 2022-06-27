package ru.websocketserver.domain.common.set;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static ru.websocketserver.util.ValidationErrorMessages.SET_SOURCE_SOURCE_NOT_NULL;
import static ru.websocketserver.util.ValidationErrorMessages.SET_SOURCE_SOURCE_NOT_VALID_VALUE;

@Getter
@Setter
public class SetSourceMessage extends SetMessage {

    @NotNull(message = SET_SOURCE_SOURCE_NOT_NULL)
    @Min(value = 0, message = SET_SOURCE_SOURCE_NOT_VALID_VALUE)
    private Integer source;

}
