package org.rkoubsky.examples.designpatterns.structural.decorator.condiments;

import org.rkoubsky.examples.designpatterns.structural.decorator.beverages.Beverage;
import org.rkoubsky.examples.designpatterns.structural.decorator.beverages.Size;

import java.math.BigDecimal;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Soy extends CondimentDecorator {
    private final Beverage beverage;

    public Soy(final Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public Size getSize() {
        return this.beverage.getSize();
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", Soy";
    }

    @Override
    public BigDecimal cost() {
        BigDecimal cost = this.beverage.cost();
        switch (getSize()) {
            case SMALL:
                cost = cost.add(new BigDecimal("0.10"));
                break;
            case MEDIUM:
                cost = cost.add(new BigDecimal("0.15"));
                break;
            case LARGE:
                cost = cost.add(new BigDecimal("0.20"));
                break;
        }
        return cost;
    }
}
