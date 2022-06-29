package ru.websocketserver.domain.message.outgoing.rpl;

import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.message.Message;

@Getter
@Setter
public abstract class RplOutgoing extends Message {

    private String panel;

}