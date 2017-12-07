package org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.gumball;

import org.rkoubsky.examples.designpatterns.structural.proxy.remote.gumballdemo.monitor.GumballMonitorTestDrive;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * The Server running the GumballMachineRemote service.
 * Initializes the remote service and registers the service to the RMI Registry.
 * <p>
 * Run this before running the client {@link GumballMonitorTestDrive}
 * </p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class GumballMachineTestDrive {
    public static void main(final String[] args) {
        GumballMachineRemote gumballMachineService = null;
        try {
            final Registry registry = LocateRegistry.createRegistry(1099);
            gumballMachineService = new GumballMachine("Localhost", 100);
            registry.rebind("GumballMachine", gumballMachineService);
            System.out.printf("%s\nhas been successfully registered to the Registry.\n", gumballMachineService);
            System.out.println("Listed bindings within the Registry:");
            System.out.println(Arrays.asList(registry.list()));
            while (true) {
                System.out.println("Waiting for clients to connect to the registry.");
                TimeUnit.MINUTES.sleep(5);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
