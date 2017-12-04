package org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.javautiliterator.menu;

import java.util.Iterator;

/**
 * An Aggregate interface. Having a common interface for your aggregates
 * is handy for your clients; it decouples your client from the implementation
 * of your collection of objects.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface Menu {
    public Iterator createIterator();
}
