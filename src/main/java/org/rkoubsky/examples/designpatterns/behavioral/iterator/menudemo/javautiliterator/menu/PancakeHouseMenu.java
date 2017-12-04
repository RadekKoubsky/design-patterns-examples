package org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.javautiliterator.menu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The ConcreteAggregate has a collection of objects and implements
 * the method that returns an Iterator for its Collection.
 * <p>
 * Each ConcreteAggregate is responsible for instantiating a ConcreteIterator
 * ({@link ArrayList.Itr}) that can iterate over its collection of objects.
 * </p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class PancakeHouseMenu implements Menu {
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

    @Override
    public Iterator<MenuItem> createIterator() {
        return this.menuItems.iterator();
    }
}
