package org.rkoubsky.examples.designpatterns.behavioral.commandpattern.receiver;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public enum SPEED {
    OFF(0), LOW(1), MEDIUM(2), HIGH(3);
    private final int speed;

    SPEED(final int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }
}
