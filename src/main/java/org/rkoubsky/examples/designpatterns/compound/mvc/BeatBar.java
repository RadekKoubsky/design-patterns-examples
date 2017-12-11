package org.rkoubsky.examples.designpatterns.compound.mvc;

import javax.swing.*;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class BeatBar extends JProgressBar implements Runnable {
    private final Thread thread;

    public BeatBar() {
        this.thread = new Thread(this);
        setMaximum(100);
        this.thread.start();
    }

    @Override
    public void run() {
        for (; ; ) {
            int value = getValue();
            value = (int) (value * .75);
            setValue(value);
            repaint();
            try {
                Thread.sleep(50);
            } catch (final Exception e) {
            }
        }
    }
}
