package org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza.newyork;

import org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza.Pizza;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        this.name = "NY Style Sauce and Cheese Pizza";
        this.dough = "Thin Crust Dough";
        this.sauce = "Marinara Sauce";
        this.toppings.add("Grated Reggiano Cheese");
    }
}
