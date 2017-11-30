package org.rkoubsky.examples.designpatterns.behavioral.commandpattern.command;

/**
 * Represents Null Object to handle {@code null} reference
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class NoCommand implements Command {
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
