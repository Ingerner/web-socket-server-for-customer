package ru.websocketserver.domain.outgoing;

import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.Message;

@Getter
@Setter
public class GetMessageOutgoing extends Message {

    private String userSession;

}
