package org.rkoubsky.examples.designpatterns.structural.proxy.dynamic.matchmaking.persons;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class PersonBeanImpl implements PersonBean {
    private String name;
    private String gender;
    private String interests;
    private int rating;
    private int ratingCount = 0;

    public PersonBeanImpl(final String name, final String gender, final String interests, final int rating) {
        this.name = name;
        this.gender = gender;
        this.interests = interests;
        this.rating = rating;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String getGender() {
        return this.gender;
    }

    @Override
    public int getHotOrNotRating() {
        final int rating;
        if (this.ratingCount == 0) {
            rating = 0;
        } else {
            rating = this.rating / this.ratingCount;
        }
        return rating;
    }

    @Override
    public void setGender(final String gender) {
        this.gender = gender;
    }

    @Override
    public String getInterests() {
        return this.interests;
    }

    @Override
    public void setInterests(final String interests) {
        this.interests = interests;
    }

    @Override
    public void setHotOrNotRating(final int rating) {
        this.rating += rating;
        this.ratingCount++;
    }
}
