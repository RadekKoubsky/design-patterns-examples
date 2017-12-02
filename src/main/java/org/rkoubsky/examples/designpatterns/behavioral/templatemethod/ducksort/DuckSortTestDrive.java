package org.rkoubsky.examples.designpatterns.behavioral.templatemethod.ducksort;

import java.util.Arrays;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class DuckSortTestDrive {
    public static void main(final String[] args) {
        final Duck[] ducks = {new Duck("Medium duck", 5), new Duck("Large duck", 8), new Duck("Small duck", 3)};
        System.out.println("Before sorting");
        System.out.println(Arrays.asList(ducks));

        Arrays.sort(ducks);
        System.out.println("\nAfter sorting");
        System.out.println(Arrays.asList(ducks));
    }
}
