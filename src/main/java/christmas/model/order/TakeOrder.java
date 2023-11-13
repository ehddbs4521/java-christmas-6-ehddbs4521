package christmas.model.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static christmas.model.validator.InputValidator.*;
import static christmas.model.validator.StringConstant.HYPHEN;

public class TakeOrder {

    private Map<String, Integer> order = new HashMap<>();
    private List<String> orderList;

    public TakeOrder(List<String> orderList) {
        this.orderList=new ArrayList<>(orderList);
        seperateMenuNameAndPrice(orderList);
        validateExistMenu(new ArrayList<>(order.keySet()));
        validateDuplicateMenu(new ArrayList<>(order.keySet()));
        validateMenuAndCount(orderList);
        validateOverTwenty(new ArrayList<>(order.values()));
        validateNotOrderOnlyBeverage(new ArrayList<>(order.keySet()));

    }

    private void seperateMenuNameAndPrice(List<String> orderList) {
        order = orderList.stream()
                .map(menu -> menu.split(HYPHEN.get()))
                .collect(Collectors.toMap(
                        splitMenu -> splitMenu[0],
                        splitMenu -> Integer.parseInt(splitMenu[1]),
                        (existing, replacement) -> replacement
                ));
    }
    public List<String> getOrderList() {
        return orderList;
    }
    public Map<String,Integer> getOrderMap() {
        return order;
    }

}
