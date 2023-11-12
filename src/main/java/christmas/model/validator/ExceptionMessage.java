package christmas.model.validator;

public enum ExceptionMessage {
    NOT_EXIST_MENU_MESSAGE("\"[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.\""),
    ORDER_LESS_THAN_ONE_MESSAGE("\"[ERROR] 메뉴의 개수는 1 이상의 숫자만 입력되도록 해주세요.\""),
    ORDER_WRONG_MESSAGE("\"[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.\""),
    WRONG_DATE_MESSAGE("\"[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.\""),
    ;
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String get(){
        return message;
    }
}
