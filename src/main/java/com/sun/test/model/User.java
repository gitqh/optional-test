package com.sun.test.model;

import java.util.Optional;

/**
 * @author hqu
 */
public class User {
    private Address address;

    public Optional<Address> getAddressAsOptional() {
        return Optional.ofNullable(address);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
