package org.rkoubsky.examples.designpatterns.behavioral.state.gumballdemoorig;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class GumballMachineTestDrive {
    public static void main(final String[] args) {
        final GumballMachine machine = new GumballMachine(5);

        System.out.println(machine);
        machine.insertQuarter();
        machine.turnCrank();

        System.out.println(machine);
        machine.insertQuarter();
        machine.ejectQuarter();
        machine.turnCrank();

        System.out.println(machine);
        machine.insertQuarter();
        machine.turnCrank();
        machine.insertQuarter();
        machine.turnCrank();
        machine.ejectQuarter();

        System.out.println(machine);
        machine.insertQuarter();
        machine.insertQuarter();
        machine.turnCrank();
        machine.insertQuarter();
        machine.turnCrank();
        machine.insertQuarter();
        machine.turnCrank();

        System.out.println(machine);

    }
}
