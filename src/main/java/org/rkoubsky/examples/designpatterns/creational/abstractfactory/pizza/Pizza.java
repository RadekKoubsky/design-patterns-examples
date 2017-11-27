package org.rkoubsky.examples.designpatterns.creational.abstractfactory.pizza;

import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.cheese.Cheese;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.clams.Clams;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.dough.Dough;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.pepperoni.Pepperoni;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.sauce.Sauce;
import org.rkoubsky.examples.designpatterns.creational.abstractfactory.ingredients.veggies.Veggies;

import java.util.LinkedList;
import java.util.List;

/**
 * The clients of the abstract factory are the concrete instances of this
 * Pizza abstract class.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public abstract class Pizza {
    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected List<Veggies> veggies = new LinkedList<>();
    protected Cheese cheese;
    protected Pepperoni pepperoni;
    protected Clams clam;

    public abstract void prepare();

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

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + (this.name == null ? "UnknownPizza" : this.name) + '\'' +
                ", dough=" + (this.dough == null ? "NoDough" : this.dough.getClass().getSimpleName()) +
                ", sauce=" + (this.sauce == null ? "NoSauce" : this.sauce.getClass().getSimpleName()) +
                ", veggies=" + printVeggies() +
                ", cheese=" + this.cheese.getClass().getSimpleName() +
                ", pepperoni=" + (this.pepperoni == null ? "NoPepperoni" : this.pepperoni.getClass().getSimpleName()) +
                ", clam=" + (this.clam == null ? "NoClam" : this.clam.getClass().getSimpleName()) +
                '}';
    }

    private String printVeggies() {
        if (this.veggies.isEmpty()) {
            return "NoVeggies";
        }
        final StringBuilder sb = new StringBuilder();
        this.veggies.forEach(veggie -> {
            if (veggie.equals(this.veggies.get(this.veggies.size() - 1))) {
                sb.append(veggie.getClass().getSimpleName());
            } else {
                sb.append(veggie.getClass().getSimpleName()).append(", ");
            }
        });
        return sb.toString();
    }
}
