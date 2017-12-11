package org.rkoubsky.examples.designpatterns.compound.mvc.controller;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface ControllerInterface {
    void start();

    void stop();

    void increaseBPM();

    void decreaseBPM();

    void setBPM(int bpm);
}
