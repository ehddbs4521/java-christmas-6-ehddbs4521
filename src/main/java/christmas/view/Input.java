package christmas.view;

public enum Input {
    VISIT_DATE_MESSAGE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ORDER_MENU_AND_COUNT_MESSAGE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    ;

    private final String message;

    Input(String message) {
        this.message = message;
    }

    public String get(){
        return message;
    }
}
