package ru.websocketserver.util;

import lombok.experimental.UtilityClass;
import ru.websocketserver.domain.Message;
import ru.websocketserver.exception.ValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import java.util.List;
import java.util.Set;

@UtilityClass
public final class ValidationUtil {

    private static final Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public static void validateReceivedMessage(Message message) {
        Set<ConstraintViolation<Message>> violation = validator.validate(message, Default.class);
        if (!violation.isEmpty()) {
            throwValidationException(violation);
        }
    }

    private static void throwValidationException(Set<ConstraintViolation<Message>> constraints) {
        List<String> errors = constraints.stream()
                .map(ConstraintViolation::getMessage)
                .toList();
        throw new ValidationException(errors);
    }

}