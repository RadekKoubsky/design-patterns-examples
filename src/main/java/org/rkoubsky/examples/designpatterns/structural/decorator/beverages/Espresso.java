package org.rkoubsky.examples.designpatterns.structural.decorator.beverages;

import java.math.BigDecimal;

/**
 * The ConcreteComponent is the object we are going to dynamically
 * add new behavior to. It extends the Component ({@link Beverage}).
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Espresso extends Beverage {
    public Espresso() {
        this.description = "Espresso";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal("1.99");
    }
}
