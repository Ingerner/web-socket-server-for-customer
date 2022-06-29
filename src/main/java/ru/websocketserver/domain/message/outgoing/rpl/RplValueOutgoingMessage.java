package ru.websocketserver.domain.message.outgoing.rpl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RplValueOutgoingMessage extends RplOutgoing {

    private Integer value;

}