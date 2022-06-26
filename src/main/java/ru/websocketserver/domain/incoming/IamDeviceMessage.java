package ru.websocketserver.domain.incoming;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static ru.websocketserver.util.ValidationErrorMessages.I_AM_PANEL_NULL_VALUE;
import static ru.websocketserver.util.ValidationErrorMessages.I_AM_PANEL_PANEL_EMPTY_VALUE;

@Getter
@Setter
public class IamDeviceMessage extends IamMessage {

    @NotNull(message = I_AM_PANEL_NULL_VALUE)
    @NotEmpty(message = I_AM_PANEL_PANEL_EMPTY_VALUE)
    private String panel;

}