package christmas.model.calculate;

import christmas.model.order.MenuAndPrice;

import java.util.*;
import java.util.stream.Collectors;

import static christmas.controller.StartController.SPECIALORNOT;
import static christmas.controller.StartController.WEEKENDORNOT;
import static christmas.model.calculate.Event.*;
import static christmas.model.validator.IntegerConstant.*;
import static christmas.model.validator.IntegerConstant.CHAMPAGNE;
import static christmas.model.validator.StringConstant.*;

public class Price {
    MenuAndPrice menuAndPrice = new MenuAndPrice();
    Map<String,Integer> order;
    Map<String, Integer> discount = new HashMap<>();

    private int beforeDiscountPrice;
    public Price(Map<String,Integer> order) {
        this.order = order;
    }

    public int getBeforeDiscountPrice() {
        List<Integer> price = menuAndPrice.getMenuValues().stream()
                .flatMap(categoryMenu -> categoryMenu.entrySet().stream())
                .filter(menuEntry -> order.containsKey(menuEntry.getKey()))
                .map(menuEntry -> menuEntry.getValue() * order.get(menuEntry.getKey()))
                .collect(Collectors.toList());
        beforeDiscountPrice = price.stream().mapToInt(Integer::intValue).sum();
        return beforeDiscountPrice;
    }

    public void getAfterDiscountPrice(String date) {
        isDiscountPrice(date);
    }
    private void isDiscountPrice(String date) {
        if(getBeforeDiscountPrice()<MINIMUM_DISCOUNT_PRICE.get()) return;
        if (getChristmasDDayDiscount(date)) christMasDDayDiscount(date);
        if(getWeekDayDiscount(date)) weekDayDiscount();
        if(getWeekendDayDiscount(date)) weekEndDiscount();
        if(getSpecialDayDiscount()) specialDayDiscount();
        if(getPresentation()) presentationDiscount();
    }

    private boolean getChristmasDDayDiscount(String date) {
        if(Integer.parseInt(date)<= CHRISTMAS_DATE.get()) return false;
        return true;
    }

    private void christMasDDayDiscount(String date) {
        discount.put(CHRISTMAS_EVENT.get(),START_DISCOUNT_PRICE.get()+(Integer.parseInt(date)-1)*INCREASE_DISCOUNT_PRICE.get());
    }
    private boolean getWeekDayDiscount(String date) {
        if(WEEKENDORNOT.equals(WEEKDAY.get())) return true;
        return false;
    }

    private void weekDayDiscount() {
        List<Integer> weekDiscount = menuAndPrice.getBeveragetValues().entrySet().stream()
                .filter(menuEntry -> order.containsKey(menuEntry.getKey()))
                .map(menuEntry -> order.get(menuEntry.getKey()) * DAY_DISCOUNT.get())
                .collect(Collectors.toList());
        discount.put(WEEK_EVENT.get(),weekDiscount.stream().mapToInt(Integer::intValue).sum());
    }

    private boolean getWeekendDayDiscount(String date) {
        if(WEEKENDORNOT.equals(WEEKEND.get())) return true;
        return false;
    }

    private void weekEndDiscount() {
        List<Integer> weekEndDiscount = menuAndPrice.getMainValues().entrySet().stream()
                .filter(menuEntry -> order.containsKey(menuEntry.getKey()))
                .map(menuEntry -> order.get(menuEntry.getKey()) * DAY_DISCOUNT.get())
                .collect(Collectors.toList());
        discount.put(WEEKEND_EVENT.get(),weekEndDiscount.stream().mapToInt(Integer::intValue).sum());
    }

    private boolean getSpecialDayDiscount() {
        if(SPECIALORNOT.equals(SPECIAL)) return true;
        return false;
    }

    private void specialDayDiscount() {
        discount.put(SPECIAL_EVENT.get(),SPECIAL_DISCOUNT_PRICE.get());
    }

    private boolean getPresentation() {
        if(beforeDiscountPrice>=PRESENTATION_CONDITION_PRICE.get()) return true;
        return false;
    }

    private void presentationDiscount() {
        discount.put(PRESENTATION_EVENT.get(), CHAMPAGNE.get());
    }

    public Map<String, Integer> getDiscount() {
        return discount;
    }

}
