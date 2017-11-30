package org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command;

import java.util.stream.Stream;

/**
 * A kind of command that executes multiple commands.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class MacroCommand implements Command {
    private final Command[] commands;

    public MacroCommand(final Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        Stream.of(this.commands).forEach(command -> command.execute());
    }

    @Override
    public void undo() {
        Stream.of(this.commands).forEach(command -> command.undo());
    }
}
