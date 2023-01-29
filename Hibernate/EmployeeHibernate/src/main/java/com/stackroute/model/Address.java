package com.stackroute.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;


@Embeddable
public class Address {

    private int houseNumber;


    private String city;

    private String street;

    public Address() {
    }

    public Address(int houseNumber, String city, String street) {
        this.houseNumber = houseNumber;
        this.city = city;
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber=" + houseNumber +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
