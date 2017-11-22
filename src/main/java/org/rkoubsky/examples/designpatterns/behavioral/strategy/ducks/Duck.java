package org.rkoubsky.examples.designpatterns.behavioral.strategy.ducks;

import org.rkoubsky.examples.designpatterns.behavioral.strategy.fly.FlyBehavior;
import org.rkoubsky.examples.designpatterns.behavioral.strategy.quack.QuackBehavior;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public abstract class Duck {
    protected final FlyBehavior flyBehavior;
    protected final QuackBehavior quackBehavior;

    protected Duck(FlyBehavior flyBehavior,
            QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void swim(){
        System.out.println("All ducks float, even decoys!");
    }

    public abstract void display();
}
