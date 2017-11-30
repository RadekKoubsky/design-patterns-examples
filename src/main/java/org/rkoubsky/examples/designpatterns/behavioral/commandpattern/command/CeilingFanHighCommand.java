package org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command;

import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.receiver.CeilingFan;
import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.receiver.SPEED;

/**
 * The ConcreteCommand defines a binding between an action and a Receiver.
 * The Invoker makes a request by calling execute() and the ConcreteCommand carries it out by
 * calling one or more actions on the Receiver
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class CeilingFanHighCommand implements Command {
    private final CeilingFan ceilingFan;
    private SPEED previousSpeed;

    public CeilingFanHighCommand(final CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        this.previousSpeed = this.ceilingFan.getSpeed();
        this.ceilingFan.high();
    }

    @Override
    public void undo() {
        switch (this.previousSpeed) {
            case OFF:
                this.ceilingFan.off();
                break;
            case LOW:
                this.ceilingFan.low();
                break;
            case MEDIUM:
                this.ceilingFan.medium();
                break;
            case HIGH:
                this.ceilingFan.high();
                break;
        }
    }
}
