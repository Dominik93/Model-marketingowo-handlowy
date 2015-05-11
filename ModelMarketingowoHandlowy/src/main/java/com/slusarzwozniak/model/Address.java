/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.model;

/**
 *
 * @author Dominik
 */
public class Address {
    
    private Integer id;
    private String street;
    private Integer buldingNumer;
    private String city;
    private String zipCode;

    public Address() {
    }

    public Address(String street, Integer buldingNumer, String city, String zipCode) {
        this.street = street;
        this.buldingNumer = buldingNumer;
        this.city = city;
        this.zipCode = zipCode;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuldingNumer() {
        return buldingNumer;
    }

    public void setBuldingNumer(Integer buldingNumer) {
        this.buldingNumer = buldingNumer;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    
}
