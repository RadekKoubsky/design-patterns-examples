package org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.state;

import java.io.Serializable;

/**
 * The State interface defines a common interface for all concrete states;
 * the states all implement the same interface, so they are interchangeable.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface State extends Serializable {
    void insertQuarter();

    void ejectQuarter();

    void turnCrack();

    void dispense();
}
