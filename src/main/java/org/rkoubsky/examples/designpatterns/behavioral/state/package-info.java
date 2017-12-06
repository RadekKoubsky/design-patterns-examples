/**
 * The State Pattern allows and object to alter its behavior when its internal state
 * changes. The object will appear to change its class.
 * <p>
 * Comparison with Strategy Pattern
 * </p>
 * <p>With the State Pattern, we have a set of behaviors encapsulated
 * in state objects; at any time the context is delegating to one of
 * those states. Over time, the current state changes across the set
 * of state objects to reflect the internal state of the context, so
 * the Context's behavior changes over time as well. The client usually
 * knows very little, if anything, about the state objects.
 * </p>
 * <p>
 * With Strategy, the client usually specifies the strategy object
 * that the context is composed with. Now, while the pattern provides
 * the flexibility to change the strategy object at runtime, often there
 * is a strategy object that is most appropriate for a context object
 * </p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
package org.rkoubsky.examples.designpatterns.behavioral.state;