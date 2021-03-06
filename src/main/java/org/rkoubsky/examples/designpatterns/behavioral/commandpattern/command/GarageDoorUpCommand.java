package org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command;

import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.receiver.GarageDoor;

/**
 * The ConcreteCommand defines a binding between an action and a Receiver.
 * The Invoker makes a request by calling execute() and the ConcreteCommand carries it out by
 * calling one or more actions on the Receiver
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class GarageDoorUpCommand implements Command {
    private final GarageDoor garageDoor;

    public GarageDoorUpCommand(
            final GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }


    @Override
    public void execute() {
        this.garageDoor.up();
    }

    @Override
    public void undo() {
        this.garageDoor.down();
    }
}
