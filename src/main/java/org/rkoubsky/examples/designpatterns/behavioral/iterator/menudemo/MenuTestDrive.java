package org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo;

import org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.menu.DinerMenu;
import org.rkoubsky.examples.designpatterns.behavioral.iterator.menudemo.menu.PancakeHouseMenu;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class MenuTestDrive {
    public static void main(final String[] args) {
        final PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        final DinerMenu dinerMenu = new DinerMenu();
        final Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
        waitress.printMenu();
    }
}
