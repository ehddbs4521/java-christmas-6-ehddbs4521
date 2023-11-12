package christmas.model.validator;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static christmas.model.validator.ExceptionHandler.error;
import static christmas.model.validator.ExceptionMessage.*;
import static christmas.model.validator.IntegerConstant.END_DATE;
import static christmas.model.validator.IntegerConstant.START_DATE;
import static christmas.model.validator.Regex.CHECK_MENU_AND_COUNT;
import static christmas.model.validator.Regex.CHECK_NUMERIC;

public class InputValidator {
    private static final Pattern NUMERIC = Pattern.compile(CHECK_NUMERIC.get());
    private static final Pattern MenuAndCount=Pattern.compile(CHECK_MENU_AND_COUNT.get());
    public void validateNumber(String input) {
        if (NUMERIC.matcher(input).matches()) return;
        error(ORDER_LESS_THAN_ONE_MESSAGE.get());
    }

    public void validateDate(int input) {
        if(input>=START_DATE.get() && input<= END_DATE.get()) return;
        error(WRONG_DATE_MESSAGE.get());
    }

    public void validateMenuAndCount(List<String> input) {
        long count = input.stream().filter(str -> MenuAndCount.matcher(str).find()).count();
        if(count==(long)input.size()) return;
        error(ORDER_WRONG_MESSAGE.get());
    }

    public void validateDuplicateMenu(List<String> input) {
        if(input.stream().distinct().count()==(long) input.size()) return;
        error(ORDER_WRONG_MESSAGE.get());
    }

}
