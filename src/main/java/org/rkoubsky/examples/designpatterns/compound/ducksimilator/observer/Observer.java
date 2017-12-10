package org.rkoubsky.examples.designpatterns.compound.ducksimilator.observer;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface Observer {
    public void update(QuackObservable duck);
}
