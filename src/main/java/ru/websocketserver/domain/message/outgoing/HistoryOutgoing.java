package ru.websocketserver.domain.message.outgoing;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.message.Message;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class HistoryOutgoing extends Message {
    private String messageId;
    private String messageText;

    private LocalDateTime dateTime;
}
