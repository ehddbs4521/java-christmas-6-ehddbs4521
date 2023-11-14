package christmas.model.validator;

import christmas.model.order.MenuAndPrice;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static christmas.model.validator.ExceptionHandler.error;
import static christmas.model.validator.ExceptionMessage.*;
import static christmas.model.validator.IntegerConstant.*;
import static christmas.model.validator.Regex.CHECK_MENU_AND_COUNT;
import static christmas.model.validator.Regex.CHECK_NUMERIC;
import static christmas.model.validator.StringConstant.BEVERAGE;

public class InputValidator {
    static MenuAndPrice menuAndPrice = new MenuAndPrice();

    private static final Pattern NUMERIC = Pattern.compile(CHECK_NUMERIC.get());
    private static final Pattern MenuAndCount=Pattern.compile(CHECK_MENU_AND_COUNT.get());
    public static void validateNumber(String input) {
        if (NUMERIC.matcher(input).matches()) return;
        error(ORDER_LESS_THAN_ONE_MESSAGE.get());
    }

    public static void validateDate(String input) {
        if (NUMERIC.matcher(input).matches()) return;
        error(WRONG_DATE_MESSAGE.get());
        if(Integer.parseInt(input)>=START_DATE.get() && Integer.parseInt(input)<= END_DATE.get()) return;
        error(WRONG_DATE_MESSAGE.get());
    }

    public static void validateMenuAndCount(List<String> input) {
        long count = input.stream().filter(str -> MenuAndCount.matcher(str).find()).count();
        if(count==(long)input.size()) return;
        error(ORDER_WRONG_MESSAGE.get());
    }

    public static void validateOverTwenty(List<Integer> input) {
        long count = input.stream().filter(num -> (num > MAX_ORDER_COUNT.get())).count();
        if(count==0) return;
        error(ORDER_WRONG_MESSAGE.get());
    }

    public static void validateNotOrderOnlyBeverage(List<String> input) {
        long count = menuAndPrice.menu.get(BEVERAGE.get()).keySet().stream().filter(menu -> menu.equals(input.get(0))).count();
        if(count==0||(count==1||input.size()>0)) return;
        error(ORDER_WRONG_MESSAGE.get());
    }
    public static void validateDuplicateMenu(List<String> input) {
        if(input.stream().distinct().count()==(long) input.size()) return;
        error(ORDER_WRONG_MESSAGE.get());
    }

    public static void validateExistMenu(List<String> input) {
        long count = input.stream()
                .filter(menuName -> menuAndPrice.menu.values().stream().anyMatch(subMap -> subMap.containsKey(menuName)))
                .count();
        if(count==(long) input.size()) return;
        error(ORDER_WRONG_MESSAGE.get());
    }
}
