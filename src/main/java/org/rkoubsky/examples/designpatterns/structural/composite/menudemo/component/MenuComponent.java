package org.rkoubsky.examples.designpatterns.structural.composite.menudemo.component;

import java.math.BigDecimal;
import java.util.Iterator;

/**
 * The Component defines an interface for all objects in the composition:
 * both the composite and the leaf nodes
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public abstract class MenuComponent {
    public abstract Iterator<MenuComponent> createIterator();

    public void add(final MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(final MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(final int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public BigDecimal getPrice() {
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}
