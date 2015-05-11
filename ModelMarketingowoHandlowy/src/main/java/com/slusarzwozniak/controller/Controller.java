/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.controller;

import com.slusarzwozniak.model.Model;
import com.slusarzwozniak.view.Login;
import com.slusarzwozniak.view.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Dominik
 */
public class Controller {
    
    private final Model model;
    private MainWindow mainWindow;
    private Login login;
    
    public Controller(Model model, Login basicJFrame) {
        this.model = model;
        this.login = basicJFrame;
        this.model.attach(login);
        this.model.notification();
    }

    public void start() {
        this.login.setVisible(true);
        this.registerLoginEvents();
    }
    
    private void registerLoginEvents(){
        this.login.jButtonLoginActionPerformed(new jButtonLogin());
    }
    
    
    private class jButtonLogin implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(model.checkUser()){
                login.dispose();
                mainWindow = new MainWindow();
                mainWindow.setVisible(true);
            }
        }
    
    }
}
