package ru.websocketserver.domain.message.outgoing;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.message.Message;

import java.time.LocalDateTime;

import static ru.websocketserver.util.MessageId.SET_TURNING_DEVICE;
@Getter
@Setter
@Builder
public class DataTurningOutgoing extends Message {
    private String deviceMac;
    private String process;
    private LocalDateTime dateTime;

    public DataTurningOutgoing(String deviceMac, String process, LocalDateTime dateTime) {
        super(SET_TURNING_DEVICE);
        this.process = process;
        this.deviceMac = deviceMac;
        this.dateTime = dateTime;
    }
}
