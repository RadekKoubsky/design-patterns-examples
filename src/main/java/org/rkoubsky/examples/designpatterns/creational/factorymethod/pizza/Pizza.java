package org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza;

import java.util.LinkedList;
import java.util.List;

/**
 * A Product, all products must implement the same interface so that the classes
 * which use the products can refer to the interface, not to the concrete classes.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public abstract class Pizza {
    protected String name;
    protected String dough;
    protected String sauce;
    protected final List<String> toppings = new LinkedList<String>();

    public void prepare() {
        System.out.println("Preparing: " + this.name);
        System.out.println("Adding dough: " + this.dough);
        System.out.println("Adding sauce: " + this.sauce);
        System.out.println("Adding toppings: ");
        this.toppings.forEach(topping -> System.out.println("   " + topping));
    }

    public void bake() {
        System.out.println("Bake for 25 minutes at 350.");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices.");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box.");
    }

    public String getName() {
        return this.name;
    }
}
