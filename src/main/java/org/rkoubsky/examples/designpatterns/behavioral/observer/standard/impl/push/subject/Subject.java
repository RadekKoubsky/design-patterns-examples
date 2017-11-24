package org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.subject;

import org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.observers.Observer;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
