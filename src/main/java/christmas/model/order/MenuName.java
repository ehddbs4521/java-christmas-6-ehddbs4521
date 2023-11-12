package christmas.model.order;

public enum MenuName {
    APPETIZER1("양송이수프"),
    APPETIZER2("타파스"),
    APPETIZER3("시저샐러드"),
    MAIN1("티본스테이크"),
    MAIN2("바비큐립"),
    MAIN3("해산물파스타"),
    MAIN4("크리스마스파스타"),
    DESSERT1("초코케이크"),
    DESSERT2("아이스크림"),
    BEVERAGE1("제로콜라"),
    BEVERAGE2("레드와인"),
    BEVERAGE3("샴페인"),
    ;
    private final String menuName;

    MenuName(String menuName) {
        this.menuName = menuName;
    }

    public String get(){
        return menuName;
    }
}
