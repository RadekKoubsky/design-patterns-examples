package org.rkoubsky.examples.designpatterns.structural.adapter.ducksimulator;

import org.rkoubsky.examples.designpatterns.structural.adapter.ducksimulator.duck.Duck;
import org.rkoubsky.examples.designpatterns.structural.adapter.ducksimulator.duck.MallardDuck;
import org.rkoubsky.examples.designpatterns.structural.adapter.ducksimulator.duck.adapter.TurkeyAdapter;
import org.rkoubsky.examples.designpatterns.structural.adapter.ducksimulator.turkey.WildTurkey;

/**
 * The client sees only the Target interface ({@link Duck})
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class DuckTestDrive {
    public static void main(final String[] args) {
        final Duck mallardDuck = new MallardDuck();
        final WildTurkey turkey = new WildTurkey();
        final Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("\nThe turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nDuck says...");
        testDuck(mallardDuck);

        System.out.println("\nTurkeyAdapter says...");
        testDuck(turkeyAdapter);

    }

    private static void testDuck(final Duck duck) {
        duck.quack();
        duck.fly();
    }
}
