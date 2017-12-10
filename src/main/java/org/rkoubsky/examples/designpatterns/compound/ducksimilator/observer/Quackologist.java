package org.rkoubsky.examples.designpatterns.compound.ducksimilator.observer;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Quackologist implements Observer {
    @Override
    public void update(final QuackObservable duck) {
        System.out.printf("Quackologist: %s just quacked.\n", duck);
    }
}
