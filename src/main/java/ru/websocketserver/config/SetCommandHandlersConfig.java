package ru.websocketserver.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.PersonManager;
import ru.websocketserver.service.message.MessageHandler;
import ru.websocketserver.service.message.set.SetCommandHandler;

import static ru.websocketserver.util.MessageId.SET_REBOOT;
import static ru.websocketserver.util.MessageId.SET_SHUTDOWN;
import static ru.websocketserver.util.MessageId.SET_SLEEP;
import static ru.websocketserver.util.MessageId.SET_WAKEUP;

@Configuration
@RequiredArgsConstructor
public class SetCommandHandlersConfig {

    private final PersonManager personManager;
    private final DeviceManager deviceManager;

    @Bean
    public MessageHandler setRebootMessageHandler() {
        return new SetCommandHandler(deviceManager, personManager, SET_REBOOT);
    }

    @Bean
    public MessageHandler setShutdownMessageHandler() {
        return new SetCommandHandler(deviceManager, personManager, SET_SHUTDOWN);
    }

    @Bean
    public MessageHandler setSleepMessageHandler() {
        return new SetCommandHandler(deviceManager, personManager, SET_SLEEP);
    }

    @Bean
    public MessageHandler setWakeUpMessageHandler() {
        return new SetCommandHandler(deviceManager, personManager, SET_WAKEUP);
    }

}
