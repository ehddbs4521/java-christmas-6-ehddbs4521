package christmas.controller;

import christmas.model.order.Order;
import christmas.model.order.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static christmas.model.validator.StringConstant.COMMA;


public class StartController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    VisitDate visitDate;
    Order order;
    private static String WEEKENDORNOT;
    private static String date;

    public void start() {
        outputView.printWelcomeMessage();
        askDate();
        askMenuAndCount();
        outputView.printSaleIntroduceMessage(Integer.parseInt(date));
    }

    private void askDate() {
        while (true) {
            try {
                date = inputView.printVisitDateMessage();
                visitDate = new VisitDate(date);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
        WEEKENDORNOT = visitDate.weekendOrNot(visitDate.getDate());

    }

    private void askMenuAndCount() {
        while (true) {
            try {
                String menuAndCount = inputView.printOrderAndCount();
                new Order(Arrays.asList(menuAndCount.split(COMMA.get())));
                break;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }


}
