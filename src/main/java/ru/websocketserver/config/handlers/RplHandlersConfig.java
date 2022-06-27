package ru.websocketserver.config.handlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.websocketserver.domain.common.rpl.RplSourceMessage;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.PersonManager;
import ru.websocketserver.service.message.MessageHandler;
import ru.websocketserver.service.message.RplMessageHandler;

import static ru.websocketserver.util.MessageId.RPL_SOURCE;

@Configuration
public class RplHandlersConfig {

    @Bean
    public MessageHandler rplSourceMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplSourceMessage.class, personManager, deviceManager, RPL_SOURCE);
    }

}