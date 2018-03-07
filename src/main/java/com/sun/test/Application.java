package com.sun.test;

import com.sun.test.model.Address;
import com.sun.test.model.City;
import com.sun.test.model.Country;
import com.sun.test.model.User;
import java.util.Optional;

/**
 * @author hqu
 */
public class Application {

    private static User user = new User();
//    private static User user = buildUser();


    //print the name of the City
    //User -> Address -> Country -> City -> Name(String)
    public static void main(String[] args) {

        // 1. met NullPointerException
//        testWithNullPointerException();

        // 2. testWithIf
//        testWithIf();

        // 3. testWithOptional
        testWithOptional();
    }

    private static void testWithNullPointerException() {
        String name = user.getAddress().getCountry().getCity().getName();
        System.out.println("--------- 0.testWithNullPointerException ----------");
        System.out.println(name);
        System.out.println();
    }

    private static void testWithIf() {
        String name = null;
        if (user.getAddress() != null) {
            Address address = user.getAddress();
            if (address.getCountry() != null) {
                Country country = address.getCountry();
                if (country.getCity() != null) {
                    City city = country.getCity();
                    if (city.getName() != null) {
                        name = city.getName();
                    }
                }
            }
        }
        System.out.println("--------- 1.testWithIf ----------");
        System.out.println(name);
        System.out.println();
    }

    private static void testWithOptional() {
        String name = Optional.ofNullable(user)
                .flatMap(User::getAddressAsOptional)
                .flatMap(Address::getCountryAsOptional)
                .flatMap(Country::getCityAsOptional)
                .map(City::getName).orElse("default name");
        System.out.println("--------- 2.testWithOptional ----------");
        System.out.println(name);
        System.out.println();
    }

    private static User buildUser() {
        City city = new City();
        city.setName("Melbourne");
        Country country = new Country();
        country.setCity(city);
        Address address = new Address();
        address.setCountry(country);
        User user = new User();
        user.setAddress(address);
        return user;
    }

}
