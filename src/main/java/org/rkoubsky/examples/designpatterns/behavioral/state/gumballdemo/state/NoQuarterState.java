package org.rkoubsky.examples.designpatterns.behavioral.state.gumballdemo.state;

import org.rkoubsky.examples.designpatterns.behavioral.state.gumballdemo.GumballMachine;

/**
 * ConcreteState handles request from the the Context ({@link GumballMachine}).
 * Each ConcreteState provides its own implementation for a request. In this way
 * when the Context changes state, its behavior will change as well.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class NoQuarterState implements State {
    private final GumballMachine gumballMachine;

    public NoQuarterState(final GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        this.gumballMachine.setState(this.gumballMachine.getHasQuarterState());
        System.out.println("You inserted a quarter.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter.");
    }

    @Override
    public void turnCrack() {
        System.out.println("You turned, but there is no quarter.");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first.");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "@" + hashCode();
    }
}
