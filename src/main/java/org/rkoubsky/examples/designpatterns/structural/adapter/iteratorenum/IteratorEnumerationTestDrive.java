package org.rkoubsky.examples.designpatterns.structural.adapter.iteratorenum;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class IteratorEnumerationTestDrive {
    public static void main(final String[] args) throws InterruptedException {
        final List<String> strings = Arrays.asList("John", "Alice");
        final Enumeration enumerationAdapter = new EnumerationAdapter(strings.iterator());
        System.out.println("Printing values using EnumerationAdapter:");
        while (enumerationAdapter.hasMoreElements()) {
            System.out.println(enumerationAdapter.nextElement());
        }

        final Enumeration<String> enumNames = Collections.enumeration(strings);
        final Iterator iteratorAdapter = new IteratorAdapter(enumNames);
        System.out.println("Printing values using IteratorAdapter:");
        while (iteratorAdapter.hasNext()) {
            System.out.println(iteratorAdapter.next());
        }
        System.out.println("Trying to remove an element from IteratorAdapter..");
        Thread.sleep(100);
        iteratorAdapter.remove();
    }
}
