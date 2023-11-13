package christmas.model.validator;

public enum Regex {
    CHECK_NUMERIC("^[1-9]\\d*"),
    CHECK_MENU_AND_COUNT("^[가-힣]*-\\d+$")
    ;
    private final String message;

    Regex(String message) {
        this.message = message;
    }

    public String get(){
        return message;
    }


}
