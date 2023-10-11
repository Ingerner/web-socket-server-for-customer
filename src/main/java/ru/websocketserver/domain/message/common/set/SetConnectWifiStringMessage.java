package ru.websocketserver.domain.message.common.set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetConnectWifiStringMessage extends SetMessage {

    private String value;
    @Getter
    @Setter

        private String ssId;
        private String password;

}
