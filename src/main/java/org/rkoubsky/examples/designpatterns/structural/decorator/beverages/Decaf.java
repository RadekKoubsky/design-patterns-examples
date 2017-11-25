package org.rkoubsky.examples.designpatterns.structural.decorator.beverages;

import java.math.BigDecimal;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Decaf extends Beverage {
    public Decaf(final Size size) {
        this.description = "Decaf";
        this.size = size;
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal("1.05");
    }
}
