package org.rkoubsky.examples.designpatterns.creational.singleton.threadsafe;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class EagerlyInitializedSingleton {
    private static final EagerlyInitializedSingleton instance = new EagerlyInitializedSingleton();

    private EagerlyInitializedSingleton() {
    }

    public static EagerlyInitializedSingleton getInstance() {
        return instance;
    }
}
