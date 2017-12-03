package org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.menu;

import org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.iterator.DinerMenuIterator;
import org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.iterator.Iterator;

import java.math.BigDecimal;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class DinerMenu {
    private static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;
    private final MenuItem[] menuItems = new MenuItem[MAX_ITEMS];

    public DinerMenu() {
        addItem(new MenuItem("Vegetarion BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true,
                new BigDecimal("2.99")));
        addItem(new MenuItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, new BigDecimal("2.99")));
        addItem(new MenuItem("Soup of the day", "Soup of the day, with a side of potato salad", false,
                new BigDecimal("3.29")));
        addItem(new MenuItem("Hotdog", "A hot dog with saurkraut, relish, onions, topped with cheese", false,
                new BigDecimal("3.05")));
    }

    public void addItem(final MenuItem menuItem) {
        if (this.numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full! Can'd add item to menu.");
        } else {
            this.menuItems[this.numberOfItems] = menuItem;
            this.numberOfItems++;
        }
    }

    public Iterator<MenuItem> iterator() {
        return new DinerMenuIterator(this.menuItems);
    }
}
