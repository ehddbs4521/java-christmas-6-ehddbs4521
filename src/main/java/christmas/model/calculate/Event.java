package christmas.model.calculate;

public enum Event {
    CHRISTMAS_EVENT("크리스마스 디데이 할인: "),
    WEEK_EVENT("평일 할인: "),
    WEEKEND_EVENT("주말 할인: "),
    SPECIAL_EVENT("특별 할인: "),
    PRESENTATION_EVENT("증정 할인: "),
    STAR("별"),
    TREE("트리"),
    SANTA("산타"),
    ;
    private final String eventName;

    Event(String eventName) {
        this.eventName = eventName;
    }

    public String get(){
        return eventName;
    }
}
