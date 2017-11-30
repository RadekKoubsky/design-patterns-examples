package org.rkoubsky.examples.designpatterns.structural.adapter.ducksimulator.turkey;

import org.rkoubsky.examples.designpatterns.structural.adapter.ducksimulator.duck.adapter.TurkeyAdapter;

/**
 * An Adaptee used within an Adapter ({@link TurkeyAdapter}). The Turkey interface does not have
 * the same interface as the {@link org.rkoubsky.examples.designpatterns.structural.adapter.ducksimulator.duck.Duck}.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface Turkey {
    void gobble();

    void fly();
}
