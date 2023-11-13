package christmas.model.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static christmas.model.validator.InputValidator.*;
import static christmas.model.validator.StringConstant.HYPHEN;

public class Order {

    Map<String, Integer> order = new HashMap<>();

    public Order(List<String> orderList) {
        seperateMenuNameAndPrice(orderList);
        validateExistMenu(new ArrayList<>(order.keySet()));
        System.out.println(1);
        validateDuplicateMenu(new ArrayList<>(order.keySet()));
        System.out.println(2);
        validateMenuAndCount(orderList);
        System.out.println(3);

    }

    private void seperateMenuNameAndPrice(List<String> orderList) {
        order = orderList.stream()
                .map(menu -> menu.split("-"))
                .collect(Collectors.toMap(
                        splitMenu -> splitMenu[0],
                        splitMenu -> Integer.parseInt(splitMenu[1]),
                        (existing, replacement) -> replacement
                ));
    }

}
