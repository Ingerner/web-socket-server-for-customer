package ru.websocketserver.domain.message.incoming;

import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.message.Message;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static ru.websocketserver.util.ValidationErrorMessages.*;


@Getter
@Setter
public class DataIncoming extends Message {

    @NotNull(message = DATA_TEMP_NOT_NULL)
    private Integer temp;

    @NotNull(message = DATA_BACKLIGHT_NOT_NULL)
    private Integer backlight;

    @NotNull(message = DATA_VOLUME_NOT_NULL)
    private Integer volume;

    @NotEmpty(message = DATA_WORKING_HOURS_NOT_NULL)
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



}