package org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.gumball;

import org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.state.HasQuarterState;
import org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.state.NoQuarterState;
import org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.state.SoldOutState;
import org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.state.SoldState;
import org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.state.State;
import org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.state.WinnerState;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * This is an implementation of the remote service. It subclasses the {@link UnicastRemoteObject}
 * in order to have the ability to act as a remote service.
 * <p>
 * It also needs to implement the remote interface {@link GumballMachineRemote}
 * </p>
 * <p>
 * A RealSubject. It is usually the object that does most of the real work;
 * the Proxy controls access to it.
 * </p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {
    private final State soldOutState;
    private final State noQuarterState;
    private final State hasQuarterState;
    private final State soldState;
    private final State winnerState;
    private final String location;

    private State state;
    int count = 0;

    /**
     * The constructor needs to throw a {@link RemoteException} because the constructor of
     * the superclass throws the exception.
     */
    public GumballMachine(final String location, final int numberOfGumballs) throws RemoteException {
        this.location = location;
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

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public String getLocation() {
        return this.location;
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "soldOutState=" + this.soldOutState +
                ", noQuarterState=" + this.noQuarterState +
                ", hasQuarterState=" + this.hasQuarterState +
                ", soldState=" + this.soldState +
                ", winnerState=" + this.winnerState +
                ", location='" + this.location + '\'' +
                ", state=" + this.state +
                ", count=" + this.count +
                '}';
    }
}
