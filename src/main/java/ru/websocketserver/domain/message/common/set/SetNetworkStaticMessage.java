package ru.websocketserver.domain.message.common.set;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import static ru.websocketserver.util.ValidationErrorMessages.*;
@Getter
@Setter
public class SetNetworkStaticMessage extends SetMessage {
    @NotNull(message = IP_NOT_NULL)
    private String ip;
    @NotNull(message = MASK_NOT_NULL)
    private String mask;

    @NotNull(message = DNS1_NOT_NULL)
    private String dns1;
}
