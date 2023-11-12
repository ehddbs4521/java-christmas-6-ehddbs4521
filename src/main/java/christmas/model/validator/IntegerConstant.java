package christmas.model.validator;

public enum IntegerConstant {
    START_DATE(1),
    END_DATE(31),
    CHRISTMAS_DATE(25),
    START_DISCOUNT_PRICE(1000),
    INCREASE_DISCOUNT_PRICE(100),
    DAY_DISCOUNT(2023),
    MINIMUM_DISCOUNT_PRICE(10000),
    MAX_ORDER_COUNT(20),
    ;
    private final Integer number;

    IntegerConstant(java.lang.Integer constant) {
        this.number = constant;
    }

    public Integer get(){
        return number;
    }
}
