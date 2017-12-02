package org.rkoubsky.examples.designpatterns.behavioral.templatemethod.beveragesdemo;

import org.rkoubsky.examples.designpatterns.behavioral.templatemethod.beveragesdemo.beverages.CaffeineBeverageWithHook;
import org.rkoubsky.examples.designpatterns.behavioral.templatemethod.beveragesdemo.beverages.CoffeeWithHook;
import org.rkoubsky.examples.designpatterns.behavioral.templatemethod.beveragesdemo.beverages.Tea;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class BeverageTestDrive {
    public static void main(final String[] args) {
        final CaffeineBeverageWithHook teaWithHook = new Tea();
        final CaffeineBeverageWithHook coffee = new CoffeeWithHook();

        System.out.println("\nMaking tea...");
        teaWithHook.prepareRecipe();

        System.out.println("\nMaking coffee");
        coffee.prepareRecipe();
    }
}
