package ru.websocketserver.domain.message.incoming;

import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.message.Message;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

import static ru.websocketserver.util.ValidationErrorMessages.DATA_BACKLIGHT_NOT_NULL;
import static ru.websocketserver.util.ValidationErrorMessages.DATA_TEMP_NOT_NULL;
import static ru.websocketserver.util.ValidationErrorMessages.DATA_VOLUME_NOT_NULL;
import static ru.websocketserver.util.ValidationErrorMessages.DATA_WORKING_HOURS_NOT_NULL;
import static ru.websocketserver.util.ValidationErrorMessages.DATA_DATE_TIME_NOT_NULL;


@Getter
@Setter
public class DataIncoming extends Message {

    @NotNull(message = DATA_TEMP_NOT_NULL)
    private Integer temp;

    @NotNull(message = DATA_BACKLIGHT_NOT_NULL)
    private Integer backlight;

    @NotNull(message = DATA_VOLUME_NOT_NULL)
    private Integer volume;

    @NotEmpty(message = DATA_WORKING_HOURS_NOT_NULL)
    private String workingHours;

    @NotEmpty(message = DATA_DATE_TIME_NOT_NULL)
    private LocalDateTime dateTime;

}