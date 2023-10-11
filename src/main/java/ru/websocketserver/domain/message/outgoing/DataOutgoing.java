package ru.websocketserver.domain.message.outgoing;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.message.Message;


import static ru.websocketserver.util.MessageId.DATA;

@Getter
@Setter
@Builder
public class DataOutgoing extends Message {

    private String deviceMac;
    private Integer temp;
    private Integer backlight;
    private Integer volume;
    private String workingHours;
    private boolean lan;
    private String ipEthernet;
    private String dns1Ethernet;
    private String dns2Ethernet;
    private String gateWayEthernet;
    private boolean wifi;
    private String ipWifi;
    private String dns1Wifi;
    private String gateWayWifi;


    public DataOutgoing(String deviceMac, Integer temp, Integer backlight, Integer volume, String workingHours
                            ,boolean lan, String ipEthernet, String dns1Ethernet, String dns2Ethernet
                            , String gateWayEthernet, boolean wifi, String ipWifi, String dns1Wifi, String gateWayWifi) {
        super(DATA);
        this.deviceMac = deviceMac;
        this.temp = temp;
        this.backlight = backlight;
        this.volume = volume;
        this.workingHours = workingHours;
        this.lan = lan;
        this.ipEthernet = ipEthernet;
        this.dns1Ethernet = dns1Ethernet;
        this.dns2Ethernet = dns2Ethernet;
        this.gateWayEthernet = gateWayEthernet;
        this.wifi = wifi;
        this.ipWifi = ipWifi;
        this.dns1Wifi = dns1Wifi;
        this.gateWayWifi = gateWayWifi;
    }
}