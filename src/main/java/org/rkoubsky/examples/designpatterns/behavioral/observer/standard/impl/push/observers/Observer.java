package org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.observers;

import org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.subject.Subject;

/**
 * All potential observers need to implement the Observer interface.
 * This interface just has one method, {@link Observer#update(float, float, float)},
 * that gets called when the Subject's ({@link Subject}) state changes.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface Observer {
    /**
     * We are using the PUSH approach. The Observable/Subject directly updates the Observer
     * using the update() method everytime the state of the observable changes. If we want to
     * let observers decide what to do during notification, we can let observers pull the observable
     * object with an optional data object and let them decide what they want to do during
     * update() method. To see the PULL approach, see {@link org.rkoubsky.examples.designpatterns.behavioral.observer.java.observable.api.pull}
     * package.
     */
    public void update(float temp, float humidity, float pressure);
}
