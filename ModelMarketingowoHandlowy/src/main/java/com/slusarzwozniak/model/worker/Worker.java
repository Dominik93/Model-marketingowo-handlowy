/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.model.worker;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


/**
 *
 * @author Dominik
 */
public class Worker {
    
    @Id  @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @OneToOne
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
