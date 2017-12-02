package org.rkoubsky.examples.designpatterns.behavioral.templatemethod.beveragesdemo.beverages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The ConcreteClass implements the abstract methods, which are called
 * when the template method {@link CaffeineBeverageWithHook#prepareRecipe()}
 * needs them.
 * <p>
 * The Hollywood Principle reference:
 * </p>
 * <p>
 * The subclasses are used simply to provide implementation details.
 * They never call the abstract class directly without being "called" first.
 * </p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class CoffeeWithHook extends CaffeineBeverageWithHook {
    @Override
    protected void brew() {
        System.out.println("Dripping Coffee through the filter.");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk.");
    }

    @Override
    protected boolean customerWantsCondiments() {
        return getUserInput().toLowerCase().startsWith("y");
    }

    public String getUserInput() {
        String answer = "no";

        System.out.println("Would you like milk and sugar wit your coffee (y/n)? ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            answer = reader.readLine();
        } catch (final IOException e) {
            System.err.println("IO error trying to read your answer.");
        }
        return answer;
    }
}
