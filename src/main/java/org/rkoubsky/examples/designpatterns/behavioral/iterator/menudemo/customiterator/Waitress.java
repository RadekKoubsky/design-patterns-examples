package org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.customiterator;

import org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.customiterator.iterator.Iterator;
import org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.customiterator.menu.DinerMenu;
import org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.customiterator.menu.MenuItem;
import org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.customiterator.menu.PancakeHouseMenu;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Waitress {
    private final PancakeHouseMenu pancakeHouseMenu;
    private final DinerMenu dinerMenu;

    public Waitress(
            final PancakeHouseMenu pancakeHouseMenu,
            final DinerMenu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    public void printMenu() {
        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(this.pancakeHouseMenu.iterator());
        System.out.println("\nLUNCH");
        printMenu(this.dinerMenu.iterator());
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
