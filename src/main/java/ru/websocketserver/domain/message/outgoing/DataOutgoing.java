package ru.websocketserver.domain.message.outgoing;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.message.Message;

import java.time.LocalDateTime;

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

    private LocalDateTime dateTime;

    public DataOutgoing(String deviceMac, Integer temp, Integer backlight, Integer volume, String workingHours, LocalDateTime dateTime) {
        super(DATA);
        this.deviceMac = deviceMac;
        this.temp = temp;
        this.backlight = backlight;
        this.volume = volume;
        this.workingHours = workingHours;
        this.dateTime = dateTime;

    }
}