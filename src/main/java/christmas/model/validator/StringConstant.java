package christmas.model.validator;

public enum StringConstant {
    COMMA(","),
    HYPHEN("-"),
    WEEKEND("weekend"),
    WEEKDAY("weekday"),
    WON("원"),
    BEVERAGE("음료"),
    SPECIAL("special"),
    NOT_SPECIAL("not-special"),
    CHAMPAGNE("샴페인 1개\n"),
    NOTHING("없음"),
    ;

    private final String str;

    StringConstant(String constant) {
        this.str = constant;
    }

    public String get(){
        return str;
    }
}
