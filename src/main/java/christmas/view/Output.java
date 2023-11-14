package christmas.view;

public enum Output {
    START_PLANNER_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    PRE_EVENT_BENEFIT_MESSAGE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
    ORDER_LIST_MESSAGE("<주문 메뉴>"),
    TOTAL_PRICE_BEFORE_SALE_MESSAGE("\n<할인 전 총주문 금액>"),
    FREEBIE_MESSAGE("\n<증정 메뉴>"),
    BENEFIT_CONTENT_MESSAGE("<혜택 내역>\n"),
    TOTAL_BENEFIT_PRICE_MESSAGE("<총혜택 금액>\n"),
    TOTAL_PRICE_AFTER_SALE_MESSAGE("<할인 후 예상 결제 금액>\n"),
    EVENT_BADGE_MESSAGE("<12월 이벤트 배지>\n"),
    ;

    private final String message;

    Output(String message) {
        this.message = message;
    }

    public String get(){
        return message;
    }
}
