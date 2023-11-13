package christmas.model.order;

import java.util.List;

import static christmas.model.validator.StringConstant.WEEKDAY;
import static christmas.model.validator.StringConstant.WEEKEND;

public class Date {
    private String date;

    public Date(String date) {
        this.date = date;
    }

    public String weekendOrNot(String date) {
        if (List.of("1", "2", "8", "9", "15", "16", "22", "23", "29", "30").contains(date)) {
            return WEEKEND.get();
        }
        return WEEKDAY.get();
    }
}
