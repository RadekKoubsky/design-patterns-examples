package org.rkoubsky.examples.designpatterns.structural.adapter.ducksimulator.duck;

/**
 * The ConcreteTarget that implements the Target interface ({@link Duck}).
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I am flying.");
    }
}
