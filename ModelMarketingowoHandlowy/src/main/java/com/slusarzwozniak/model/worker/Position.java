/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.model.worker;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Dominik
 */
public class Position {
    
    @Id
    @GeneratedValue
    @Column(name = "ID")
    Integer id;
    
    @Column(name = "Name")
    String name;
    
    @Column(name = "Bid")
    Float bid;

    public Position() {
    }

    public Position(String name, Float bid) {
        this.name = name;
        this.bid = bid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getBid() {
        return bid;
    }

    public void setBid(Float bid) {
        this.bid = bid;
    }
    
    
}
