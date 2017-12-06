package org.rkoubsky.examples.designpatterns.behavioral.state.gumballdemo.state;

import org.rkoubsky.examples.designpatterns.behavioral.state.gumballdemo.GumballMachine;

/**
 * ConcreteState handles request from the the Context ({@link GumballMachine}).
 * Each ConcreteState provides its own implementation for a request. In this way
 * when the Context changes state, its behavior will change as well.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class SoldOutState implements State {
    private final GumballMachine gumballMachine;

    public SoldOutState(final GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another a quarter, the machine is sold out.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You can't eject, you haven't inserted a quarter yet.");
    }

    @Override
    public void turnCrack() {
        System.out.println("You turned, but there are no gumballs.");
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed.");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "@" + hashCode();
    }
}
