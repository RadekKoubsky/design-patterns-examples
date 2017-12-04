package org.rkoubsky.examples.designpatterns.structural.composite.menudemo.client;

import org.rkoubsky.examples.designpatterns.structural.composite.menudemo.component.MenuComponent;

import java.util.Iterator;

/**
 * The Client uses the Component ({@link MenuComponent}) interface to manipulate
 * the objects in the composition.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Waitress {
    private final MenuComponent allMenus;

    public Waitress(final MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void print() {
        this.allMenus.print();
    }

    public void printVegetarioanMenu() {
        final Iterator<MenuComponent> iterator = this.allMenus.createIterator();
        System.out.println("\nVEGETARIAN MENU\n-----------");
        iterator.forEachRemaining(menuComponent -> {
            try {
                if (menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
            } catch (final UnsupportedOperationException e) {
            }
        });
    }
}
