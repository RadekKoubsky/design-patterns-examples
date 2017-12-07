package org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.state;


import org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.gumball.GumballMachine;

import java.util.Random;

/**
 * ConcreteState handles request from the the Context ({@link GumballMachine}).
 * Each ConcreteState provides its own implementation for a request. In this way
 * when the Context changes state, its behavior will change as well.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class HasQuarterState implements State {
    /*
    * We add the transient keyword to the GumballMachine as we do not want to serialize the whole
    * GumballMachine and transfer it with the State object. This tells the JVM
    * not to serialize this field.
    * **/
    private final transient GumballMachine gumballMachine;

    private final Random randomWinner = new Random(System.currentTimeMillis());

    public HasQuarterState(final GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned.");
        this.gumballMachine.setState(this.gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrack() {
        System.out.println("You turned...");
        final int winner = this.randomWinner.nextInt(10);
        if (winner == 0 && this.gumballMachine.getCount() > 1) {
            this.gumballMachine.setState(this.gumballMachine.getWinnerState());
        } else {
            this.gumballMachine.setState(this.gumballMachine.getSoldState());
        }
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
