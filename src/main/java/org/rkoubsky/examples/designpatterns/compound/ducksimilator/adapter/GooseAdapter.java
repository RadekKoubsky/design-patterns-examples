package org.rkoubsky.examples.designpatterns.compound.ducksimilator.adapter;

import org.rkoubsky.examples.designpatterns.compound.ducksimilator.Quackable;
import org.rkoubsky.examples.designpatterns.compound.ducksimilator.animals.Goose;
import org.rkoubsky.examples.designpatterns.compound.ducksimilator.observer.Observer;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class GooseAdapter implements Quackable {
    private final Goose goose;

    public GooseAdapter(final Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        this.goose.honk();
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}
