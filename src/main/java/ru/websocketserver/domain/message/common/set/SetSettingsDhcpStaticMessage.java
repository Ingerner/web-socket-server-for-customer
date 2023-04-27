package ru.websocketserver.domain.message.common.set;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import static ru.websocketserver.util.ValidationErrorMessages.SETTING_NOT_NULL;

@Getter
@Setter
public class SetSettingsDhcpStaticMessage extends SetMessage{
    @NotNull(message = SETTING_NOT_NULL)
    private String setting;
    private String ipAddress;
}
