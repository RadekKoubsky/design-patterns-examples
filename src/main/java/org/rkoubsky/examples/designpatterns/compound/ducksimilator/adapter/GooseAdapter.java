package org.rkoubsky.examples.designpatterns.compound.ducksimilator.adapter;

import org.rkoubsky.examples.designpatterns.compound.ducksimilator.Quackable;
import org.rkoubsky.examples.designpatterns.compound.ducksimilator.animals.Goose;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class GooseAdapter implements Quackable {
    private final Goose goose;

    public GooseAdapter(final Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        this.goose.honk();
    }
}
