package ru.websocketserver.domain.message.incoming;

import lombok.Getter;

import lombok.Setter;
import ru.websocketserver.domain.message.Message;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static ru.websocketserver.util.ValidationErrorMessages.SET_DATE_TIME_NOT_NULL;


@Getter
@Setter
public class SetMassageIncoming extends Message {
    @NotNull(message = SET_DATE_TIME_NOT_NULL)
    private LocalDateTime dateTime;
}
