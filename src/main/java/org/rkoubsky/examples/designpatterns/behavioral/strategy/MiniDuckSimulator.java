package org.rkoubsky.examples.designpatterns.behavioral.strategy;

import org.rkoubsky.examples.designpatterns.behavioral.strategy.ducks.DecoyDuck;
import org.rkoubsky.examples.designpatterns.behavioral.strategy.ducks.Duck;
import org.rkoubsky.examples.designpatterns.behavioral.strategy.ducks.MallardDuck;
import org.rkoubsky.examples.designpatterns.behavioral.strategy.ducks.ModelDuck;
import org.rkoubsky.examples.designpatterns.behavioral.strategy.ducks.RubberDuck;
import org.rkoubsky.examples.designpatterns.behavioral.strategy.fly.FlyNoWay;
import org.rkoubsky.examples.designpatterns.behavioral.strategy.fly.FlyRocketPowered;
import org.rkoubsky.examples.designpatterns.behavioral.strategy.fly.FlyWithWings;
import org.rkoubsky.examples.designpatterns.behavioral.strategy.quack.MuteQuack;
import org.rkoubsky.examples.designpatterns.behavioral.strategy.quack.Quack;
import org.rkoubsky.examples.designpatterns.behavioral.strategy.quack.Squeak;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck(new FlyWithWings(), new Quack());
        mallard.display();
        mallard.performQuack();
        mallard.performFly();

        Duck rubberDuck = new RubberDuck(new FlyNoWay(), new Squeak());
        rubberDuck.display();
        rubberDuck.performQuack();
        rubberDuck.performFly();

        Duck decoyDuck = new DecoyDuck(new FlyNoWay(),new MuteQuack());
        decoyDuck.display();
        decoyDuck.performQuack();
        decoyDuck.performFly();

        Duck model = new ModelDuck(new FlyNoWay(), new Quack());
        model.display();
        model.performQuack();
        model.performFly();

        Duck flyingModel = new ModelDuck(new FlyRocketPowered(), new Quack());
        flyingModel.display();
        flyingModel.performQuack();
        flyingModel.performFly();
    }
}
