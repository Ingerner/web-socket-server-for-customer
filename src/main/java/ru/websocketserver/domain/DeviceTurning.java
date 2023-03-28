package ru.websocketserver.domain;

import com.google.gson.Gson;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ru.websocketserver.domain.message.Message;

import java.time.LocalDateTime;

@Slf4j
@Getter
@Setter
@Builder
public class DeviceTurning extends Message {

    private LocalDateTime dateTime;
}
