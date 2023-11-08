package com.lukashevich.shop.model;

import java.util.Date;

public class Address extends BaseModel {
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer apartmentNumber;

    public Address() {
    }

    public Address(Long id, Date dateOfAdding, String city, String street, Integer houseNumber, Integer apartmentNumber) {
        super(id, dateOfAdding);
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public Address(Long id, Date dateOfAdding, String city, String street, Integer houseNumber) {
        super(id, dateOfAdding);
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public Integer getApartmentNumber() {
        return apartmentNumber;
    }
}
