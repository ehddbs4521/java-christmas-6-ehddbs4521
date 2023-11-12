package christmas.model.order;

import java.util.HashMap;
import java.util.Map;

import static christmas.model.order.MenuName.*;

public class MenuAndPrice {
    private final String APPETIZER = "에피타이저";
    private final String MAIN = "메인";
    private final String DESSERT = "디저트";
    private final String BEVERAGE = "음료";
    Map<String, Integer> appetizerMenu = new HashMap<>();
    Map<String, Integer> mainMenu = new HashMap<>();
    Map<String, Integer> dessertMenu = new HashMap<>();
    Map<String, Integer> beverageMenu = new HashMap<>();
    public Map<String, Map<String, Integer>> menu = new HashMap<>();

    public MenuAndPrice() {
        appetiezerPut();
        mainMenuPut();
        dessertPut();
        beveragePut();
        menuPut();
    }


    private void menuPut() {
        menu.put(APPETIZER, appetizerMenu);
        menu.put(MAIN, mainMenu);
        menu.put(DESSERT, dessertMenu);
        menu.put(BEVERAGE, beverageMenu);
    }

    private void beveragePut() {
        beverageMenu.put(BEVERAGE1.get(), 3000);
        beverageMenu.put(BEVERAGE2.get(), 60000);
        beverageMenu.put(BEVERAGE3.get(), 25000);
    }

    private void dessertPut() {
        dessertMenu.put(DESSERT1.get(), 15000);
        dessertMenu.put(DESSERT2.get(), 5000);
    }

    private void mainMenuPut() {
        mainMenu.put(MAIN1.get(), 55000);
        mainMenu.put(MAIN2.get(), 54000);
        mainMenu.put(MAIN3.get(), 35000);
        mainMenu.put(MAIN4.get(), 25000);
    }

    private void appetiezerPut() {
        appetizerMenu.put(APPETIZER1.get(), 6000);
        appetizerMenu.put(APPETIZER2.get(), 5500);
        appetizerMenu.put(APPETIZER3.get(), 8000);
    }

}
