package org.rkoubsky.examples.designpatterns.creational.factorymethod;

import org.rkoubsky.examples.designpatterns.creational.factorymethod.pizza.Pizza;
import org.rkoubsky.examples.designpatterns.creational.factorymethod.store.ChicagoPizzaStore;
import org.rkoubsky.examples.designpatterns.creational.factorymethod.store.NYPizzaStore;
import org.rkoubsky.examples.designpatterns.creational.factorymethod.store.PizzaStore;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class PizzaTestDrive {
    public static void main(final String[] args) {
        final PizzaStore nyStore = new NYPizzaStore();
        final PizzaStore chicagoStore = new ChicagoPizzaStore();

        final Pizza nyPizza = nyStore.orderPizza("cheese");
        System.out.printf("Ethan ordered a %s \n\n", nyPizza.getName());

        final Pizza chicagoPizza = chicagoStore.orderPizza("cheese");
        System.out.printf("Joe ordered a %s \n\n", chicagoPizza.getName());
    }
}
