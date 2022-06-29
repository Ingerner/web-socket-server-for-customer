package ru.websocketserver.domain.message.outgoing;

import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.message.Message;

@Getter
@Setter
public class GetMessageOutgoing extends Message {

    private String userSession;

}
