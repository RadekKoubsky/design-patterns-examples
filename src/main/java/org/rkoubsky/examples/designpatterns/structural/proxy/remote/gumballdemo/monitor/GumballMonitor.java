package org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.monitor;

import org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.gumball.GumballMachineRemote;

import java.rmi.RemoteException;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class GumballMonitor {
    private final GumballMachineRemote remoteMachine;

    public GumballMonitor(final GumballMachineRemote remoteMachine) {
        this.remoteMachine = remoteMachine;
    }

    public void report() {
        try {
            System.out.println("Gumball Machine: " + this.remoteMachine.getLocation());
            System.out.println("Current inventory: " + this.remoteMachine.getCount());
            System.out.println("Current state: " + this.remoteMachine.getState());
        } catch (final RemoteException e) {
            e.printStackTrace();
        }
    }
}
