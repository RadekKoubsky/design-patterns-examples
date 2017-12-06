package org.rkoubsky.examples.designpatterns.behavioral.state.gumballdemoorig;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class GumballMachine {
    private MachineState state = MachineState.SOLD_OUT;
    private int count = 0;

    public GumballMachine(final int count) {
        this.count = count;
        if (this.count > 0) {
            this.state = MachineState.NO_QUARTER;
        }
    }

    public void insertQuarter() {
        switch (this.state) {
            case HAS_QUARTER:
                System.out.println("You can't insert another quarter.");
                break;
            case NO_QUARTER:
                this.state = MachineState.HAS_QUARTER;
                System.out.println("You inserted a quarter.");
                break;
            case SOLD_OUT:
                System.out.println("You can't insert another a quarter, the machine is sold out.");
                break;
            case SOLD:
                System.out.println("Please wait, we are already giving you a gumball.");
                break;
        }
    }

    public void ejectQuarter() {
        switch (this.state) {
            case HAS_QUARTER:
                System.out.println("Quarter returned.");
                this.state = MachineState.NO_QUARTER;
                break;
            case NO_QUARTER:
                System.out.println("You haven't inserted a quarter.");
                break;
            case SOLD_OUT:
                System.out.println("You can't eject, you haven't inserted a quarter yet.");
                break;
            case SOLD:
                System.out.println("Sorry, you already turned the crank.");
                break;
        }
    }

    public void turnCrank() {
        switch (this.state) {
            case HAS_QUARTER:
                System.out.println("You turned...");
                this.state = MachineState.SOLD;
                dispense();
                break;
            case NO_QUARTER:
                System.out.println("You turned, but there is no quarter.");
                break;
            case SOLD_OUT:
                System.out.println("You turned, but there are no gumballs.");
                break;
            case SOLD:
                System.out.println("Turning twice does not get you another gumball.");
                break;
        }
    }

    private void dispense() {
        switch (this.state) {
            case HAS_QUARTER:
                System.out.println("No gumball dispensed.");
                break;
            case NO_QUARTER:
                System.out.println("You need to pay first.");
                break;
            case SOLD_OUT:
                System.out.println("No gumball dispensed.");
                break;
            case SOLD:
                System.out.println("A gumball comes rolling out the slot.");
                this.count--;
                if (this.count == 0) {
                    System.out.println("Oops, out of gumballs.");
                    this.state = MachineState.SOLD_OUT;
                } else {
                    this.state = MachineState.NO_QUARTER;
                }
                break;
        }
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "state=" + this.state +
                ", count=" + this.count +
                '}';
    }
}
