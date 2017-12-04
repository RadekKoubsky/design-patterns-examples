package org.rkoubsky.examples.designpatterns.structural.composite.menudemo;

import org.rkoubsky.examples.designpatterns.structural.composite.menudemo.client.Waitress;
import org.rkoubsky.examples.designpatterns.structural.composite.menudemo.component.MenuComponent;
import org.rkoubsky.examples.designpatterns.structural.composite.menudemo.composite.Menu;
import org.rkoubsky.examples.designpatterns.structural.composite.menudemo.leaf.MenuItem;

import java.math.BigDecimal;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class MenuTestDrive {
    public static void main(final String[] args) {
        final MenuComponent allMenus = getAllMenus();
        final Waitress waitress = new Waitress(allMenus);
        waitress.print();
        waitress.printVegetarioanMenu();
    }

    private static MenuComponent getAllMenus() {
        final MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(getPancakeHouseMenu());
        allMenus.add(getDinerMenu());
        allMenus.add(getCafeMenu());
        return allMenus;
    }

    private static MenuComponent getCafeMenu() {
        final MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
        cafeMenu.add(new MenuItem("Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce tomato, and fries", true, new BigDecimal("3.99")));
        cafeMenu.add(new MenuItem("Soup of the day", "A cup of the soup of the day, with a side salad", false,
                new BigDecimal("3.69")));
        cafeMenu.add(new MenuItem("Burrito", "A large burrito, with whole pinto beans, salsa, guacamole", true,
                new BigDecimal("4.29")));
        return cafeMenu;
    }

    private static MenuComponent getDinerMenu() {
        final MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
        dinerMenu.add(new MenuItem("Vegetarion BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true,
                new BigDecimal("2.99")));
        dinerMenu.add(new MenuItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, new BigDecimal("2.99")));
        dinerMenu.add(new MenuItem("Soup of the day", "Soup of the day, with a side of potato salad", false,
                new BigDecimal("3.29")));
        dinerMenu.add(new MenuItem("Hotdog", "A hot dog with saurkraut, relish, onions, topped with cheese", false,
                new BigDecimal("3.05")));
        dinerMenu.add(getDessertMenu());
        return dinerMenu;
    }

    private static MenuComponent getDessertMenu() {
        final MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");
        dessertMenu.add(new MenuItem("Apple Pie", "Apple pie with a flakey crust, topped with vanilla icecream", true,
                new BigDecimal("3.89")));
        return dessertMenu;
    }

    private static MenuComponent getPancakeHouseMenu() {
        final MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        pancakeHouseMenu.add(new MenuItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast.", true,
                new BigDecimal("2.99")));
        pancakeHouseMenu.add(new MenuItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage.", false,
                new BigDecimal("2.99")));
        pancakeHouseMenu.add(new MenuItem("Blueberry Pancakes", "Pancakes made with freash blueberries.", true,
                new BigDecimal("3.49")));
        pancakeHouseMenu.add(new MenuItem("Waffles", "Waffles, with your choice of blueberries or strawberries.", true,
                new BigDecimal("3.59")));
        return pancakeHouseMenu;
    }
}