/**
 * The Iterator Pattern provides a way to access the elements of an aggregate object
 * sequentially without exposing its underlying representation.
 * <p>
 * The Iterator Pattern supports the following principle:
 * <p>
 * <b>Single Responsibility Principle</b>:
 * </p>
 * <p>
 * A class should have only one reason to change.
 * </p>
 *
 * <p>
 *      We could put the iteration methods into the aggregates, but that would violate
 *      the Single Responsibility Principle, the aggregates would have another responsibility
 *      for the iteration. Using the Iterator Pattern, we put the iteration responsibility to
 *      the Iterator.
 * </p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
package org.rkoubsky.examples.designpatterns.behavioral.iterator;