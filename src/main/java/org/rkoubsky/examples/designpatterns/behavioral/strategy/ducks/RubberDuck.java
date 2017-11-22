package org.rkoubsky.examples.designpatterns.behavioral.strategy.ducks;

import org.rkoubsky.examples.designpatterns.behavioral.strategy.fly.FlyBehavior;
import org.rkoubsky.examples.designpatterns.behavioral.strategy.quack.QuackBehavior;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class RubberDuck extends Duck {
    public RubberDuck(FlyBehavior flyBehavior,
            QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    @Override
    public void display() {
        System.out.println("I am a Rubber duck.");
    }
}
