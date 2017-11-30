package org.rkoubsky.examples.designpatterns.structural.adapter.ducksimulator.duck;

/**
 * The Target interface. This is what the client invokes methods on.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface Duck {
    void quack();

    void fly();
}
