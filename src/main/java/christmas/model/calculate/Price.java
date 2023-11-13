package christmas.model.calculate;

import christmas.model.order.MenuAndPrice;

import java.util.*;
import java.util.stream.Collectors;

public class Price {
    MenuAndPrice menuAndPrice = new MenuAndPrice();
    Map<String,Integer> order;
    public Price(Map<String,Integer> order) {
        this.order = order;
    }

    public int getBeforeDiscountPrice() {
        List<Integer> price = menuAndPrice.getMenuValues().stream()
                .flatMap(categoryMenu -> categoryMenu.entrySet().stream())
                .filter(menuEntry -> order.containsKey(menuEntry.getKey()))
                .map(menuEntry -> menuEntry.getValue() * order.get(menuEntry.getKey()))
                .collect(Collectors.toList());
        return price.stream().mapToInt(Integer::intValue).sum();

    }

}
