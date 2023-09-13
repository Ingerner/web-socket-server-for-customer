package ru.websocketserver.config.handlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.PersonManager;
import ru.websocketserver.service.handler.GetMessageHandler;
import ru.websocketserver.service.handler.MessageHandler;

import static ru.websocketserver.util.MessageId.*;

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

    @Bean
    public MessageHandler getWifiMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new GetMessageHandler(personManager, deviceManager, GET_WIFI);
    }

}