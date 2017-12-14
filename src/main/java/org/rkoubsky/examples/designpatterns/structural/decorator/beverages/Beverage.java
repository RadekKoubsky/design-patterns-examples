package org.rkoubsky.examples.designpatterns.structural.decorator.beverages;

import java.math.BigDecimal;

/**
 * A Component. Each component can be used on its own,
 * or wrapped by a decorator.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public abstract class Beverage {
    protected String description = "UnKnown Beverage";
    protected Size size = Size.MEDIUM;

    public Size getSize() {
        return this.size;
    }

    public String getDescription() {
        return this.description;
    }

    public abstract BigDecimal cost();
}
