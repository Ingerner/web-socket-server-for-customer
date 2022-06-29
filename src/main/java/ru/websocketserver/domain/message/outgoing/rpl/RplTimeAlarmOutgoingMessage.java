package ru.websocketserver.domain.message.outgoing.rpl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RplTimeAlarmOutgoingMessage extends RplOutgoing {

    private String time;

}