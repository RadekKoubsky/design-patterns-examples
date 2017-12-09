package org.rkoubsky.examples.designpatterns.compound.ducksimilator.animals.ducks;

import org.rkoubsky.examples.designpatterns.compound.ducksimilator.Quackable;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class DuckCall implements Quackable {
    @Override
    public void quack() {
        System.out.println("Kwak");
    }
}
