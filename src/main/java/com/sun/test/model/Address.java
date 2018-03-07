package com.sun.test.model;

import java.util.Optional;

/**
 * @author hqu
 */
public class Address {
    private Country country;

    public Optional<Country> getCountryAsOptional() {
        return Optional.ofNullable(country);
    }


    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
