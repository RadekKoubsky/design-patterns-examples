package org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.state;

import org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.gumball.GumballMachine;

/**
 * ConcreteState handles request from the the Context ({@link GumballMachine}).
 * Each ConcreteState provides its own implementation for a request. In this way
 * when the Context changes state, its behavior will change as well.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class WinnerState implements State {
    /*
    * We add the transient keyword to the GumballMachine as we do not want to serialize the whole
    * GumballMachine and transfer it with the State object. This tells the JVM
    * not to serialize this field.
    * **/
    private final transient GumballMachine gumballMachine;

    public WinnerState(final GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Invalid action on Winner state.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Invalid action on Winner state.");
    }

    @Override
    public void turnCrack() {
        System.out.println("Invalid action on Winner state.");
    }

    @Override
    public void dispense() {
        System.out.println("YOU ARE A WINNER! You get two gumballs for your quarter.");
        this.gumballMachine.releaseBall();
        if (this.gumballMachine.getCount() == 0) {
            this.gumballMachine.setState(this.gumballMachine.getSoldOutState());
        } else {
            this.gumballMachine.releaseBall();
            if (this.gumballMachine.getCount() > 0) {
                this.gumballMachine.setState(this.gumballMachine.getNoQuarterState());
            } else {
                System.out.println("Oops, out of gumballs.");
                this.gumballMachine.setState(this.gumballMachine.getSoldOutState());
            }
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "@" + hashCode();
    }
}
