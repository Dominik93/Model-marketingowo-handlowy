/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.controller;

import com.slusarzwozniak.model.Address;
import com.slusarzwozniak.model.Model;
import com.slusarzwozniak.model.PersonalData;
import com.slusarzwozniak.model.Worker;
import com.slusarzwozniak.view.AddWorkerJFrame;
import com.slusarzwozniak.view.Login;
import com.slusarzwozniak.view.MainWindow;
import java.awt.Color;
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
    private AddWorkerJFrame addWorkerJFrame;
    
    public Controller(Model model, Login loginJFrame) {
        this.model = model;
        this.login = loginJFrame;
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
    
    private void registerMainEvents(){
        this.mainWindow.jButtonAddWorkerActionPerformed(new jButtonAddWorker());
    }
    
    private void registerAddWorkerEvents(){
        addWorkerJFrame.jButtonSaveActionPerformed(new jButtonSave());
    }
    
    private class jButtonLogin implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            model.detach(login);
            login.dispose();
            if(model.checkWorker(login.getjComboBoxUsers().getSelectedItem().toString())){
                model.setWorker(model.getWerehouseWorker(login.getjComboBoxUsers().getSelectedItem().toString()));
            }else{
                model.setWorker(model.getShopWorker(login.getjComboBoxUsers().getSelectedItem().toString()));
            }
            mainWindow = new MainWindow();
            model.attach(mainWindow);
            model.notification();
            registerMainEvents();
            mainWindow.setVisible(true);
        }
    
    }
    
    private class jButtonAddWorker implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            addWorkerJFrame = new AddWorkerJFrame();
            model.attach(addWorkerJFrame);
            model.notification();
            registerAddWorkerEvents();
            addWorkerJFrame.setVisible(true);
        }
    
    }
    
    private class jButtonSave implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean save = true;
            if(addWorkerJFrame.getjTextFieldCity().getText().equals("")){
                addWorkerJFrame.getjTextFieldCity().setBackground(Color.red);
                addWorkerJFrame.getjTextFieldCity().setOpaque(false);
                save = false;
            }
            else{
                addWorkerJFrame.getjTextFieldCity().setBackground(Color.green);
            }
            if(addWorkerJFrame.getjTextFieldBuildingNumber().getText().equals("")){
                addWorkerJFrame.getjTextFieldBuildingNumber().setBackground(Color.red);
                addWorkerJFrame.getjTextFieldBuildingNumber().setOpaque(false);
                save = false;
            }
            else{
                addWorkerJFrame.getjTextFieldBuildingNumber().setBackground(Color.green);
            }
            if(addWorkerJFrame.getjTextFieldEmail().getText().equals("")){
                addWorkerJFrame.getjTextFieldEmail().setBackground(Color.red);
                addWorkerJFrame.getjTextFieldEmail().setOpaque(false);
                save = false;
            }
            else{
                addWorkerJFrame.getjTextFieldEmail().setBackground(Color.green);
            }
            if(addWorkerJFrame.getjTextFieldName().getText().equals("")){
                addWorkerJFrame.getjTextFieldName().setBackground(Color.red);
                addWorkerJFrame.getjTextFieldName().setOpaque(false);
                save = false;
            }
            else{
                addWorkerJFrame.getjTextFieldName().setBackground(Color.green);
            }
            if(addWorkerJFrame.getjTextFieldPhone().getText().equals("")){
                addWorkerJFrame.getjTextFieldPhone().setBackground(Color.red);
                addWorkerJFrame.getjTextFieldPhone().setOpaque(false);
                save = false;
            }
            else{
                addWorkerJFrame.getjTextFieldPhone().setBackground(Color.green);
            }
            if(addWorkerJFrame.getjTextFieldStreet().getText().equals("")){
                addWorkerJFrame.getjTextFieldStreet().setBackground(Color.red);
                addWorkerJFrame.getjTextFieldStreet().setOpaque(false);
                save = false;
            }
            else{
                addWorkerJFrame.getjTextFieldStreet().setBackground(Color.green);
            }
            if(addWorkerJFrame.getjTextFieldSurname().getText().equals("")){
                addWorkerJFrame.getjTextFieldSurname().setBackground(Color.red);
                addWorkerJFrame.getjTextFieldSurname().setOpaque(false);
                save = false;
            }
            else{
                addWorkerJFrame.getjTextFieldSurname().setBackground(Color.green);
            }
            if(addWorkerJFrame.getjTextFieldZipCode().getText().equals("")){
                addWorkerJFrame.getjTextFieldZipCode().setBackground(Color.red);
                addWorkerJFrame.getjTextFieldZipCode().setOpaque(false);
                save = false;
            }
            else{
                addWorkerJFrame.getjTextFieldZipCode().setBackground(Color.green);
            }
            if(save){
                Address address = new Address(addWorkerJFrame.getjTextFieldStreet().getText(),
                        Integer.valueOf(addWorkerJFrame.getjTextFieldBuildingNumber().getText()),
                        addWorkerJFrame.getjTextFieldCity().getText(),
                        addWorkerJFrame.getjTextFieldZipCode().getText());
                PersonalData personalData = new PersonalData(address,
                        addWorkerJFrame.getjTextFieldName().getText(),
                        addWorkerJFrame.getjTextFieldSurname().getText(), 
                        addWorkerJFrame.getjTextFieldPhone().getText(),
                        addWorkerJFrame.getjTextFieldEmail().getText());
                model.addWorker(new Worker(personalData));
            }
        }
    
    }
}
