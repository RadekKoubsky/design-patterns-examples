package org.rkoubsky.examples.designpatterns.behavioral.state.gumballdemo;

import org.rkoubsky.examples.designpatterns.behavioral.state.gumballdemo.state.HasQuarterState;
import org.rkoubsky.examples.designpatterns.behavioral.state.gumballdemo.state.NoQuarterState;
import org.rkoubsky.examples.designpatterns.behavioral.state.gumballdemo.state.SoldOutState;
import org.rkoubsky.examples.designpatterns.behavioral.state.gumballdemo.state.SoldState;
import org.rkoubsky.examples.designpatterns.behavioral.state.gumballdemo.state.State;
import org.rkoubsky.examples.designpatterns.behavioral.state.gumballdemo.state.WinnerState;

/**
 * This class is a Context. The Context is the class that can have a number
 * of internal states ({@link State}). Whenever the request is made on the Context
 * it is delegated to the state to handle.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class GumballMachine {
    private final State soldOutState;
    private final State noQuarterState;
    private final State hasQuarterState;
    private final State soldState;
    private final State winnerState;

    private State state;
    int count = 0;

    public GumballMachine(final int numberOfGumballs) {
        this.soldOutState = new SoldOutState(this);
        this.noQuarterState = new NoQuarterState(this);
        this.hasQuarterState = new HasQuarterState(this);
        this.soldState = new SoldState(this);
        this.winnerState = new WinnerState(this);
        this.count = numberOfGumballs;
        if (numberOfGumballs > 0) {
            this.state = this.noQuarterState;
        } else {
            this.state = this.soldOutState;
        }
    }

    public void insertQuarter() {
        this.state.insertQuarter();
    }

    public void ejectQuarter() {
        this.state.ejectQuarter();
    }

    public void turnCrank() {
        this.state.turnCrack();
        if (this.state.equals(getSoldState()) || this.state.equals(getWinnerState())) {
            this.state.dispense();
        }
    }

    /**
     * This method allows other objects (like our {@link State} objects) to transition
     * the machine to a different state
     */
    public void setState(final State state) {
        this.state = state;
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot.");
        if (this.count != 0) {
            this.count--;
        }
    }

    public State getSoldOutState() {
        return this.soldOutState;
    }

    public State getNoQuarterState() {
        return this.noQuarterState;
    }

    public State getHasQuarterState() {
        return this.hasQuarterState;
    }

    public State getSoldState() {
        return this.soldState;
    }

    public State getWinnerState() {
        return this.winnerState;
    }

    public int getCount() {
        return this.count;
    }

    public State getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "soldOutState=" + this.soldOutState +
                ", noQuarterState=" + this.noQuarterState +
                ", hasQuarterState=" + this.hasQuarterState +
                ", soldState=" + this.soldState +
                ", winnerState=" + this.winnerState +
                ", state=" + this.state +
                ", count=" + this.count +
                '}';
    }
}
