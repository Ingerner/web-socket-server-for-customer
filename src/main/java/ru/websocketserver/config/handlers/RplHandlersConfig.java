package ru.websocketserver.config.handlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.websocketserver.domain.message.common.rpl.*;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.PersonManager;
import ru.websocketserver.service.handler.MessageHandler;
import ru.websocketserver.service.handler.RplMessageHandler;

import static ru.websocketserver.util.MessageId.*;

@Configuration
public class RplHandlersConfig {

    @Bean
    public MessageHandler rplSourceMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplSourceIncomingMessage.class, personManager, deviceManager, RPL_SOURCE);
    }

    @Bean
    public MessageHandler rplSleepMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplBoolValueIncomingMessage.class, personManager, deviceManager, RPL_SLEEP);
    }

    @Bean
    public MessageHandler rplTimeMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplTimeAlarmIncomingMessage.class, personManager, deviceManager, RPL_TIME_ALARM);
    }

    @Bean
    public MessageHandler rplAutoSourceSwitchMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplBoolValueIncomingMessage.class, personManager, deviceManager, RPL_AUTO_SOURCE_SWITCH);
    }

    @Bean
    public MessageHandler rplBacklightMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplValueIncomingMessage.class, personManager, deviceManager, RPL_BACKLIGHT);
    }

    @Bean
    public MessageHandler rplBrightnessMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplValueIncomingMessage.class, personManager, deviceManager, RPL_BRIGHTNESS);
    }

    @Bean
    public MessageHandler rplPictureModeMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplPictureModeIncomingMessage.class, personManager, deviceManager, RPL_PICTURE_MODE);
    }

    @Bean
    public MessageHandler rplSaturationMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplValueIncomingMessage.class, personManager, deviceManager, RPL_SATURATION);
    }

    @Bean
    public MessageHandler rplSharpnessMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplValueIncomingMessage.class, personManager, deviceManager, RPL_SHARPNESS);
    }

    @Bean
    public MessageHandler rplVolumeMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplValueIncomingMessage.class, personManager, deviceManager, RPL_VOLUME);
    }

    @Bean
    public MessageHandler rplWifiMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplWifiIncomingMessage.class, personManager, deviceManager, RPL_WIFI);
    }

}