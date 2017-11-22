package org.rkoubsky.examples.designpatterns.behavioral.strategy.quack;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
