package org.rkoubsky.examples.designpatterns.creational.factorymethod.store;

import org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza.Pizza;
import org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza.california.CaliforniaStyleCheesePizza;
import org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza.california.CaliforniaStyleClamPizza;
import org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza.california.CaliforniaStylePepperoniPizza;
import org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza.california.CaliforniaStyleVeggiePizza;

/**
 * The concrete creator implements the factory method,
 * which is the method that actually produces products.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class CaliforniaPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(final String type) {
        final Pizza pizza;
        switch (type) {
            case "cheese":
                pizza = new CaliforniaStyleCheesePizza();
                break;
            case "veggie":
                pizza = new CaliforniaStyleVeggiePizza();
                break;
            case "clam":
                pizza = new CaliforniaStyleClamPizza();
                break;
            case "pepperoni":
                pizza = new CaliforniaStylePepperoniPizza();
                break;
            default:
                throw new IllegalArgumentException(String.format("Pizza with type: %s does not exist.", type));
        }
        return pizza;
    }
}
