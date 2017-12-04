package org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.customiterator.iterator;

import org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.customiterator.menu.MenuItem;

import java.util.ArrayList;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class PancakeHouseMenuIterator implements Iterator<MenuItem> {
    private final ArrayList<MenuItem> items;
    private int position = 0;

    public PancakeHouseMenuIterator(final ArrayList<MenuItem> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return this.position < this.items.size();
    }

    @Override
    public MenuItem next() {
        final MenuItem item = this.items.get(this.position);
        this.position++;
        return item;
    }
}
