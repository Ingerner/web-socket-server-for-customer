package ru.websocketserver.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

/**
 * валидация сообщений
 */
@UtilityClass
public final class ValidationErrorMessages {

    public static final String MESSAGE_NOT_MESSAGE_ID_FIELD = "Не указано поле \"messageId\" в сообщении.";
    public static final String UNSUPPORTED_MESSAGE_ID = "Сообщения с messageId = \"{0}\" не поддерживаются";
    public static final String TIME_ALARM_NOT_EMPTY_VALUE = "Значение поля \"time\" не может быть пустым.";
    public static final String TIME_ALARM_NOT_VALID_PATTERN = "Значение поля \"time\" не соотвествует шаблону времени YYYY:MM:DDThh:mm:ss, или указаны не верные значения даты или времени.";
    public static final String VALUE_NOT_NULL = "Значение поле \"value\" не может быть пустым.";
    public static final String VALUE_NOT_VALID_VALUE = "Значение поле \"value\" должно быть от 0 до 100.";
    public static final String MESSAGE_VALUE_MIN_VALUE = "Поле \"value\" не может быть меньше 0.";
    public static final String PICTURE_MODE_VALUE_MAX = "Поле \"value\" не может быть больше 10.";

    public static final String I_AM_NOT_VALIDATE_CLIENT_ID_VALUE = "Неверный идетификатор клиента, укажите в параметре \"id\": 0 - для устройства, 1 - для пользователя.";
    public static final String I_AM_EMPTY_CLIENT_ID_FIELD = "Идентификатор клиента не может быть пустым. укажите в параметре \"id\": 0 - для устройства, 1 - для пользователя";
    public static final String I_AM_PANEL_NULL_VALUE = "Не указано поле \"panel\" укажите MAC адрес одного или нескольких устройств в поле \"panel\".";
    public static final String I_AM_PERSON_PANEL_EMPTY_LIST = "Передан пустой список значений для списка панелей. Укажите в поле \"panel\" MAC-одреса устройств, к которым необходимо подключиться.";
    public static final String I_AM_PANEL_PANEL_EMPTY_VALUE = "Поле \"panel\" не может быть пустым.";
    public static final String I_AM_PANEL_PANEL_NOT_ARRAY_FIELD_TYPE = "Для клиента с идентификатором 0, поле panel должно быть массивом.";
    public static final String I_AM_PANEL_PANEL_NOT_PRIMITIVE_FIELD_TYPE = "Для клиента с идентификатором 1, поле panel должно быть строкой.";

    public static final String DATA_TEMP_NOT_NULL = "Поле \"temp\" не может быть пустым.";
    public static final String DATA_BACKLIGHT_NOT_NULL = "Поле \"backlight\" не может быть пустым.";
    public static final String DATA_VOLUME_NOT_NULL = "Поле \"volume\" не может быть пустым.";
    public static final String DATA_WORKING_HOURS_NOT_NULL = "Поле \"workingHours\" не может быть пустым.";
    public static final String DATA_DATE_TIME_NOT_NULL = "Поле \"dateTime\" не может быть пустым.";

    public static final String SET_PANEL_NOT_EMPTY = "Поле \"panel\" не может быть пустым.";
    public static final String SET_SOURCE_SOURCE_NOT_NULL = "Поле \"source\" не может быть пустым.";
    public static final String SET_SOURCE_SOURCE_NOT_VALID_VALUE = "Поле \"source\" не должно принимать значение меньше 0.";

    public static final String RPL_MESSAGE_USER_SESSION_EMPTY_VALUE = "Поле \"userSession\" не может быть пустым.";
    public static final String RPL_MESSAGE_VALUE_NOT_NULL = "Поле \"value\" не может быть пустым.";
    public static final String RPL_TWO_VAL_VALUE_MAX_VALUE = "Поле \"value\" не может быть больше 1.";


}