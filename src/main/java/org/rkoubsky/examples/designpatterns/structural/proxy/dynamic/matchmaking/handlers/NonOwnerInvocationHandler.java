package org.rkoubsky.examples.designpatterns.structural.proxy.dynamic.matchmaking.handlers;

import org.rkoubsky.examples.designpatterns.structural.proxy.dynamic.matchmaking.persons.PersonBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class NonOwnerInvocationHandler implements InvocationHandler {
    private final PersonBean person;

    public NonOwnerInvocationHandler(final PersonBean person) {
        this.person = person;
    }

    @Override
    public Object invoke(final Object proxy, final Method method,
            final Object[] args) throws IllegalAccessException, InvocationTargetException {
        if (method.getName().startsWith("set") && !"setHotOrNotRating".equals(method.getName())) {
            throw new IllegalAccessException(
                    "A person cannot set attributes of another person, only rating can be set from others.");
        }
        return method.invoke(this.person, args);
    }
}
