package org.rkoubsky.examples.designpatterns.creational.factorymethod.store;

import org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza.Pizza;
import org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza.newyork.NYStyleCheesePizza;
import org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza.newyork.NYStyleClamPizza;
import org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza.newyork.NYStylePepperoniPizza;
import org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza.newyork.NYStyleVeggiePizza;

/**
 * The concrete creator implements the factory method,
 * which is the method that actually produces products.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(final String type) {
        final Pizza pizza;
        switch (type) {
            case "cheese":
                pizza = new NYStyleCheesePizza();
                break;
            case "veggie":
                pizza = new NYStyleVeggiePizza();
                break;
            case "clam":
                pizza = new NYStyleClamPizza();
                break;
            case "pepperoni":
                pizza = new NYStylePepperoniPizza();
                break;
            default:
                throw new IllegalArgumentException(String.format("Pizza with type: %s does not exist.", type));
        }
        return pizza;
    }
}
