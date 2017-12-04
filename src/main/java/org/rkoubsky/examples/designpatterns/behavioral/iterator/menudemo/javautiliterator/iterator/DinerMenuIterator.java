package org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.javautiliterator.iterator;

import org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.javautiliterator.menu.MenuItem;

import java.util.Iterator;

/**
 * The ConcreteIterator is responsible for managing the current position
 * of the iteration.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class DinerMenuIterator implements Iterator<MenuItem> {
    private final MenuItem[] items;
    private int position = 0;

    public DinerMenuIterator(final MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return !(this.position >= this.items.length || this.items[this.position] == null);
    }

    @Override
    public MenuItem next() {
        final MenuItem item = this.items[this.position];
        this.position++;
        return item;
    }

    @Override
    public void remove() {
        if (this.position <= 0) {
            throw new IllegalStateException("Cannot remove an element until next() has been done at least once.");
        }
        if (this.items[this.position - 1] != null) {
            for (int i = this.position - 1; i < this.items.length - 1; i++) {
                this.items[i] = this.items[i + 1];
            }
            this.items[this.items.length - 1] = null;
        }
    }
}
