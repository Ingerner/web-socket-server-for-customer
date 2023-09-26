package ru.websocketserver.domain.message.common.rpl;

import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.message.outgoing.rpl.RplOutgoing;
import ru.websocketserver.domain.message.outgoing.rpl.RplWifiOutgoingMessage;
import ru.websocketserver.domain.message.outgoing.rpl.RplWifiOutgoingMessage.RplWifiResultOutgoing;

import java.util.List;

@Getter
@Setter
public class RplWifiIncomingMessage extends RplIncomingMessage {

    private List<RplWifiResult> wifiData;

    @Override
    public RplOutgoing convertToOutgoingMessage(String panel) {
        final List<RplWifiResultOutgoing> results = wifiData.stream()
                .map(result -> RplWifiResultOutgoing.builder()
                        .bssid(result.bssid)
                        .ssid(result.ssid)
                        .capabilities(result.capabilities)
                        .build()
                ).toList();

        final RplWifiOutgoingMessage message = new RplWifiOutgoingMessage();
        message.setMessageId(getMessageId());
        message.setPanel(panel);
        message.setResults(results);

        return message;
    }

    @Getter
    @Setter
    public static class RplWifiResult {

        private String bssid;
        private String ssid;
        private String capabilities;

    }

}
