package org.rkoubsky.examples.designpatterns.behavioral.commandpattern.invoker;

import org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command.Command;

import java.util.Arrays;

/**
 * The invoker holds a command (or a list of commands) and at some point asks the command to carry out a request
 * by calling its execute() method.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class RemoteControl {
    private final Command[] onCommands;
    private final Command[] offCommands;

    public RemoteControl(final Command[] onCommands, final Command[] offCommands) {
        this.onCommands = Arrays.copyOf(onCommands, onCommands.length);
        this.offCommands = Arrays.copyOf(offCommands, onCommands.length);
    }

    public void onButtonPressed(final int slot) {
        this.onCommands[slot].execute();
    }

    public void offButtonPressed(final int slot) {
        this.offCommands[slot].execute();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("/n------------- Remote Control -------------\n");
        for (int i = 0; i < this.onCommands.length; i++) {
            sb.append(String.format("[slot %s] %s           %s \n", i, this.onCommands[i].getClass()
                    .getSimpleName(), this.offCommands[i]
                    .getClass().getSimpleName()));
        }
        return sb.toString();
    }
}
