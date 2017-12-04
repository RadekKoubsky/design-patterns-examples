package org.rkoubsky.examples.designpatterns.structural.composite.menudemo.iterator;

import org.rkoubsky.examples.designpatterns.structural.composite.menudemo.component.MenuComponent;
import org.rkoubsky.examples.designpatterns.structural.composite.menudemo.composite.Menu;

import java.util.Iterator;
import java.util.Stack;

/**
 * With this code, we are implementing an external iterator as opposed to
 * {@link Menu#print()} method, that uses internal iteration.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class CompositeIterator implements Iterator<MenuComponent> {
    private final Stack<Iterator<MenuComponent>> stack = new Stack<>();

    public CompositeIterator(final Iterator<MenuComponent> iterator) {
        this.stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (this.stack.isEmpty()) {
            return false;
        } else {
            final Iterator<MenuComponent> iterator = this.stack.peek();
            if (!iterator.hasNext()) {
                this.stack.pop();
                return hasNext();
            } else return true;
        }
    }

    @Override
    public MenuComponent next() {
        if (hasNext()) {
            final Iterator<MenuComponent> iterator = this.stack.peek();
            final MenuComponent menuComponent = iterator.next();
            if (menuComponent instanceof Menu) {
                this.stack.push(menuComponent.createIterator());
            }
            return menuComponent;
        } else {
            return null;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
