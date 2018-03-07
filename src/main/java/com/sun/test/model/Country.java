package com.sun.test.model;

import java.util.Optional;

/**
 * @author hqu
 */
public class Country {
    private City city;

    public Optional<City> getCityAsOptional() {
        return Optional.ofNullable(city);
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
