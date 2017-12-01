/**
 * The Facade Pattern provides a unified interface to a set of interfaces in a subsystem.
 * Facade defines higher-level interface that makes the subsystem easier to use.
 * <p>
 * A facade wraps a set of objects to simplify. It provides an advantage of decoupling client from the subsystem.
 * <br/>
 * <p>
 * The Facade supports the following Design Principle:
 * <p><b>Principle of Least Knowledge (Law of Demeter)</b> - talk only to your immediate friends.</p>
 * <p>
 * The Principle of Least Knowledge guides us to reduce the interactions between objects to just
 * a few close "friends".
 *
 * Guidelines of the principle:
 * <p>
 *     Take any object, now from any method in that object, the principle tells us that we should
 *     only invoke methods that belong to:
 *     <ul>
 *         <li>The object itself</li>
 *         <li>Object passed in as a parameter to the method</li>
 *         <li>Any object that the methods creates on instantiates</li>
 *         <li>Any component of the object</li>
 *     </ul>
 * </p>
 *
 * </p>
 * Comparison with The Adapter Pattern:
 * <p>The Facade's intent is to provide a simplified interface to a complex subsystem.</p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
package org.rkoubsky.examples.designpatterns.structural.facade;