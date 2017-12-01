package org.rkoubsky.examples.designpatterns.structural.adapter.iteratorenum;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * An Adapter that converts an Iterator to an Enumeration.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class EnumerationAdapter implements Enumeration {
    private final Iterator iterator;

    public EnumerationAdapter(final Iterator iterator) {
        this.iterator = iterator;
    }


    @Override
    public boolean hasMoreElements() {
        return this.iterator.hasNext();
    }

    @Override
    public Object nextElement() {
        return this.iterator.next();
    }
}
