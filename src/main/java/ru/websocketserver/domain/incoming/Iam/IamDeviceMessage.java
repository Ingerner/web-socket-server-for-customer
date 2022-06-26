package ru.websocketserver.domain.incoming.Iam;

import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.incoming.IamMessage;

import javax.validation.constraints.NotEmpty;

import static ru.websocketserver.util.ValidationErrorMessages.I_AM_PANEL_PANEL_EMPTY_VALUE;

@Getter
@Setter
public class IamDeviceMessage extends IamMessage {

    @NotEmpty(message = I_AM_PANEL_PANEL_EMPTY_VALUE)
    private String panel;

}