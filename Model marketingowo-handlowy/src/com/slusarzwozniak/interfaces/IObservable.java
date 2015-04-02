/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.interfaces;

import com.slusarzwozniak.view.BasicJFrame;

/**
 *
 * @author Dominik
 */
public interface IObservable {
    
    abstract void attach(BasicJFrame view);
    abstract void detach(BasicJFrame view);
    abstract void notify();
    
}
