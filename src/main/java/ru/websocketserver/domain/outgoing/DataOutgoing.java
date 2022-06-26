package ru.websocketserver.domain.outgoing;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.Message;

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

    public DataOutgoing() {
        super(DATA);
    }

}