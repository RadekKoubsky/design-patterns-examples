package org.rkoubsky.examples.designpatterns.compound.ducksimilator.decorator;

import org.rkoubsky.examples.designpatterns.compound.ducksimilator.Quackable;
import org.rkoubsky.examples.designpatterns.compound.ducksimilator.observer.Observer;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class QuackCounter implements Quackable {
    private final Quackable duck;
    private static int numberOfQuacks = 0;

    public QuackCounter(final Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        this.duck.quack();
        numberOfQuacks++;
    }

    public static int getNumberOfQuacks() {
        return numberOfQuacks;
    }

    @Override
    public void registerObserver(final Observer observer) {
        this.duck.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        this.duck.notifyObservers();
    }
}
