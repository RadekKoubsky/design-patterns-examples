package org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.observers;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface Observer {
    public void update(float temp, float humidity, float pressure);
}
