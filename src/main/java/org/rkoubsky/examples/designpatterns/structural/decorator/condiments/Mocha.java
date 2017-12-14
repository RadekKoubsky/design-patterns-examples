package org.rkoubsky.examples.designpatterns.structural.decorator.condiments;

import org.rkoubsky.examples.designpatterns.structural.decorator.beverages.Beverage;
import org.rkoubsky.examples.designpatterns.structural.decorator.beverages.Size;

import java.math.BigDecimal;

/**
 * The ConcreteDecorator has an instance variable for the thing it decorates;
 * the Component ({@link Beverage}) the Decorator ({@link CondimentDecorator}) wraps.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Mocha extends CondimentDecorator {
    private final Beverage beverage;

    public Mocha(final Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public Size getSize() {
        return this.beverage.getSize();
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", Mocha";
    }

    @Override
    public BigDecimal cost() {
        BigDecimal cost = this.beverage.cost();
        switch (getSize()) {
            case SMALL:
                cost = cost.add(new BigDecimal("0.15"));
                break;
            case MEDIUM:
                cost = cost.add(new BigDecimal("0.20"));
                break;
            case LARGE:
                cost = cost.add(new BigDecimal("0.25"));
                break;
        }
        return cost;
    }
}
