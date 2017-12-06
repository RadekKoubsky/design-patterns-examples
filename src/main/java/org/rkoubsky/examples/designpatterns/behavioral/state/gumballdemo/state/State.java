package org.rkoubsky.examples.designpatterns.behavioral.state.gumballdemo.state;

/**
 * The State interface defines a common interface for all concrete states;
 * the states all implement the same interface, so they are interchangeable.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface State {
    void insertQuarter();

    void ejectQuarter();

    void turnCrack();

    void dispense();
}
