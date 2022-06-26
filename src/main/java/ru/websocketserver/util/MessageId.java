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

    public static final String ERROR = "Error";

}
