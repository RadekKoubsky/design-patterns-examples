package org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.gumball;

import org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.state.State;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This is the remote service that is registered to the RMI {@link java.rmi.registry.Registry}
 * and can be looked up over the network.
 * <p>
 * Represents a Subject. Both Proxy and the RealSubject ({@link GumballMachine})
 * implement the Subject interface. This allows any client to treat the proxy
 * just like the RealSubject.
 * </p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface GumballMachineRemote extends Remote {
    int getCount() throws RemoteException;

    String getLocation() throws RemoteException;

    State getState() throws RemoteException;

}
