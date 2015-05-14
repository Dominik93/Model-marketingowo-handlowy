/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.model.workplace;

import com.slusarzwozniak.model.Address;

/**
 *
 * @author Dominik
 */
public class Workplace {
    
    Integer id;
    Address address;
    Float rent; 
    
    public Workplace() {
    }

    public Workplace(Address address, Float rent) {
        this.address = address;
        this.rent = rent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Float getRent() {
        return rent;
    }

    public void setRent(Float rent) {
        this.rent = rent;
    }
    
}
