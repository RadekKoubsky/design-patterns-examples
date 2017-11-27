package org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.factory;

import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.cheese.Cheese;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.cheese.Mozzarella;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.clams.Clams;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.clams.FrozenClams;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.dough.Dough;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.dough.ThickCrustDough;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.pepperoni.Pepperoni;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.pepperoni.SlicedPepperoni;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.sauce.PlumTomatoSauce;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.sauce.Sauce;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.veggies.BlackOlives;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.veggies.EggPlant;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.veggies.Spinach;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.veggies.Veggies;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new Mozzarella();
    }

    @Override
    public List<Veggies> createVeggies() {
        final List<Veggies> veggies = new LinkedList<>();
        veggies.add(new Spinach());
        veggies.add(new BlackOlives());
        veggies.add(new EggPlant());
        return Collections.unmodifiableList(veggies);
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FrozenClams();
    }
}
