package christmas.model.validator;

public class ExceptionHandler {
    public static void error(String errorMessage){
        throw new IllegalArgumentException(errorMessage);
    }
}
