package christmas.controller;

import christmas.model.order.TakeOrder;
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
    TakeOrder takeOrder;
    private static String WEEKENDORNOT;
    private static String date;

    public void start() {
        outputView.printWelcomeMessage();
        askDate();
        askMenuAndCount();
        outputView.printSaleIntroduceMessage(Integer.parseInt(date));
        outputView.printOrderMessage();
        showOrderList();
    }

    private void showOrderList() {
        takeOrder.getOrderList().stream().forEach(System.out::println);
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
                takeOrder=new TakeOrder(getMenuAndCount(menuAndCount));
                break;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    private static List<String> getMenuAndCount(String menuAndCount) {
        return Arrays.asList(menuAndCount.split(COMMA.get()));
    }

}
