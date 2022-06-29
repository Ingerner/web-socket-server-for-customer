package ru.websocketserver.config.handlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.websocketserver.domain.message.common.rpl.RplBoolValueIncomingMessage;
import ru.websocketserver.domain.message.common.rpl.RplPictureModeIncomingMessage;
import ru.websocketserver.domain.message.common.rpl.RplSourceIncomingMessage;
import ru.websocketserver.domain.message.common.rpl.RplTimeAlarmIncomingMessage;
import ru.websocketserver.domain.message.common.rpl.RplValueIncomingMessage;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.PersonManager;
import ru.websocketserver.service.handler.MessageHandler;
import ru.websocketserver.service.handler.RplMessageHandler;

import static ru.websocketserver.util.MessageId.RPL_AUTO_SOURCE_SWITCH;
import static ru.websocketserver.util.MessageId.RPL_BACKLIGHT;
import static ru.websocketserver.util.MessageId.RPL_BRIGHTNESS;
import static ru.websocketserver.util.MessageId.RPL_PICTURE_MODE;
import static ru.websocketserver.util.MessageId.RPL_SATURATION;
import static ru.websocketserver.util.MessageId.RPL_SHARPNESS;
import static ru.websocketserver.util.MessageId.RPL_SLEEP;
import static ru.websocketserver.util.MessageId.RPL_SOURCE;
import static ru.websocketserver.util.MessageId.RPL_TIME_ALARM;
import static ru.websocketserver.util.MessageId.RPL_VOLUME;

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
        return new RplMessageHandler<>(RplBoolValueIncomingMessage.class, personManager, deviceManager, RPL_BACKLIGHT);
    }

    @Bean
    public MessageHandler rplBrightnessMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplBoolValueIncomingMessage.class, personManager, deviceManager, RPL_BRIGHTNESS);
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

}