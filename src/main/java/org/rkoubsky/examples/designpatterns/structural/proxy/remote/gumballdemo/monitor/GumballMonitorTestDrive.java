package org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.monitor;

import org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.gumball.GumballMachineRemote;
import org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.gumball.GumballMachineTestDrive;

import java.rmi.Naming;

/**
 * A client that looks up the GumballMachineRemote service from the
 * service registry. The looked up registry within this client is backed by
 * a proxy that calls the remote service over the network.
 * <p>
 * Run the client code after running server {@link GumballMachineTestDrive}
 * </p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class GumballMonitorTestDrive {
    public static void main(final String[] args) {
        GumballMonitor monitor = null;
        try {
            /**
             * This returns a proxy to the remote GumballMachine service.
             * */
            final GumballMachineRemote remoteMachine = (GumballMachineRemote) Naming.lookup("GumballMachine");
            monitor = new GumballMonitor(remoteMachine);
            System.out.println(monitor);
            System.out.println("Printing report from a remote GumballMachine:");
            monitor.report();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
