package org.rkoubsky.examples.designpatterns.structural.decorator.beverages;

import java.math.BigDecimal;

/**
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
