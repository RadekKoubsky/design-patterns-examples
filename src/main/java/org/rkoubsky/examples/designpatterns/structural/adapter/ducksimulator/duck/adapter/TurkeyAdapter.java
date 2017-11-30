package org.rkoubsky.examples.designpatterns.structural.adapter.ducksimulator.duck.adapter;

import org.rkoubsky.examples.designpatterns.structural.adapter.ducksimulator.duck.Duck;
import org.rkoubsky.examples.designpatterns.structural.adapter.ducksimulator.turkey.Turkey;

import java.util.stream.IntStream;

/**
 * The adapter implements the Target interface ({@link Duck}), but when
 * it gets to a method call, it turns around and delegates the calls to an Adaptee ({@link Turkey}).
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class TurkeyAdapter implements Duck {
    private final Turkey turkey;

    public TurkeyAdapter(final Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        this.turkey.gobble();
    }

    @Override
    public void fly() {
        IntStream.range(0, 5).forEach(i -> this.turkey.fly());
    }
}
