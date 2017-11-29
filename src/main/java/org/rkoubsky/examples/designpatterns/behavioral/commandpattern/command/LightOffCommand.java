package org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command;

import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.receiver.Light;

/**
 * The ConcreteCommand defines a binding between an action and a Receiver.
 * The Invoker makes a request by calling execute() and the ConcreteCommand carries it out by
 * calling one or more actions on the Receiver
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(final Light light) {
        this.light = light;
    }


    @Override
    public void execute() {
        this.light.off();
    }
}
