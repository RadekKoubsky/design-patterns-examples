package org.rkoubsky.examples.designpatterns.structural.composite.menudemo.leaf;

import org.rkoubsky.examples.designpatterns.structural.composite.menudemo.component.MenuComponent;
import org.rkoubsky.examples.designpatterns.structural.composite.menudemo.iterator.NullIterator;

import java.math.BigDecimal;
import java.util.Iterator;

/**
 * A Leaf. It defines behavior for the elements in the composition.
 * It does this by implementing the operations the Composite supports.
 * <p>A Leaf has no children.</p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class MenuItem extends MenuComponent {
    private final String name;
    private final String description;
    private final boolean vegetarian;
    private final BigDecimal price;

    public MenuItem(final String name, final String description, final boolean vegetarian, final BigDecimal price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new NullIterator();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public boolean isVegetarian() {
        return this.vegetarian;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public void print() {
        System.out.printf("   %s", getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.printf(", %s\n      -- %s\n", getPrice(), getDescription());
    }
}
