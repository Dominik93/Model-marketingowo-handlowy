/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.interfaces;

import com.slusarzwozniak.model.Model;

/**
 *
 * @author Dominik
 */
public interface IObserver {
    
    abstract void update(Model model);
}
