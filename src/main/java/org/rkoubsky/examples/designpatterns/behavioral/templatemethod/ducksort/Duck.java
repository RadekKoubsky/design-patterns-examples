package org.rkoubsky.examples.designpatterns.behavioral.templatemethod.ducksort;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Duck implements Comparable {
    private final String name;
    private final int weight;

    public Duck(final String name, final int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + this.name + '\'' +
                ", weight=" + this.weight +
                '}';
    }

    @Override
    public int compareTo(final Object o) {
        final Duck otherDuck = (Duck) o;

        if (this.weight < otherDuck.weight) {
            return -1;
        } else if (this.weight == otherDuck.weight) {
            return 0;
        } else {
            return 1;
        }
    }
}
