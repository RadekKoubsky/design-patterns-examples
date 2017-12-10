package org.rkoubsky.examples.designpatterns.compound.ducksimilator.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * This class encapsulates the registration and notification code
 * and is composed with a {@link QuackObservable}.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Observable implements QuackObservable {
    private final List<Observer> observers = new LinkedList<>();
    private final QuackObservable duck;

    public Observable(final QuackObservable duck) {
        this.duck = duck;
    }

    @Override
    public void registerObserver(final Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(observer -> observer.update(this.duck));
    }
}
