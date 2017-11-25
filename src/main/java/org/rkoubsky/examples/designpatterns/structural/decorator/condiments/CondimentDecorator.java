package org.rkoubsky.examples.designpatterns.structural.decorator.condiments;

import org.rkoubsky.examples.designpatterns.structural.decorator.beverages.Beverage;
import org.rkoubsky.examples.designpatterns.structural.decorator.beverages.Size;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public abstract class CondimentDecorator extends Beverage {

    @Override
    public abstract Size getSize();

    @Override
    public abstract String getDescription();
}
