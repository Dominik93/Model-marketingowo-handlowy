/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.controller;

import com.slusarzwozniak.model.Model;
import com.slusarzwozniak.view.BasicJFrame;
import com.slusarzwozniak.view.MainWindow;

/**
 *
 * @author Dominik
 */
public class Controller {
    
    private final Model model;
    private BasicJFrame mainWindow;
    
    public Controller(Model model, BasicJFrame basicJFrame) {
        this.model = model;
        this.mainWindow = basicJFrame;
        model.attach(mainWindow);
    }

    public void start() {
        mainWindow.setVisible(true);
    }
    
}
