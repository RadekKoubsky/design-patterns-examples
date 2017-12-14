package org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.subject;

import org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.observers.Observer;

/**
 * A Subject interface. Objects use this interface to register as observers
 * and also to remove themselves from being observers.
 * <p>
 * Each subject can have many observers.
 * </p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface Subject {
    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}
