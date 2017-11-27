package org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.factory;

import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.cheese.Cheese;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.clams.Clams;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.dough.Dough;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.pepperoni.Pepperoni;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.sauce.Sauce;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.veggies.Veggies;

import java.util.List;

/**
 * The Abstract Factory defines the interface that all concrete factories
 * must implement, which consists of a set of methods for producing products.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface PizzaIngredientFactory {
    public Dough createDough();

    public Sauce createSauce();

    public Cheese createCheese();

    public List<Veggies> createVeggies();

    public Pepperoni createPepperoni();

    public Clams createClams();
}
