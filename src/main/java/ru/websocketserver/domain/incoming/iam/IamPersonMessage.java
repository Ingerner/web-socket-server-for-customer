package ru.websocketserver.domain.incoming.iam;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

import static ru.websocketserver.util.ValidationErrorMessages.I_AM_PANEL_NULL_VALUE;
import static ru.websocketserver.util.ValidationErrorMessages.I_AM_PERSON_PANEL_EMPTY_LIST;

@Getter
@Setter
public class IamPersonMessage extends IamMessage {

    @NotNull(message = I_AM_PANEL_NULL_VALUE)
    @Size(min = 1, message = I_AM_PERSON_PANEL_EMPTY_LIST)
    private List<String> panel;

}