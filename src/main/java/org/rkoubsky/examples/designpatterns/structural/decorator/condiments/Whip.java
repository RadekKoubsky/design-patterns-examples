package org.rkoubsky.examples.designpatterns.structural.decorator.condiments;

import org.rkoubsky.examples.designpatterns.structural.decorator.beverages.Beverage;
import org.rkoubsky.examples.designpatterns.structural.decorator.beverages.Size;

import java.math.BigDecimal;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Whip extends CondimentDecorator {
    private final Beverage beverage;

    public Whip(final Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public Size getSize() {
        return this.beverage.getSize();
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", Whip";
    }

    @Override
    public BigDecimal cost() {
        BigDecimal cost = this.beverage.cost();
        switch (getSize()) {
            case SMALL:
                cost = cost.add(new BigDecimal("0.05"));
                break;
            case MEDIUM:
                cost = cost.add(new BigDecimal("0.10"));
                break;
            case LARGE:
                cost = cost.add(new BigDecimal("0.15"));
                break;
        }
        return cost;
    }
}
