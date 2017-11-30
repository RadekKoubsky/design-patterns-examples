package org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command;

/**
 * Command declares an interface for all commands.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface Command {
    void execute();

    void undo();
}
