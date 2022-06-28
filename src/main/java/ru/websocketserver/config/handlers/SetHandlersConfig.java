package ru.websocketserver.config.handlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.websocketserver.domain.common.set.SetCommandMessage;
import ru.websocketserver.domain.common.set.SetPictureModeMessage;
import ru.websocketserver.domain.common.set.SetSourceMessage;
import ru.websocketserver.domain.common.set.SetTimeAlarmMessage;
import ru.websocketserver.domain.common.set.SetValueMessage;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.PersonManager;
import ru.websocketserver.service.message.MessageHandler;
import ru.websocketserver.service.message.SetMessageHandler;

import static ru.websocketserver.util.MessageId.SET_AUTO_SOURCE_SWITCH;
import static ru.websocketserver.util.MessageId.SET_BACKLIGHT;
import static ru.websocketserver.util.MessageId.SET_BRIGHTNESS;
import static ru.websocketserver.util.MessageId.SET_OPS_START;
import static ru.websocketserver.util.MessageId.SET_PICTURE_MODE;
import static ru.websocketserver.util.MessageId.SET_REBOOT;
import static ru.websocketserver.util.MessageId.SET_SATURATION;
import static ru.websocketserver.util.MessageId.SET_SHARPNESS;
import static ru.websocketserver.util.MessageId.SET_SHUTDOWN;
import static ru.websocketserver.util.MessageId.SET_SLEEP;
import static ru.websocketserver.util.MessageId.SET_SOURCE;
import static ru.websocketserver.util.MessageId.SET_TIME_ALARM;
import static ru.websocketserver.util.MessageId.SET_VOLUME;
import static ru.websocketserver.util.MessageId.SET_VOLUME_DOWN;
import static ru.websocketserver.util.MessageId.SET_VOLUME_UP;
import static ru.websocketserver.util.MessageId.SET_WAKEUP;

@Configuration
public class SetHandlersConfig {

    @Bean
    public MessageHandler setSourceMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetSourceMessage.class, deviceManager, personManager, SET_SOURCE);
    }

    @Bean
    public MessageHandler setRebootMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetCommandMessage.class, deviceManager, personManager, SET_REBOOT);
    }

    @Bean
    public MessageHandler setShutdownMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetCommandMessage.class, deviceManager, personManager, SET_SHUTDOWN);
    }

    @Bean
    public MessageHandler setSleepMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetCommandMessage.class, deviceManager, personManager, SET_SLEEP);
    }

    @Bean
    public MessageHandler setWakeUpMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetCommandMessage.class, deviceManager, personManager, SET_WAKEUP);
    }

    @Bean
    public MessageHandler setTimeAlarmMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetTimeAlarmMessage.class, deviceManager, personManager, SET_TIME_ALARM);
    }

    @Bean
    public MessageHandler setAutoSourceSwitchMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetCommandMessage.class, deviceManager, personManager, SET_AUTO_SOURCE_SWITCH);
    }

    @Bean
    public MessageHandler setOpsStartMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetCommandMessage.class, deviceManager, personManager, SET_OPS_START);
    }

    @Bean
    public MessageHandler setBacklightMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetCommandMessage.class, deviceManager, personManager, SET_BACKLIGHT);
    }

    @Bean
    public MessageHandler setBrightnessMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetCommandMessage.class, deviceManager, personManager, SET_BRIGHTNESS);
    }

    @Bean
    public MessageHandler setPictureModeMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetPictureModeMessage.class, deviceManager, personManager, SET_PICTURE_MODE);
    }

    @Bean
    public MessageHandler setSaturationMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetValueMessage.class, deviceManager, personManager, SET_SATURATION);
    }

    @Bean
    public MessageHandler setSharpnessMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetValueMessage.class, deviceManager, personManager, SET_SHARPNESS);
    }

    @Bean
    public MessageHandler setVolumeMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetValueMessage.class, deviceManager, personManager, SET_VOLUME);
    }

    @Bean
    public MessageHandler setVolumeUpMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetCommandMessage.class, deviceManager, personManager, SET_VOLUME_UP);
    }

    @Bean
    public MessageHandler setVolumeDownMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetCommandMessage.class, deviceManager, personManager, SET_VOLUME_DOWN);
    }

}