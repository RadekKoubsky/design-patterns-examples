package org.rkoubsky.examples.designpatterns.behavioral.templatemethod.beveragesdemo.beverages;

/**
 * The AbstractClass contains the template method {@link CaffeineBeverageWithHook#prepareRecipe()}.
 * It is declared abstract and meant to be subclassed by classes that provide
 * implementations of the operations within the template methods.
 * <p>
 * The Hollywood Principle reference:
 * </p>
 * <p>
 * This class is our high-level component. It has control over
 * the algorithm for the recipe, and calls on
 * the subclasses only when they are needed for an implementation
 * of a method.
 * </p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public abstract class CaffeineBeverageWithHook {
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
        System.out.println("Your Beverage is ready for you.");
    }

    protected abstract void brew();

    protected abstract void addCondiments();

    private void boilWater() {
        System.out.println("Boiling Water.");
    }

    private void pourInCup() {
        System.out.println("Pouring into a cup.");
    }

    /**
     * A Hook is a method with (mostly) empty default implementation. This gives subclasses the ability to "hook into"
     * the algorithm at various points to control some parts of the algorithm. It
     * is a hook because the subclass can override this method, but does not have to.
     */
    protected boolean customerWantsCondiments() {
        return true;
    }
}
