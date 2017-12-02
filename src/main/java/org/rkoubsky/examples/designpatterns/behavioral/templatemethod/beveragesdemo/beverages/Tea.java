package org.rkoubsky.examples.designpatterns.behavioral.templatemethod.beveragesdemo.beverages;

/**
 * The ConcreteClass implements the abstract methods, which are called
 * when the template method {@link CaffeineBeverageWithHook#prepareRecipe()}
 * needs them.
 * <p>
 * The Hollywood Principle reference:
 * <p>
 * The subclasses are used simply to provide implementation details.
 * They never call the abstract class directly without being "called" first.
 * </p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Tea extends CaffeineBeverageWithHook {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea.");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding a lemon.");
    }
}
