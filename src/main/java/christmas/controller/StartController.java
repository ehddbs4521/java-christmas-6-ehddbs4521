package christmas.controller;

import christmas.model.calculate.Price;
import christmas.model.order.TakeOrder;
import christmas.model.order.VisitDate;
import christmas.model.validator.IntegerConstant;
import christmas.model.validator.StringConstant;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static christmas.model.calculate.Event.*;
import static christmas.model.validator.IntegerConstant.*;
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
        askDateAndMenu();
        orderResult();
        priceResult();
        presentationResult();
        benefitResult();
        totalBenefitPriceResult();
        finalPriceResult();
        badgeResult();
    }

    private void badgeResult() {
        outputView.printBadgeMessage();
        showBadge();
    }

    private void finalPriceResult() {
        outputView.printAfterDiscountMessage();
        showFinalPrice();
    }

    private void totalBenefitPriceResult() {
        outputView.printTotalBenefitPriceMessage();
        showTotalBenefitPrice();
    }

    private void benefitResult() {
        outputView.printBenefitMessage();
        showBenefitList();
    }

    private void presentationResult() {
        outputView.printFreebieMessage();
        showPresentation();
    }

    private void priceResult() {
        outputView.printBeforeDiscountMessage();
        showBeforeDiscountPrice();
        price.getAfterDiscountPrice(date);
        price.getBeforeDiscountPrice();
    }

    private void orderResult() {
        outputView.printOrderMessage();
        showOrderList();
    }

    private void askDateAndMenu() {
        outputView.printWelcomeMessage();
        askDate();
        askMenuAndCount();
        outputView.printSaleIntroduceMessage(Integer.parseInt(date));
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
        if (plusChampagnePrice()){
            System.out.println(String.format("%s%s",
                    decimalFormat.format(price.beforeDiscountPrice - discountPrice), WON.get())
            );
            return;
        }
        System.out.println(String.format("%s%s",
                decimalFormat.format(price.beforeDiscountPrice - discountPrice + IntegerConstant.CHAMPAGNE_PRICE.get()), WON.get())
        );
    }
    private boolean plusChampagnePrice() {
        if (orderChampagne() && price.getDiscount().containsKey(SPECIAL_EVENT.get())) return false;
        if(orderChampagne() && !price.getDiscount().containsKey(SPECIAL_EVENT.get())) return true;
        if(!orderChampagne()&&price.getDiscount().containsKey(SPECIAL_EVENT.get())) return false;
        return true;
    }

    private boolean orderChampagne() {
        if(takeOrder.getOrderList().contains(CHAMPAGNE.get())) return true;
        return false;
    }

    private void showBadge() {
        if (noBadge()) return;
        if (starBadge()) return;
        if (treeBadge()) return;
        santaBadge();
    }

    private static void santaBadge() {
        if (discountPrice >= TWENTY_THOUSAND.get()) {
            System.out.println(SANTA.get());
        }
    }

    private static boolean treeBadge() {
        if (discountPrice >= TEN_THOUSAND.get() && discountPrice < TWENTY_THOUSAND.get()) {
            System.out.println(TREE.get());
            return true;
        }
        return false;
    }

    private static boolean starBadge() {
        if (discountPrice >= FIVE_THOUSAND.get() && discountPrice < TEN_THOUSAND.get()) {
            System.out.println(STAR.get());
            return true;
        }
        return false;
    }

    private static boolean noBadge() {
        if (discountPrice < FIVE_THOUSAND.get()) {
            System.out.println(NOTHING.get());
            return true;
        }
        return false;
    }

    private static List<String> getMenuAndCount(String menuAndCount) {
        return Arrays.asList(menuAndCount.split(COMMA.get()));
    }
}
