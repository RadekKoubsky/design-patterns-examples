package org.rkoubsky.examples.designpatterns.compound.ducksimilator;

import org.rkoubsky.examples.designpatterns.compound.ducksimilator.observer.QuackObservable;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface Quackable extends QuackObservable {
    public void quack();
}
