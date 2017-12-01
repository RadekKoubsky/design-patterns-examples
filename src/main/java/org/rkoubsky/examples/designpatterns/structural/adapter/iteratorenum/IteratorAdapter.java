package org.rkoubsky.examples.designpatterns.structural.adapter.iteratorenum;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * An Adapter that converts an Enumeration to an Iterator.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class IteratorAdapter implements Iterator {
    private final Enumeration enumeration;

    public IteratorAdapter(final Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return this.enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return this.enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException(
                "IteratorAdapter for Enumeration does not support remove operation as Enumeration is read only interface");
    }
}
