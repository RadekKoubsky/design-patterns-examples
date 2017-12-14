package org.rkoubsky.examples.designpatterns.structural.decorator.beverages;

import java.math.BigDecimal;

/**
 * The ConcreteComponent is the object we are going to dynamically
 * add new behavior to. It extends the Component ({@link Beverage}).
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class DarkRoast extends Beverage {
    public DarkRoast() {
        this("Dark Roast", Size.MEDIUM);
    }

    public DarkRoast(final String description, final Size size) {
        this.description = description;
        this.size = size;
    }

    public DarkRoast(final Size size) {
        this("Dark Roast", size);
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal("0.99");
    }
}
