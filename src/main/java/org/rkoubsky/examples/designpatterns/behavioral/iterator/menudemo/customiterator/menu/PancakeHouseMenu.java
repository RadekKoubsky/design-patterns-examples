package org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.customiterator.menu;

import org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.customiterator.iterator.Iterator;
import org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.customiterator.iterator.PancakeHouseMenuIterator;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class PancakeHouseMenu {
    private final ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

    public PancakeHouseMenu() {
        addItem(new MenuItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast.", true,
                new BigDecimal("2.99")));
        addItem(new MenuItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage.", false,
                new BigDecimal("2.99")));
        addItem(new MenuItem("Blueberry Pancakes", "Pancakes made with freash blueberries.", true,
                new BigDecimal("3.49")));
        addItem(new MenuItem("Waffles", "Waffles, with your choice of blueberries or strawberries.", true,
                new BigDecimal("3.59")));
    }

    public void addItem(final MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

    public Iterator<MenuItem> iterator() {
        return new PancakeHouseMenuIterator(this.menuItems);
    }
}
