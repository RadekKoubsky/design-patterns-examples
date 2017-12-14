/**
 * The Observer Pattern defines a one-to-many dependency between objects
 * so that when one object changes state, all of its dependents are
 * notified and updated automatically.
 * <p>
 * <p>
 * Design Principle:
 * </p>
 * <p>
 * Strive for loosely coupled designs between objects that interact.
 * </p>
 * <p>
 * Loosely coupled designs allows us to build flexible Object Oriented
 * systems that can handle change because they minimize the interdependency
 * between objects.
 * </p>
 * <p>Custom Observer implementation vs java.util.Observable implementation:</p>
 * <p>
 * Custom Observer implementation defines its own order in which observers are notified.
 * You control the order of the observers during notification.
 * </p>
 * <p>
 * Observable API in java.util controls the order of notification for observers.
 * Thus, your application cannot depend on specific order of notifications for observers.
 * </p>
 * <p>General Principle:</p>
 * <p>Do not depend on a specific order of notifications for your observers.</p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
package org.rkoubsky.examples.designpatterns.behavioral.observer;