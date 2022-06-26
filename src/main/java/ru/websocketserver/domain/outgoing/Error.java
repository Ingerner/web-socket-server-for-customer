package ru.websocketserver.domain.outgoing;

import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.Message;

import static ru.websocketserver.util.MessageId.ERROR;

@Getter
@Setter
public class Error extends Message {

    private String error;

    public Error() {
        super(ERROR);
    }
}