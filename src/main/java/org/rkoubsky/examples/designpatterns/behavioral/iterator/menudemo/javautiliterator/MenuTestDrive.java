package org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.javautiliterator;

import org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.javautiliterator.menu.CafeMenu;
import org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.javautiliterator.menu.DinerMenu;
import org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.javautiliterator.menu.Menu;
import org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.javautiliterator.menu.PancakeHouseMenu;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class MenuTestDrive {
    public static void main(final String[] args) {
        final Menu pancakeHouseMenu = new PancakeHouseMenu();
        final Menu dinerMenu = new DinerMenu();
        final Menu cafeMenu = new CafeMenu();
        final Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu, cafeMenu);
        waitress.printMenu();
    }
}
