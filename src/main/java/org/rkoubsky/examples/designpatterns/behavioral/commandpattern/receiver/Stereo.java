package org.rkoubsky.examples.designpatterns.behavioral.commandpattern.receiver;

/**
 * A receiver. It knows how to perform the work needed to carry out the request.
 * Any class can act as a Receiver.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Stereo {

    private final String location;

    public Stereo(final String location) {
        this.location = location;
    }

    public void on() {
        System.out.printf("%s stereo is on.\n", this.location);
    }

    public void off() {
        System.out.printf("%s stereo is off.\n", this.location);
    }
}
