package org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.javautiliterator;

import org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.javautiliterator.menu.Menu;
import org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.javautiliterator.menu.MenuItem;

import java.util.Iterator;

/**
 * A client using Aggregates and its iterators to print items within the aggregates.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Waitress {
    private final Menu pancakeHouseMenu;
    private final Menu dinerMenu;
    private final Menu cafeMenu;

    public Waitress(
            final Menu pancakeHouseMenu,
            final Menu dinerMenu,
            final Menu cafeMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
        this.cafeMenu = cafeMenu;
    }

    public void printMenu() {
        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(this.pancakeHouseMenu.createIterator());
        System.out.println("\nLUNCH");
        printMenu(this.dinerMenu.createIterator());
        System.out.println("\nDINNER");
        printMenu(this.cafeMenu.createIterator());
    }

    private void printMenu(final Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            final MenuItem menuItem = iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }
}
