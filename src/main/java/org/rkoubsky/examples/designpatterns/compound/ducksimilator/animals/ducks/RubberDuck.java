package org.rkoubsky.examples.designpatterns.compound.ducksimilator.animals.ducks;

import org.rkoubsky.examples.designpatterns.compound.ducksimilator.Quackable;
import org.rkoubsky.examples.designpatterns.compound.ducksimilator.observer.Observable;
import org.rkoubsky.examples.designpatterns.compound.ducksimilator.observer.Observer;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class RubberDuck implements Quackable {
    private final Observable observable;

    public RubberDuck() {
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Squeak");
        notifyObservers();
    }

    @Override
    public void registerObserver(final Observer observer) {
        this.observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        this.observable.notifyObservers();
    }

    public String toString() {
        return String.format("%s@%s", this.getClass().getSimpleName(), hashCode());
    }
}
