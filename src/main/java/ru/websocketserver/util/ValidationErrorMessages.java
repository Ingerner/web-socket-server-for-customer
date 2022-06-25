package ru.websocketserver.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class ValidationErrorMessages {

    public static final String MESSAGE_NOT_MESSAGE_ID_FIELD = "Не указано поле \"messageId\" в сообщении.";
    public static final String UNSUPPORTED_MESSAGE_ID = "Сообщения с messageId = \"{0}\" не поддерживаются";

    public static final String I_AM_NOT_VALIDATE_CLIENT_ID_VALUE = "Неверный идетификатор клиента, укажите в параметре \"id\": 0 - для устройства, 1 - для пользователя.";
    public static final String I_AM_EMPTY_CLIENT_ID_FIELD = "Идентификатор клиента не может быть пустым. укажите в параметре \"id\": 0 - для устройства, 1 - для пользователя";
    public static final String I_AM_PANEL_NULL_VALUE = "Укажите MAC адрес одного или нескольких устройств в поле \"panel\".";
    public static final String I_AM_PERSON_PANEL_EMPTY_LIST = "Передан пустой список значений для списка панелей. Укажите в поле \"panel\" MAC-одреса устройств, к которым необходимо подключиться.";
    public static final String I_AM_PANEL_PANEL_EMPTY_VALUE = "Поле \"panel\" не может быть пустым.";
    public static final String I_AM_PANEL_PANEL_NOT_ARRAY_FIELD_TYPE = "Для клиента с идентификатором 0, поле panel должно быть массивом.";
    public static final String I_AM_PANEL_PANEL_NOT_PRIMITIVE_FIELD_TYPE = "Для клиента с идентификатором 1, поле panel должно быть строкой.";

}

