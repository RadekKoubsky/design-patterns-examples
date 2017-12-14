package org.rkoubsky.examples.designpatterns.creational.factorymethod.store;

import org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza.Pizza;
import org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza.chicago.ChicagoStyleCheesePizza;
import org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza.chicago.ChicagoStyleClamPizza;
import org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza.chicago.ChicagoStylePepperoniPizza;
import org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza.chicago.ChicagoStyleVeggiePizza;

/**
 * The concrete creator implements the factory method,
 * which is the method that actually produces products.
 * <p>
 * The ConcreteCreator is responsible for creating one or more
 * concrete products. It is the only class that has the knowledge
 * how to create these products.
 * </p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(final String type) {
        final Pizza pizza;
        switch (type) {
            case "cheese":
                pizza = new ChicagoStyleCheesePizza();
                break;
            case "veggie":
                pizza = new ChicagoStyleVeggiePizza();
                break;
            case "clam":
                pizza = new ChicagoStyleClamPizza();
                break;
            case "pepperoni":
                pizza = new ChicagoStylePepperoniPizza();
                break;
            default:
                throw new IllegalArgumentException(
                        String.format("Pizza with type: %s does not exist.", type));
        }
        return pizza;
    }
}
