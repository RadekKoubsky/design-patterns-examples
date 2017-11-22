package org.rkoubsky.examples.designpatterns.behavioral.strategy.fly;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I am flying with wings!!");
    }
}
