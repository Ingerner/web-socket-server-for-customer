package ru.websocketserver.util;

import lombok.experimental.UtilityClass;

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

    public static final String ERROR = "Error";

}
