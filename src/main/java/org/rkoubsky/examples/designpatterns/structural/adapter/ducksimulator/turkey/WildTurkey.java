package org.rkoubsky.examples.designpatterns.structural.adapter.ducksimulator.turkey;

/**
 * A ConcreteAdaptee that implemnts Adaptee interface ({@link Turkey}).
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I am flying a short distance");
    }
}
