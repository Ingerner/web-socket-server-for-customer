package ru.websocketserver.domain.message.incoming.iam;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

import static ru.websocketserver.util.ValidationErrorMessages.I_AM_PANEL_PANEL_EMPTY_VALUE;

@Getter
@Setter
public class IamDeviceMessage extends IamMessage {

    @NotEmpty(message = I_AM_PANEL_PANEL_EMPTY_VALUE)
    private String panel;

}