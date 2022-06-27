package ru.websocketserver.config.handlers;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.PersonManager;
import ru.websocketserver.service.message.GetMessageHandler;
import ru.websocketserver.service.message.MessageHandler;

import static ru.websocketserver.util.MessageId.GET_AUTO_SOURCE_SWITCH;
import static ru.websocketserver.util.MessageId.GET_BACKLIGHT;
import static ru.websocketserver.util.MessageId.GET_BRIGHTNESS;
import static ru.websocketserver.util.MessageId.GET_PICTURE_MODE;
import static ru.websocketserver.util.MessageId.GET_SATURATION;
import static ru.websocketserver.util.MessageId.GET_SHARPNESS;
import static ru.websocketserver.util.MessageId.GET_SLEEP;
import static ru.websocketserver.util.MessageId.GET_SOURCE;
import static ru.websocketserver.util.MessageId.GET_TIME_ALARM;
import static ru.websocketserver.util.MessageId.GET_VOLUME;

@Configuration
public class GetHandlersConfig {

    @Bean
    public MessageHandler getSourceMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new GetMessageHandler(personManager, deviceManager, GET_SOURCE);
    }

    @Bean
    public MessageHandler getSleepMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new GetMessageHandler(personManager, deviceManager, GET_SLEEP);
    }

    @Bean
    public MessageHandler getTimeAlarmMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new GetMessageHandler(personManager, deviceManager, GET_TIME_ALARM);
    }

    @Bean
    public MessageHandler getAutoSourceSwitchMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new GetMessageHandler(personManager, deviceManager, GET_AUTO_SOURCE_SWITCH);
    }

    @Bean
    public MessageHandler getBacklightMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new GetMessageHandler(personManager, deviceManager, GET_BACKLIGHT);
    }

    @Bean
    public MessageHandler getBrightnessMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new GetMessageHandler(personManager, deviceManager, GET_BRIGHTNESS);
    }

    @Bean
    public MessageHandler getPictureModeMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new GetMessageHandler(personManager, deviceManager, GET_PICTURE_MODE);
    }

    @Bean
    public MessageHandler getSaturationMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new GetMessageHandler(personManager, deviceManager, GET_SATURATION);
    }

    @Bean
    public MessageHandler getSharpnessMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new GetMessageHandler(personManager, deviceManager, GET_SHARPNESS);
    }

    @Bean
    public MessageHandler getVolumeMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new GetMessageHandler(personManager, deviceManager, GET_VOLUME);
    }

}