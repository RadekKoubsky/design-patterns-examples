package org.rkoubsky.examples.designpatterns.creational.abstractfactory;

import org.rkoubsky.examples.designpatterns.creational.abstractfactory.pizza.Pizza;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.store.CaliforniaPizzaStore;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.store.ChicagoPizzaStore;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.store.NYPizzaStore;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.store.PizzaStore;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class PizzaTestDrive {
    public static void main(final String[] args) {
        final PizzaStore nyPizzaStore = new NYPizzaStore();
        final Pizza nyPizza = nyPizzaStore.orderPizza("cheese");
        System.out.printf("Ethan ordered a %s \n\n", nyPizza.toString());

        final PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        final Pizza chicagoPizza = chicagoPizzaStore.orderPizza("veggie");
        System.out.printf("Ethan ordered a %s \n\n", chicagoPizza.toString());

        final PizzaStore californiaPizzaStore = new CaliforniaPizzaStore();
        final Pizza californiaPizza = californiaPizzaStore.orderPizza("clam");
        System.out.printf("Radek ordered a %s \n\n", californiaPizza.toString());
    }
}
