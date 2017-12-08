package org.rkoubsky.examples.designpatterns.structural.proxy.dynamic.matchmaking;

import org.rkoubsky.examples.designpatterns.structural.proxy.dynamic.matchmaking.handlers.NonOwnerInvocationHandler;
import org.rkoubsky.examples.designpatterns.structural.proxy.dynamic.matchmaking.handlers.OwnerInvocationHandler;
import org.rkoubsky.examples.designpatterns.structural.proxy.dynamic.matchmaking.persons.PersonBean;
import org.rkoubsky.examples.designpatterns.structural.proxy.dynamic.matchmaking.persons.PersonBeanImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class MatchMakingTestDrive {
    final static Logger logger = LoggerFactory.getLogger(MatchMakingTestDrive.class);

    public static void main(final String[] args) {
        final PersonBean radek = new PersonBeanImpl("Radek", "Male", "Dancing", 0);
        final PersonBean ownerProxy = getOwnerProxy(radek);
        System.out.println("Calling operation on owner proxy...");
        System.out.printf("Person name: %s\n", ownerProxy.getName());
        ownerProxy.setInterests("Dancing: Salsa, Kizomba");
        System.out.println("Interests set from owner proxy.");
        try {
            ownerProxy.setHotOrNotRating(5);
        } catch (final Exception e) {
            logger.error("Calling operation on owner proxy failed.", e);
        }
        System.out.printf("Person Rating: %s\n", ownerProxy.getHotOrNotRating());

        final PersonBean nonOwnerProxy = getNonOwnerProxy(radek);
        System.out.println("Calling operation on non owner proxy...");
        System.out.printf("Person name: %s\n", nonOwnerProxy.getName());
        try {
            nonOwnerProxy.setInterests("Dancing: Bachata");
        } catch (final Exception e) {
            logger.error("Calling operation on non owner proxy failed.", e);
        }
        nonOwnerProxy.setHotOrNotRating(13);
        System.out.println("Rating set from non owner proxy.");
        System.out.printf("Person Rating: %s\n", nonOwnerProxy.getHotOrNotRating());


    }

    private static PersonBean getOwnerProxy(final PersonBean person) {
        return (PersonBean) Proxy
                .newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(),
                        new OwnerInvocationHandler(person));
    }

    private static PersonBean getNonOwnerProxy(final PersonBean person) {
        return (PersonBean) Proxy
                .newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(),
                        new NonOwnerInvocationHandler(person));
    }
}
