/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.model;

import javax.persistence.OneToOne;

/**
 *
 * @author Dominik
 */
public class Worker {
    
    private Integer id;
    private PersonalData personalData;

    public Worker() {
    }

    public Worker(PersonalData personalData) {
        this.personalData = personalData;
    }

    public Integer getId() {
        return id;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }
    
        
}
