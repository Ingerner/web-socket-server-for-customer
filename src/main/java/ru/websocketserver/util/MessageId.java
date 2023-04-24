package ru.websocketserver.util;

import lombok.experimental.UtilityClass;

/**
 * класс описывающий идентификаторы сообщений
 */
@UtilityClass
public final class MessageId {

    public static final String I_AM = "Iam";
    public static final String DATA = "Data";

    public static final String SET_SOURCE = "setSource";
    public static final String SET_REBOOT = "setReboot";
    public static final String SET_SHUTDOWN = "setShutdown";
    public static final String SET_SLEEP = "setSleep";
    public static final String SET_WAKEUP = "setWakeUp";
    public static final String SET_TIME_ALARM = "setTimeAlarm";
    public static final String SET_AUTO_SOURCE_SWITCH = "setAutoSourceSwitch";
    public static final String SET_OPS_START = "setOpsStart";
    public static final String SET_BACKLIGHT = "setBacklight";
    public static final String SET_BRIGHTNESS = "setBrightness";
    public static final String SET_PICTURE_MODE = "setPictureMode";
    public static final String SET_SATURATION = "setSaturation";
    public static final String SET_SHARPNESS = "setSharpness";
    public static final String SET_VOLUME = "setVolume";
    public static final String SET_VOLUME_UP = "setVolumeUp";
    public static final String SET_VOLUME_DOWN = "setVolumeDown";
    public static final String SET_TURNING_DEVICE = "setTurningDevice";
    public static final String SET_SETTINGS_IP_ADRESS = "setSettingsIpAddress";
    public static final String SET_SETTINGS_MASK = "setSettingsMask";
    public static final String SET_SETTINGS_SERVER = "setSettingsDnsServer";
    public static final String SET_SETTINGS_SECURITY = "setSettingsSecurity";
    public static final String SET_SETTINGS_DHCP_STATIC= "setSettingsDhcpStatic";
    public static final String SET_SETTINGS_Wifi = "setSettingsWifi";
    public static final String SET_SETTINGS_LAN = "setSettingsLan";
    public static final String SET_RESET = "setReset";
    public static final String SET_WIFI_SSID = "setWifiSsid";




    public static final String GET_SOURCE = "getSource";
    public static final String GET_SLEEP = "getSleep";
    public static final String GET_TIME_ALARM = "getTimeAlarm";
    public static final String GET_AUTO_SOURCE_SWITCH = "getAutoSourceSwitch";
    public static final String GET_BACKLIGHT = "getBacklight";
    public static final String GET_BRIGHTNESS = "getBrightness";
    public static final String GET_PICTURE_MODE = "getPictureMode";
    public static final String GET_SATURATION = "getSaturation";
    public static final String GET_SHARPNESS = "getSharpness";
    public static final String GET_VOLUME = "getVolume";

    public static final String RPL_SOURCE = "rplSource";
    public static final String RPL_SLEEP = "rplSleep";
    public static final String RPL_TIME_ALARM = "rplTimeAlarm";
    public static final String RPL_AUTO_SOURCE_SWITCH = "rplAutoSourceSwitch";
    public static final String RPL_BACKLIGHT = "rplBacklight";
    public static final String RPL_BRIGHTNESS = "rplBrightness";
    public static final String RPL_PICTURE_MODE = "rplPictureMode";
    public static final String RPL_SATURATION = "rplSaturation";
    public static final String RPL_SHARPNESS = "rplSharpness";
    public static final String RPL_VOLUME = "rplVolume";

    public static final String ERROR = "Error";

}
