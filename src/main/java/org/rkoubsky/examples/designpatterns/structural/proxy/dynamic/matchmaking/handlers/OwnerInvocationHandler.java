package org.rkoubsky.examples.designpatterns.structural.proxy.dynamic.matchmaking.handlers;

import org.rkoubsky.examples.designpatterns.structural.proxy.dynamic.matchmaking.persons.PersonBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class OwnerInvocationHandler implements InvocationHandler {
    private final PersonBean person;

    public OwnerInvocationHandler(final PersonBean person) {
        this.person = person;
    }

    @Override
    public Object invoke(final Object proxy, final Method method,
            final Object[] args) throws IllegalAccessException, InvocationTargetException {
        if ("setHotOrNotRating".equals(method.getName())) {
            throw new IllegalAccessException("A Person cannot give rating to itself.");
        }
        if (!method.getName().startsWith("get") || method.getName().startsWith("set")) {
            return null;
        }
        return method.invoke(this.person, args);
    }
}
