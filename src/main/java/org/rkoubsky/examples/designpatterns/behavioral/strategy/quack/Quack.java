package org.rkoubsky.examples.designpatterns.behavioral.strategy.quack;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
