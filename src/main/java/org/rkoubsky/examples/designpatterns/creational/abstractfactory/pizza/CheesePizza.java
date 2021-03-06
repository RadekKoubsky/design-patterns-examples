package org.rkoubsky.examples.designpatterns.creational.abstractfactory.pizza;

import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.factory.PizzaIngredientFactory;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class CheesePizza extends Pizza {
    private final PizzaIngredientFactory ingredientFactory;

    public CheesePizza(final String name, final PizzaIngredientFactory ingredientFactory) {
        this.name = name;
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing: " + this.name);
        this.dough = this.ingredientFactory.createDough();
        this.sauce = this.ingredientFactory.createSauce();
        this.cheese = this.ingredientFactory.createCheese();
    }
}
