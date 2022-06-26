package ru.websocketserver.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class ErrorMessage {

    public static final String PERSON_DOES_NOT_EXIST = "Пользователь не зарегистрирован";
    public static final String DEVICE_DOES_NOT_EXIST = "Устройство не зарегистрировано";
    public static final String ERROR_SUBSCRIBING_DEVICE = "Не удалось получить данные от устройств со следующими MAC-адресами {0}. Вы начнете получать данные как только они станут активны";
    public static final String PERSON_WAS_REGISTERED = "Пользователь с данной сессией уже зарегистрирован";
    public static final String DEVICE_WITH_SESSION_WAS_REGISTERED = "Устройство с данной сессией уже зарегистрировано";
    public static final String DEVICE_WITH_MAC_ADDRESS_WAS_REGISTERED = "Устройство с MAC-адресом уже зарегистрировано";

}
