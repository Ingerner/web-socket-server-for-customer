package ru.websocketserver.domain.incoming;

import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.Message;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static ru.websocketserver.util.ValidationErrorMessages.I_AM_EMPTY_CLIENT_ID_FIELD;
import static ru.websocketserver.util.ValidationErrorMessages.I_AM_NOT_VALIDATE_CLIENT_ID_VALUE;
import static ru.websocketserver.util.ValidationErrorMessages.I_AM_PANEL_NULL_VALUE;
import static ru.websocketserver.util.ValidationErrorMessages.I_AM_PANEL_PANEL_EMPTY_VALUE;

@Getter
@Setter
public class IamPanelMessage extends Message {

    @NotNull(message = I_AM_EMPTY_CLIENT_ID_FIELD)
    @Min(value = 0, message = I_AM_NOT_VALIDATE_CLIENT_ID_VALUE)
    @Max(value = 1, message = I_AM_NOT_VALIDATE_CLIENT_ID_VALUE)
    private Integer id;

    @NotNull(message = I_AM_PANEL_NULL_VALUE)
    @NotEmpty(message = I_AM_PANEL_PANEL_EMPTY_VALUE)
    private String panel;

}