package ru.websocketserver.domain.message.common.set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetConnectWifiMessage extends SetMessage {



    private SetConnectWifi value;

    @Getter
    @Setter
    public static class SetConnectWifi {

        private String ssId;
        private String password;

    }

}
