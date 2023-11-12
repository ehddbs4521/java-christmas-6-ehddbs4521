package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import static christmas.view.Input.ORDER_MENU_AND_COUNT_MESSAGE;
import static christmas.view.Input.VISIT_DATE_MESSAGE;

public class InputView {
    public void printMessage(String outputMessage){
        System.out.println(outputMessage);
    }

    public String printVisitDateMessage() {
        printMessage(VISIT_DATE_MESSAGE.get());
        return Console.readLine();
    }

    public String printOrderAndCount() {
        printMessage(ORDER_MENU_AND_COUNT_MESSAGE.get());
        return Console.readLine();
    }

}
