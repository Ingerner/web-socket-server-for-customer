package ru.websocketserver.domain.message.common.set;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import static ru.websocketserver.util.ValidationErrorMessages.*;

@Getter
@Setter
public class SetWifiPasswordMessage extends SetMessage {
    @NotNull(message = SSID_NOT_NULL)
    private String ssid;
    @NotNull(message = PASSWORD_NOT_NULL)
    private String password;
}
