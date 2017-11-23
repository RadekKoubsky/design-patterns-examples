package org.rkoubsky.examples.designpatterns.behavioral.observer.subject;

import org.rkoubsky.examples.designpatterns.behavioral.observer.observers.Observer;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
