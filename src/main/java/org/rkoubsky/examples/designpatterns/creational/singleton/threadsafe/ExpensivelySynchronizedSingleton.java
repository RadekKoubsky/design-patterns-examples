package org.rkoubsky.examples.designpatterns.creational.singleton.threadsafe;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ExpensivelySynchronizedSingleton {
    private static ExpensivelySynchronizedSingleton instance;

    private ExpensivelySynchronizedSingleton() {
    }

    public static synchronized ExpensivelySynchronizedSingleton getInstance() {
        if (instance == null) {
            sleep();
            instance = new ExpensivelySynchronizedSingleton();
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
