package org.rkoubsky.examples.designpatterns.behavioral.commandpattern.receiver;

/**
 * A receiver. It knows how to perform the work needed to carry out the request.
 * Any class can act as a Receiver.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class GarageDoor {
    public void up() {
        System.out.println("Rolling garage doors up. Doors are open.");
    }

    public void down() {
        System.out.println("Rolling garage doors down. Doors are closed.");
    }
}
