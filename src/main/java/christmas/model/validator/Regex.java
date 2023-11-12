package christmas.model.validator;

public enum Regex {
    CHECK_NUMERIC("^[1-9]\\d*"),
    ;
    private final String message;

    Regex(String message) {
        this.message = message;
    }

    public String get(){
        return message;
    }


}
