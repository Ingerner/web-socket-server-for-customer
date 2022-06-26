package ru.websocketserver.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class ErrorMessage {

    public static final String PERSON_DOES_NOT_EXIST = "Пользователь не зарегистрирован";
    public static final String DEVICE_DOES_NOT_EXIST = "Устройство не зарегистрировано";
    public static final String ERROR_SUBSCRIBING_DEVICE = "Не удалось получить данные от устройств со следующими MAC-адресами {0}. Вы начнете получать данные как только они станут активны";

}
