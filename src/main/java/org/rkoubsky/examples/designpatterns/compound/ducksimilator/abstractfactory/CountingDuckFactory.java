package org.rkoubsky.examples.designpatterns.compound.ducksimilator.abstractfactory;

import org.rkoubsky.examples.designpatterns.compound.ducksimilator.Quackable;
import org.rkoubsky.examples.designpatterns.compound.ducksimilator.adapter.GooseAdapter;
import org.rkoubsky.examples.designpatterns.compound.ducksimilator.animals.Goose;
import org.rkoubsky.examples.designpatterns.compound.ducksimilator.animals.ducks.DuckCall;
import org.rkoubsky.examples.designpatterns.compound.ducksimilator.animals.ducks.MallardDuck;
import org.rkoubsky.examples.designpatterns.compound.ducksimilator.animals.ducks.RedheadDuck;
import org.rkoubsky.examples.designpatterns.compound.ducksimilator.animals.ducks.RubberDuck;
import org.rkoubsky.examples.designpatterns.compound.ducksimilator.decorator.QuackCounter;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class CountingDuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackCounter(new RedheadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(new DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }

    @Override
    public Quackable createGooseDuck() {
        return new GooseAdapter(new Goose());
    }
}
