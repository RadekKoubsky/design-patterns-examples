package org.rkoubsky.examples.designpatterns.behavioral.commandpattern.receiver;

/**
 * A receiver. It knows how to perform the work needed to carry out the request.
 * Any class can act as a Receiver.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class CeilingFan {
    private final String location;
    private SPEED speed;

    public CeilingFan(final String location) {
        this.location = location;
        this.speed = SPEED.OFF;
    }

    public void high() {
        System.out.println(this.location + " ceiling fan is on high.");
        this.speed = SPEED.HIGH;
    }

    public void medium() {
        System.out.println(this.location + " ceiling fan is on medium.");
        this.speed = SPEED.MEDIUM;
    }

    public void low() {
        System.out.println(this.location + " ceiling fan is on low.");
        this.speed = SPEED.MEDIUM;
    }

    public void off() {
        System.out.println(this.location + " ceiling fan is off.");
        this.speed = SPEED.OFF;
    }

    public SPEED getSpeed() {
        return this.speed;
    }
}
