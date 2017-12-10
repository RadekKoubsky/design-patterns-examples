package org.rkoubsky.examples.designpatterns.compound.ducksimilator.observer;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface QuackObservable {
    public void registerObserver(Observer observer);

    public void notifyObservers();

}
