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
    CHAMPAGNE_ONE("샴페인 1개\n"),
    CHAMPAGNE("샴페인"),
    NOTHING("없음\n"),
    ;

    private final String str;

    StringConstant(String constant) {
        this.str = constant;
    }

    public String get(){
        return str;
    }
}
