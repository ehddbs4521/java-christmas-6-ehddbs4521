package christmas;

import christmas.controller.StartController;
import christmas.model.validator.InputValidator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StartController startController = new StartController();
        startController.start();
    }
}
