package com.lukashevich.shop.model;

import java.util.Date;

public class Address extends BaseModel {

    private String country;
    private String city;
    private String street;
    private String apartments;
    private String post_code;
    private String phone_number;

    public Address(Long id, Date dateOfAdding, String country, String city, String street, String apartments, String post_code, String phone_number) {
        super(id, dateOfAdding);
        this.country = country;
        this.city = city;
        this.street = street;
        this.apartments = apartments;
        this.post_code = post_code;
        this.phone_number = phone_number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getApartments() {
        return apartments;
    }

    public void setApartments(String apartments) {
        this.apartments = apartments;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
