package ru.websocketserver.config.handlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.websocketserver.domain.message.common.rpl.RplBoolValueMessage;
import ru.websocketserver.domain.message.common.rpl.RplPictureModeMessage;
import ru.websocketserver.domain.message.common.rpl.RplSourceMessage;
import ru.websocketserver.domain.message.common.rpl.RplTimeAlarmMessage;
import ru.websocketserver.domain.message.common.rpl.RplValueMessage;
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
        return new RplMessageHandler<>(RplSourceMessage.class, personManager, deviceManager, RPL_SOURCE);
    }

    @Bean
    public MessageHandler rplSleepMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplBoolValueMessage.class, personManager, deviceManager, RPL_SLEEP);
    }

    @Bean
    public MessageHandler rplTimeMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplTimeAlarmMessage.class, personManager, deviceManager, RPL_TIME_ALARM);
    }

    @Bean
    public MessageHandler rplAutoSourceSwitchMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplBoolValueMessage.class, personManager, deviceManager, RPL_AUTO_SOURCE_SWITCH);
    }

    @Bean
    public MessageHandler rplBacklightMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplBoolValueMessage.class, personManager, deviceManager, RPL_BACKLIGHT);
    }

    @Bean
    public MessageHandler rplBrightnessMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplBoolValueMessage.class, personManager, deviceManager, RPL_BRIGHTNESS);
    }

    @Bean
    public MessageHandler rplPictureModeMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplPictureModeMessage.class, personManager, deviceManager, RPL_PICTURE_MODE);
    }

    @Bean
    public MessageHandler rplSaturationMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplValueMessage.class, personManager, deviceManager, RPL_SATURATION);
    }

    @Bean
    public MessageHandler rplSharpnessMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplValueMessage.class, personManager, deviceManager, RPL_SHARPNESS);
    }

    @Bean
    public MessageHandler rplVolumeMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new RplMessageHandler<>(RplValueMessage.class, personManager, deviceManager, RPL_VOLUME);
    }

}