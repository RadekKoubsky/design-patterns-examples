package org.rkoubsky.examples.designpatterns.structural.proxy.dynamic.matchmaking.persons;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface PersonBean {
    String getName();

    String getGender();

    String getInterests();

    int getHotOrNotRating();

    void setName(String name);

    void setGender(String gender);

    void setInterests(String interests);

    void setHotOrNotRating(int rating);
}
