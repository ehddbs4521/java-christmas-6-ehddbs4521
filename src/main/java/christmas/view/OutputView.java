package christmas.view;

import static christmas.view.Output.*;

public class OutputView {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printWelcomeMessage() {
        printMessage(START_PLANNER_MESSAGE.get());
    }

    public void printSaleIntroduceMessage() {
        printMessage(PRE_EVENT_BENEFIT_MESSAGE.get());
    }

    public void printOrderMessage() {
        printMessage(ORDER_LIST_MESSAGE.get());
    }

    public void printBeforeDiscountMessage() {
        printMessage(TOTAL_PRICE_BEFORE_SALE_MESSAGE.get());
    }

    public void printFreebieMessage() {
        printMessage(FREEBIE_MESSAGE.get());
    }

    public void printBenefitMessage() {
        printMessage(BENEFIT_CONTENT_MESSAGE.get());
    }

    public void printTotalBenefitPriceMessage() {
        printMessage(TOTAL_BENEFIT_PRICE_MESSAGE.get());
    }

    public void printAfterDiscountMessage() {
        printMessage(TOTAL_PRICE_AFTER_SALE_MESSAGE.get());
    }

    public void printBadgeMessage() {
        printMessage(EVENT_BADGE_MESSAGE.get());
    }
}
