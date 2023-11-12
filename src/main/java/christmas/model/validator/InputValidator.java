package christmas.model.validator;

import java.util.regex.Pattern;

import static christmas.model.validator.ExceptionHandler.error;
import static christmas.model.validator.ExceptionMessage.ORDER_LESS_THAN_ONE_MESSAGE;
import static christmas.model.validator.Regex.CHECK_NUMERIC;

public class InputValidator {
    private static final Pattern NUMERIC = Pattern.compile(CHECK_NUMERIC.get());
    public void validateNumber(String input) {
        if (NUMERIC.matcher(input).matches()) {
            return;
        }
        error(ORDER_LESS_THAN_ONE_MESSAGE.get());
    }
}
