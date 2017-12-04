package org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.customiterator.iterator;

import org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.customiterator.menu.MenuItem;

/**
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
}
