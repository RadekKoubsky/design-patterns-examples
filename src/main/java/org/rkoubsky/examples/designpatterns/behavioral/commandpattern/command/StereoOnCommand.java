package org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command;

import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.receiver.Stereo;

/**
 * The ConcreteCommand defines a binding between an action and a Receiver.
 * The Invoker makes a request by calling execute() and the ConcreteCommand carries it out by
 * calling one or more actions on the Receiver
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class StereoOnCommand implements Command {
    private final Stereo stereo;

    public StereoOnCommand(final Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        this.stereo.on();
    }
}
