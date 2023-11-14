package christmas.controller;

import christmas.model.calculate.Price;
import christmas.model.order.TakeOrder;
import christmas.model.order.VisitDate;
import christmas.model.validator.IntegerConstant;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static christmas.model.calculate.Event.PRESENTATION_EVENT;
import static christmas.model.calculate.Event.SPECIAL_EVENT;
import static christmas.model.validator.IntegerConstant.ZERO;
import static christmas.model.validator.StringConstant.*;


public class StartController {
    DecimalFormat decimalFormat = new DecimalFormat("###,###");
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    VisitDate visitDate;
    TakeOrder takeOrder;
    Price price;
    public static String SPECIALORNOT;
    public static String WEEKENDORNOT;
    private static String date;
    private static int discountPrice;

    public void start() {
        outputView.printWelcomeMessage();
        askDate();
        askMenuAndCount();
        outputView.printSaleIntroduceMessage(Integer.parseInt(date));
        outputView.printOrderMessage();
        showOrderList();
        outputView.printBeforeDiscountMessage();
        showBeforeDiscountPrice();
        price.getAfterDiscountPrice(date);
        outputView.printFreebieMessage();
        price.getBeforeDiscountPrice();
        showPresentation();
        outputView.printBenefitMessage();
        showBenefitList();
        outputView.printTotalBenefitPriceMessage();
        showTotalBenefitPrice();
        outputView.printAfterDiscountMessage();
        showFinalPrice();
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
            } catch (IllegalArgumentException error) {
                outputView.printMessage(error.getMessage());
            }
        }
        SPECIALORNOT = visitDate.specialDayOrNot(visitDate.getDate());
        WEEKENDORNOT = visitDate.weekendOrNot(visitDate.getDate());

    }

    private void askMenuAndCount() {
        while (true) {
            try {
                String menuAndCount = inputView.printOrderAndCount();
                takeOrder = new TakeOrder(getMenuAndCount(menuAndCount));
                break;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    private void showBeforeDiscountPrice() {
        price = new Price(takeOrder.getOrderMap());
        String price = decimalFormat.format(this.price.getBeforeDiscountPrice());
        System.out.println(price + WON.get());

    }

    private void showPresentation() {
        if (price.getDiscount().containsKey(PRESENTATION_EVENT.get())) {
            System.out.println(CHAMPAGNE_ONE.get());
            return;
        }
        System.out.println(NOTHING.get());
    }

    private void showBenefitList() {
        if(price.getDiscount().isEmpty()){
            System.out.println(NOTHING.get());
            return;
        }
        price.getDiscount().entrySet().stream()
                .map(entry -> String.format("%s-%s%s",entry.getKey(),decimalFormat.format(entry.getValue()),WON.get()))
                .forEach(System.out::println);    }
    private void showTotalBenefitPrice() {
        discountPrice = price.getDiscount().values().stream().mapToInt(Integer::intValue).sum();
        if (discountPrice == 0) {
            System.out.println(ZERO.get()+WON.get());
            return;
        }
        System.out.println(String.format("-%s%s",decimalFormat.format(discountPrice),WON.get()));
    }
    private void showFinalPrice() {
        if (excludeChampagnePrice()){
            System.out.println(String.format("%s%s",
                    decimalFormat.format(price.beforeDiscountPrice - discountPrice), WON.get())
            );
            return;
        }
        System.out.println(String.format("%s%s",
                decimalFormat.format(price.beforeDiscountPrice - discountPrice + IntegerConstant.CHAMPAGNE.get()), WON.get())
        );
    }
    private static List<String> getMenuAndCount(String menuAndCount) {
        return Arrays.asList(menuAndCount.split(COMMA.get()));
    }

    private boolean excludeChampagnePrice() {
        if (takeOrder.getOrderList().contains(CHAMPAGNE.get()) && price.getDiscount().containsKey(SPECIAL_EVENT.get())) {
            return true;
        }
        return false;
    }
}
