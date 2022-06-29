package ru.websocketserver.domain.message.common.rpl;

import lombok.Getter;
import lombok.Setter;
import ru.websocketserver.domain.message.outgoing.rpl.RplOutgoing;
import ru.websocketserver.domain.message.outgoing.rpl.RplTimeAlarmOutgoingMessage;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import static ru.websocketserver.util.ValidationErrorMessages.TIME_ALARM_NOT_EMPTY_VALUE;
import static ru.websocketserver.util.ValidationErrorMessages.TIME_ALARM_NOT_VALID_PATTERN;

@Getter
@Setter
public class RplTimeAlarmIncomingMessage extends RplIncomingMessage {

    private static final String DATE_VALIDATION_REGEX = "^\\d\\d\\d\\d:((0\\d)|(1[0-2])):(([0-2]\\d)|(3[0-1]))T(([0-1]\\d)|(2[0-3])):[0-5]\\d:[0-5]\\d$";

    @NotEmpty(message = TIME_ALARM_NOT_EMPTY_VALUE)
    @Pattern(regexp = DATE_VALIDATION_REGEX, message = TIME_ALARM_NOT_VALID_PATTERN)
    private String time;

    @Override
    public RplOutgoing convertToOutgoingMessage(String panel) {
        final RplTimeAlarmOutgoingMessage outgoingMessage = new RplTimeAlarmOutgoingMessage();
        outgoingMessage.setMessageId(getMessageId());
        outgoingMessage.setPanel(panel);
        outgoingMessage.setTime(getTime());
        return outgoingMessage;
    }
}
