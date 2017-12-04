package org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.javautiliterator.menu;

import java.math.BigDecimal;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class MenuItem {
    private final String name;
    private final String description;
    private final boolean vegeterian;
    private final BigDecimal price;

    public MenuItem(final String name, final String description, final boolean vegeterian, final BigDecimal price) {
        this.name = name;
        this.description = description;
        this.vegeterian = vegeterian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVegeterian() {
        return vegeterian;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
