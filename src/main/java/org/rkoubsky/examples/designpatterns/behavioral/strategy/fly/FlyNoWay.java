package org.rkoubsky.examples.designpatterns.behavioral.strategy.fly;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
