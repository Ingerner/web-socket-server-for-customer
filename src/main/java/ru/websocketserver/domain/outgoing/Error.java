package ru.websocketserver.domain.outgoing;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.Message;

import java.util.List;

@Getter
@Setter
public class Error extends Message {

    private String error;

}