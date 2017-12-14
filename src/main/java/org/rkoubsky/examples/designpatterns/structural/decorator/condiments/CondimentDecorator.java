package org.rkoubsky.examples.designpatterns.structural.decorator.condiments;

import org.rkoubsky.examples.designpatterns.structural.decorator.beverages.Beverage;
import org.rkoubsky.examples.designpatterns.structural.decorator.beverages.Size;

/**
 * Each decorator HAS-A (wraps) a component, which means the decorator
 * has an instance variable that holds a reference to a component ({@link Beverage}).
 * <p>
 * Decorators implement the same interface or abstract class as the component they
 * are going to decorate.
 * </p>
 * <p>
 * The decorator adds its own behavior either before and/or after delegating
 * to the object it decorates to the the rest of the job.
 * </p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public abstract class CondimentDecorator extends Beverage {

    @Override
    public abstract Size getSize();

    @Override
    public abstract String getDescription();
}
