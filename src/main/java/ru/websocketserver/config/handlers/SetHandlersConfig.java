package ru.websocketserver.config.handlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.websocketserver.domain.message.common.set.*;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.PersonManager;
import ru.websocketserver.service.handler.MessageHandler;
import ru.websocketserver.service.handler.SetMessageHandler;

import static ru.websocketserver.util.MessageId.*;

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
        return new SetMessageHandler<>(SetValueMessage.class, deviceManager, personManager, SET_BACKLIGHT);
    }

    @Bean
    public MessageHandler setBrightnessMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetValueMessage.class, deviceManager, personManager, SET_BRIGHTNESS);
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

    @Bean MessageHandler setSettingsIpAddressMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetSettingsMessage.class,deviceManager,personManager, SET_SETTINGS_IP_ADRESS);
    }

    @Bean MessageHandler setSettingsMaskMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetSettingsMessage.class,deviceManager,personManager, SET_SETTINGS_MASK);
    }

    @Bean MessageHandler setSettingsDnsServerMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetSettingsMessage.class,deviceManager,personManager, SET_SETTINGS_SERVER);
    }

    @Bean MessageHandler setSettingsSecurityMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetSettingsMessage.class,deviceManager,personManager, SET_SETTINGS_SECURITY);
    }

    @Bean MessageHandler setSettingsDhcpStaticMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetSettingsMessage.class,deviceManager,personManager, SET_SETTINGS_DHCP_STATIC);
    }

    @Bean MessageHandler setSettingsWifiMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetStatusMessage.class,deviceManager,personManager, SET_SETTINGS_Wifi);
    }

    @Bean MessageHandler setSettingsLanMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetStatusMessage.class,deviceManager,personManager, SET_SETTINGS_LAN);
    }

    @Bean MessageHandler setResetMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetCommandMessage.class,deviceManager,personManager, SET_RESET);
    }

    @Bean MessageHandler setWifiSsidMessageHandler(PersonManager personManager, DeviceManager deviceManager) {
        return new SetMessageHandler<>(SetWifiPasswordMessage.class,deviceManager,personManager, SET_WIFI_SSID);
    }







}