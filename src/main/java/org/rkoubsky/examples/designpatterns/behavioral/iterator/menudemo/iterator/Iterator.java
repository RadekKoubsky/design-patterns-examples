package org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.iterator;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface Iterator<E> {
    boolean hasNext();

    E next();
}
