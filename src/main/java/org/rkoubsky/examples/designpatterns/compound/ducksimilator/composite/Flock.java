package org.rkoubsky.examples.designpatterns.compound.ducksimilator.composite;

import org.rkoubsky.examples.designpatterns.compound.ducksimilator.Quackable;
import org.rkoubsky.examples.designpatterns.compound.ducksimilator.observer.Observer;

import java.util.LinkedList;
import java.util.List;

/**
 * A Composite. We decided to keep the composite's child maintenance
 * methods seperate from the leaf nodes. That os, only {@link Flock}
 * has the {@link Flock#add(Quackable)} method as it does not make sense
 * to add something to a Duck. So this design is safer, but it is less
 * transparent. Now the client has to know that a {@link Quackable} is
 * a {@link Flock} in order to add Quackables to it.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Flock implements Quackable {
    private final List<Quackable> quackers = new LinkedList<>();

    public void add(final Quackable quacker) {
        this.quackers.add(quacker);
    }

    @Override
    public void quack() {
        this.quackers.forEach(Quackable::quack);
    }

    @Override
    public void registerObserver(final Observer observer) {
        this.quackers.forEach(quacker -> quacker.registerObserver(observer));
    }

    /**
     * Each {@link Quackable} does it own notification, thus {@link Flock} does
     * not have to worry about it. This happens when the Flock delegates quack()
     * to each Quackable in the flock, see {@link Flock#quack()}.
     */
    @Override
    public void notifyObservers() {
    }
}
