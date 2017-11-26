package org.rkoubsky.examples.designpatterns.creational.factorymethod.store;

import org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza.Pizza;

/**
 * The creator is a class that contains the implementations for all of the methods
 * to manipulate products, except for the factory method: {@link PizzaStore#createPizza(String)}
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public abstract class PizzaStore {
    public Pizza orderPizza(final String type) {
        final Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    /**
     * The abstract factory method is what all Creator subclasses must implement
     */
    protected abstract Pizza createPizza(String type);
}
