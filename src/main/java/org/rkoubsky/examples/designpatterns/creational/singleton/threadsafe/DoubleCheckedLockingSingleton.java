package org.rkoubsky.examples.designpatterns.creational.singleton.threadsafe;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {

    }

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) {
                    sleep();
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
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
