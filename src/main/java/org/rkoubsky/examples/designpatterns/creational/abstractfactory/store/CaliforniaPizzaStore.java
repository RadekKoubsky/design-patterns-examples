package org.rkoubsky.examples.designpatterns.creational.abstractfactory.store;

import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.factory.CaliforniaPizzaIngredientFactory;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.factory.PizzaIngredientFactory;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.pizza.CheesePizza;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.pizza.ClamPizza;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.pizza.PepperoniPizza;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.pizza.Pizza;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.pizza.VeggiePizza;

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
        final PizzaIngredientFactory ingredientFactory = new CaliforniaPizzaIngredientFactory();
        switch (type) {
            case "cheese":
                pizza = new CheesePizza("California Style Cheese Pizza", ingredientFactory);
                break;
            case "veggie":
                pizza = new VeggiePizza("California Style Veggie Pizza", ingredientFactory);
                break;
            case "clam":
                pizza = new ClamPizza("California Style Clam Pizza", ingredientFactory);
                break;
            case "pepperoni":
                pizza = new PepperoniPizza("California Style Pepperoni Pizza", ingredientFactory);
                break;
            default:
                throw new IllegalArgumentException(String.format("Pizza with type: %s does not exist.", type));
        }
        return pizza;
    }
}
