package org.rkoubsky.examples.designpatterns.behavioral.state.gumballdemo.state;

import org.rkoubsky.examples.designpatterns.behavioral.state.gumballdemo.GumballMachine;

/**
 * ConcreteState handles request from the the Context ({@link GumballMachine}).
 * Each ConcreteState provides its own implementation for a request. In this way
 * when the Context changes state, its behavior will change as well.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class SoldState implements State {
    private final GumballMachine gumballMachine;

    public SoldState(final GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we are already giving you a gumball.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank.");
    }

    @Override
    public void turnCrack() {
        System.out.println("Turning twice does not get you another gumball.");
    }

    @Override
    public void dispense() {
        this.gumballMachine.releaseBall();
        if (this.gumballMachine.getCount() > 0) {
            this.gumballMachine.setState(this.gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumballs.");
            this.gumballMachine.setState(this.gumballMachine.getSoldOutState());
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "@" + hashCode();
    }
}
