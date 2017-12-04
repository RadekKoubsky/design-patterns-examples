package org.rkoubsky.examples.designpatterns.structural.composite.menudemo.iterator;

import org.rkoubsky.examples.designpatterns.structural.composite.menudemo.component.MenuComponent;

import java.util.Iterator;

/**
 * We are using this iterator for {@link org.rkoubsky.examples.designpatterns.structural.composite.menudemo.leaf.MenuItem},
 * which does not have any elements to iterate over as it is a leaf.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class NullIterator implements Iterator<MenuComponent> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public MenuComponent next() {
        return null;
    }

    @Override
    public void remove() {
        new UnsupportedOperationException();
    }
}
