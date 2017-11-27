package org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.factory;

import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.cheese.Cheese;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.cheese.ReggianoCheese;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.clams.Clams;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.clams.FreshClams;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.dough.Dough;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.dough.ThinCrustDough;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.pepperoni.Pepperoni;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.pepperoni.SlicedPepperoni;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.sauce.MarinaraSauce;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.sauce.Sauce;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.veggies.Garlic;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.veggies.Mushroom;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.veggies.Onion;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.veggies.RedPepper;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.veggies.Veggies;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * A concrete factory. The concrete factories implement the different product families.
 * To create a product, the client uses one of these factories, so it never has to instantiate
 * a product object.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public List<Veggies> createVeggies() {
        final List<Veggies> veggies = new LinkedList<>();
        veggies.add(new Garlic());
        veggies.add(new Onion());
        veggies.add(new Mushroom());
        veggies.add(new RedPepper());
        return Collections.unmodifiableList(veggies);
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }
}
