package org.rkoubsky.examples.designpatterns.behavioral.state.gumballdemo;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class GumballMachineTestDrive {
    public static void main(final String[] args) {
        final GumballMachine gumballMachine = new GumballMachine(5);
        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);
    }
}
