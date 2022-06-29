package ru.websocketserver.domain.message.outgoing;

import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.message.Message;

import static ru.websocketserver.util.MessageId.ERROR;

@Getter
@Setter
public class Error extends Message {

    private String error;

    public Error() {
        super(ERROR);
    }
}