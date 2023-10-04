package ru.websocketserver.domain.message.outgoing.rpl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RplWifiOutgoingMessage extends RplOutgoing {

    private List<RplWifiResultOutgoing> results;


    @Getter
    @Setter
    @Builder
    public static class RplWifiResultOutgoing {

        private String  BSSID;
        private String SSID;
        private String capabilities;

    }

}
