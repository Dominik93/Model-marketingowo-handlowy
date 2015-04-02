/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.controller;

import com.slusarzwozniak.model.Model;
import com.slusarzwozniak.view.MainWindow;

/**
 *
 * @author Dominik
 */
public class Controller {
    
    private final Model model;
    private MainWindow mainWindow;
    
    public Controller(Model model) {
        this.model = model;
    }
    
    public void init(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        this.mainWindow = new MainWindow();
        // TODO: register event 
        
        // TODO: attach view to model
        
    }

    public void start() {
        this.init();
        mainWindow.setVisible(true);
    }
    
}
