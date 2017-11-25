package org.rkoubsky.examples.designpatterns.structural.decorator;

import org.rkoubsky.examples.designpatterns.structural.decorator.beverages.Beverage;
import org.rkoubsky.examples.designpatterns.structural.decorator.beverages.DarkRoast;
import org.rkoubsky.examples.designpatterns.structural.decorator.beverages.Decaf;
import org.rkoubsky.examples.designpatterns.structural.decorator.beverages.Espresso;
import org.rkoubsky.examples.designpatterns.structural.decorator.beverages.Size;
import org.rkoubsky.examples.designpatterns.structural.decorator.condiments.Mocha;
import org.rkoubsky.examples.designpatterns.structural.decorator.condiments.Soy;
import org.rkoubsky.examples.designpatterns.structural.decorator.condiments.SteamedMilk;
import org.rkoubsky.examples.designpatterns.structural.decorator.condiments.Whip;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class StarbuzzCoffee {
    public static void main(final String[] args) {
        final Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription() + " $" + espresso.cost());

        final Beverage darkRoastDoubleMochaWhip = new Whip(new Mocha(new Mocha(new DarkRoast(Size.MEDIUM))));
        System.out.println(darkRoastDoubleMochaWhip.getDescription() + " $" + darkRoastDoubleMochaWhip.cost());

        final Beverage largeDecafWithSoyMilkWhipMocha = new Soy(
                new SteamedMilk(new Whip(new Mocha(new Decaf(Size.LARGE)))));
        System.out.println(
                largeDecafWithSoyMilkWhipMocha.getDescription() + " $" + largeDecafWithSoyMilkWhipMocha.cost());
    }
}
