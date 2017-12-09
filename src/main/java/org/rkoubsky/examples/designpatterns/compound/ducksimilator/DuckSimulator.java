package org.rkoubsky.examples.designpatterns.compound.ducksimilator;

import org.rkoubsky.examples.designpatterns.compound.ducksimilator.abstractfactory.AbstractDuckFactory;
import org.rkoubsky.examples.designpatterns.compound.ducksimilator.abstractfactory.CountingDuckFactory;
import org.rkoubsky.examples.designpatterns.compound.ducksimilator.composite.Flock;
import org.rkoubsky.examples.designpatterns.compound.ducksimilator.decorator.QuackCounter;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class DuckSimulator {
    public static void main(final String[] args) {
        final DuckSimulator simulator = new DuckSimulator();
        final AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }

    private void simulate(final AbstractDuckFactory duckFactory) {
        final Quackable mallardDuck = duckFactory.createMallardDuck();
        final Quackable redheadDuck = duckFactory.createRedheadDuck();
        final Quackable duckCall = duckFactory.createDuckCall();
        final Quackable rubberDuck = duckFactory.createRubberDuck();
        final Quackable goose = duckFactory.createGooseDuck();

        System.out.println("\nDuck Simulator: With Composite - Flocks");

        final Flock flockOfDucks = new Flock();
        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(goose);

        final Flock flockOfMallards = new Flock();
        flockOfMallards.add(duckFactory.createMallardDuck());
        flockOfMallards.add(duckFactory.createMallardDuck());
        flockOfMallards.add(duckFactory.createMallardDuck());
        flockOfMallards.add(duckFactory.createMallardDuck());

        flockOfDucks.add(flockOfMallards);

        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);

        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
        simulate(flockOfMallards);

        System.out.printf("The ducks quacked %s times.", QuackCounter.getNumberOfQuacks());
    }

    private void simulate(final Quackable duck) {
        duck.quack();
    }
}
