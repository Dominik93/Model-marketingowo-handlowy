/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.model.workplace;

import com.slusarzwozniak.model.Address;
import javax.persistence.Entity;

/**
 *
 * @author Dominik
 */

@Entity
public class Shop extends Workplace{

    public Shop() {
    }

    public Shop(Address address, Float rent) {
        this.address = address;
        this.rent = rent;
    }
        
    
}
