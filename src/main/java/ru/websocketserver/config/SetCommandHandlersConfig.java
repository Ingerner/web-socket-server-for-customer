package ru.websocketserver.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.websocketserver.domain.incoming.set.SetCommandMessage;
import ru.websocketserver.domain.incoming.set.SetSourceMessage;
import ru.websocketserver.domain.incoming.set.SetTimeAlarmMessage;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.PersonManager;
import ru.websocketserver.service.message.MessageHandler;
import ru.websocketserver.service.message.set.SetMessageHandler;

import static ru.websocketserver.util.MessageId.SET_REBOOT;
import static ru.websocketserver.util.MessageId.SET_SHUTDOWN;
import static ru.websocketserver.util.MessageId.SET_SLEEP;
import static ru.websocketserver.util.MessageId.SET_SOURCE;
import static ru.websocketserver.util.MessageId.SET_TIME_ALARM;
import static ru.websocketserver.util.MessageId.SET_WAKEUP;

@Configuration
@RequiredArgsConstructor
public class SetCommandHandlersConfig {

    private final PersonManager personManager;
    private final DeviceManager deviceManager;

    @Bean
    public MessageHandler setSourceMessageHandler() {
        return new SetMessageHandler<>(SetSourceMessage.class, deviceManager, personManager, SET_SOURCE);
    }

    @Bean
    public MessageHandler setRebootMessageHandler() {
        return new SetMessageHandler<>(SetCommandMessage.class, deviceManager, personManager, SET_REBOOT);
    }

    @Bean
    public MessageHandler setShutdownMessageHandler() {
        return new SetMessageHandler<>(SetCommandMessage.class, deviceManager, personManager, SET_SHUTDOWN);
    }

    @Bean
    public MessageHandler setSleepMessageHandler() {
        return new SetMessageHandler<>(SetCommandMessage.class, deviceManager, personManager, SET_SLEEP);
    }

    @Bean
    public MessageHandler setWakeUpMessageHandler() {
        return new SetMessageHandler<>(SetCommandMessage.class, deviceManager, personManager, SET_WAKEUP);
    }

    @Bean
    public MessageHandler setTimeAlarmMessageHandler() {
        return new SetMessageHandler<>(SetTimeAlarmMessage.class, deviceManager, personManager, SET_TIME_ALARM);
    }

}