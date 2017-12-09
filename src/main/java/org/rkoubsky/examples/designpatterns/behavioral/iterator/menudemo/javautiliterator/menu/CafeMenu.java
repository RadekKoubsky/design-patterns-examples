package org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.javautiliterator.menu;

import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * The ConcreteAggregate has a collection of objects and implements
 * the method that returns an Iterator for its Collection.
 * <p>
 * Each ConcreteAggregate is responsible for instantiating a ConcreteIterator
 * ({@link Hashtable.Enumerator}) that can iterate over its collection of objects.
 * </p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class CafeMenu implements Menu {
    private final Hashtable<String, MenuItem> menuItems = new Hashtable<>();

    public CafeMenu() {
        addItem(new MenuItem("Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce tomato, and fries", true, new BigDecimal("3.99")));
        addItem(new MenuItem("Soup of the day", "A cup of the soup of the day, with a side salad", false,
                new BigDecimal("3.69")));
        addItem(new MenuItem("Burrito", "A large burrito, with whole pinto beans, salsa, guacamole", true,
                new BigDecimal("4.29")));
    }

    private void addItem(final MenuItem menuItem) {
        this.menuItems.put(menuItem.getName(), menuItem);
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return this.menuItems.values().iterator();
    }
}
