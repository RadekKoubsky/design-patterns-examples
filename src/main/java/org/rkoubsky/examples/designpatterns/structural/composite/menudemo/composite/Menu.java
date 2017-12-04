package org.rkoubsky.examples.designpatterns.structural.composite.menudemo.composite;

import org.rkoubsky.examples.designpatterns.structural.composite.menudemo.component.MenuComponent;
import org.rkoubsky.examples.designpatterns.structural.composite.menudemo.iterator.CompositeIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The Composite. It's role is to define behavior of the components
 * having children and to store child components.
 * <p>
 * The Composite also implements the Leaf-related operations. Note that some of these
 * may not make sense on a Composite, so in that case and exception might be thrown.
 * </p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Menu extends MenuComponent {
    private Iterator<MenuComponent> iterator = null;
    private final List<MenuComponent> menuComponents = new ArrayList<>();
    private final String name;
    private final String description;

    public Menu(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        if (this.iterator == null) {
            this.iterator = new CompositeIterator(this.menuComponents.iterator());
        }
        return this.iterator;
    }

    @Override
    public void add(final MenuComponent menuComponent) {
        this.menuComponents.add(menuComponent);
    }

    @Override
    public void remove(final MenuComponent menuComponent) {
        this.menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(final int i) {
        return this.menuComponents.get(i);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * We are using an iterator to step through each item in this component
     * and if that item is a {@link Menu} component again, then we recursively
     * call the {@link Menu#print()} method to handle it. In the other words,
     * the MenuComponent handles the iteration itself, <i>internally</i>.
     */
    @Override
    public void print() {
        System.out.printf("\n %s", getName());
        System.out.printf(", %s\n", getDescription());
        System.out.println("------------------------");

        this.menuComponents.forEach(menuComponent -> menuComponent.print());
    }
}
