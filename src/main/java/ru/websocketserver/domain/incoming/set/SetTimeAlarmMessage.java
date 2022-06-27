package ru.websocketserver.domain.incoming.set;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import static ru.websocketserver.util.ValidationErrorMessages.SET_TIME_ALARM_NOT_EMPTY_VALUE;
import static ru.websocketserver.util.ValidationErrorMessages.SET_TIME_ALARM_NOT_VALID_PATTERN;

@Getter
@Setter
public class SetTimeAlarmMessage extends SetMessage {

    @NotEmpty(message = SET_TIME_ALARM_NOT_EMPTY_VALUE)
    @Pattern(regexp = "^\\d\\d\\d\\d:((0\\d)|(1[0-2])):(([0-2]\\d)|(3[0-1]))T(([0-1]\\d)|(2[0-3])):[0-5]\\d:[0-5]\\d$", message = SET_TIME_ALARM_NOT_VALID_PATTERN)
    private String time;

}