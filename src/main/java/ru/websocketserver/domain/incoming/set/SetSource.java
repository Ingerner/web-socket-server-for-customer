package ru.websocketserver.domain.incoming.set;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static ru.websocketserver.util.ValidationErrorMessages.SET_SOURCE_SOURCE_NOT_NULL;
import static ru.websocketserver.util.ValidationErrorMessages.SET_SOURCE_SOURCE_NOT_VALID_VALUE;

@Getter
@Setter
public class SetSource extends Set {

    @NotNull(message = SET_SOURCE_SOURCE_NOT_NULL)
    @Min(value = 0, message = SET_SOURCE_SOURCE_NOT_VALID_VALUE)
    @Max(value = 1, message = SET_SOURCE_SOURCE_NOT_VALID_VALUE)
    private Integer source;

}
