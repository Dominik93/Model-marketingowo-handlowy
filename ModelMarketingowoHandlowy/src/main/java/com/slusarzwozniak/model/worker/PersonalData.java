/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.model.worker;

import com.slusarzwozniak.model.Address;
import javax.persistence.Entity;

/**
 *
 * @author Dominik
 */

@Entity
public class PersonalData {
    
    private Integer id;
    private Address address;
    private String name;
    private String surname;
    private String phoneNumber;
    private String emailAddress;

    public PersonalData() {
    }

    public PersonalData(Address address, String name, String surname, String phoneNumber, String emailAddress) {
        this.address = address;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "PersonalData{" + "id=" + id + ", address=" + address + ", name=" + name + ", surname=" + surname + ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress + '}';
    }
    
}
