package org.rkoubsky.examples.designpatterns.structural.decorator.beverages;

import java.math.BigDecimal;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        this.description = "House Blend Coffee";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal("0.89");
    }
}
