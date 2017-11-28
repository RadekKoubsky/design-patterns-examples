package org.rkoubsky.examples.designpatterns.creational.singleton.nonthreadsafe;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class NonThreadSafeSingleton {
    private static NonThreadSafeSingleton instance;

    private NonThreadSafeSingleton() {
    }

    public static NonThreadSafeSingleton getInstance() {
        if (instance == null) {
            sleep();
            instance = new NonThreadSafeSingleton();
        }
        return instance;
    }

    private static void sleep() {
        try {
            Thread.sleep(300);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }
}
