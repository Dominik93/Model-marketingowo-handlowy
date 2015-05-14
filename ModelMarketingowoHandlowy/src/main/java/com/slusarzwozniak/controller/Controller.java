/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.controller;

import com.slusarzwozniak.model.Address;
import com.slusarzwozniak.model.Model;
import com.slusarzwozniak.model.worker.PersonalData;
import com.slusarzwozniak.model.worker.Worker;
import com.slusarzwozniak.model.workplace.Shop;
import com.slusarzwozniak.model.workplace.Werehouse;
import com.slusarzwozniak.model.workplace.Workplace;
import com.slusarzwozniak.view.AddWorkerJFrame;
import com.slusarzwozniak.view.AddWorkplaceJFrame;
import com.slusarzwozniak.view.Login;
import com.slusarzwozniak.view.MainWindow;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Dominik
 */
public class Controller {
    
    private final Model model;
    private MainWindow mainWindow;
    private Login login;
    private AddWorkerJFrame addWorkerJFrame;
    private AddWorkplaceJFrame addWorkplaceJFrame;
    
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
        this.mainWindow.jButtonAddWerehouseActionPerformed(new jButtonAddWerehouse());
        this.mainWindow.jButtonAddShopActionPerformed(new jButtonAddShop());
    }
    
    private void registerAddWorkerEvents(){
        addWorkerJFrame.jButtonSaveActionPerformed(new jButtonSaveWorker());
        addWorkerJFrame.jButtonCancelActionPerformed(new jButtonCancel());
    }
    
    private void registerAddWorkplaceEvents(){
        addWorkplaceJFrame.jButtonSaveActionPerformed(new jButtonSaveWorkplace());
        addWorkplaceJFrame.jButtonCancelActionPerformed(new jButtonCancel());
    }
    
    private class jButtonLogin implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            model.detach(login);
            login.dispose();
            /*
            if(model.checkWorker(login.getjComboBoxUsers().getSelectedItem().toString())){
                model.setWorker(model.getWerehouseWorker(login.getjComboBoxUsers().getSelectedItem().toString()));
            }else{
                model.setWorker(model.getShopWorker(login.getjComboBoxUsers().getSelectedItem().toString()));
            }
            */
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
    
    private class jButtonAddWerehouse implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            addWorkplaceJFrame = new AddWorkplaceJFrame(Werehouse.class);
            model.attach(addWorkplaceJFrame);
            model.notification();
            registerAddWorkplaceEvents();
            addWorkplaceJFrame.setVisible(true);
        }
    
    }
    
    private class jButtonAddShop implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            addWorkplaceJFrame = new AddWorkplaceJFrame(Shop.class);
            model.attach(addWorkplaceJFrame);
            model.notification();
            registerAddWorkplaceEvents();
            addWorkplaceJFrame.setVisible(true);
        }
    
    }
    
    private class jButtonCancel implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Component component = (Component) e.getSource();
            JFrame frame = (JFrame) SwingUtilities.getRoot(component);
            frame.dispose();
        }
    
    }
    
    private class jButtonSaveWorker implements ActionListener{

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
                model.notification();
                addWorkerJFrame.dispose();
            }
        }
    }
    
    private class jButtonSaveWorkplace implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean save = true;
            if(addWorkplaceJFrame.getjTextFieldCity().getText().equals("")){
                addWorkplaceJFrame.getjTextFieldCity().setBackground(Color.red);
                addWorkplaceJFrame.getjTextFieldCity().setOpaque(false);
                save = false;
            }
            else{
                addWorkplaceJFrame.getjTextFieldCity().setBackground(Color.green);
            }
            if(addWorkplaceJFrame.getjTextFieldBuildingNumber().getText().equals("")){
                addWorkplaceJFrame.getjTextFieldBuildingNumber().setBackground(Color.red);
                addWorkplaceJFrame.getjTextFieldBuildingNumber().setOpaque(false);
                save = false;
            }
            else{
                addWorkplaceJFrame.getjTextFieldBuildingNumber().setBackground(Color.green);
            }
            if(addWorkplaceJFrame.getjTextFieldStreet().getText().equals("")){
                addWorkplaceJFrame.getjTextFieldStreet().setBackground(Color.red);
                addWorkplaceJFrame.getjTextFieldStreet().setOpaque(false);
                save = false;
            }
            else{
                addWorkplaceJFrame.getjTextFieldStreet().setBackground(Color.green);
            }
            if(addWorkplaceJFrame.getjTextFieldZipCode().getText().equals("")){
                addWorkplaceJFrame.getjTextFieldZipCode().setBackground(Color.red);
                addWorkplaceJFrame.getjTextFieldZipCode().setOpaque(false);
                save = false;
            }
            else{
                addWorkplaceJFrame.getjTextFieldZipCode().setBackground(Color.green);
            }
            if(save){
                Address address = new Address(addWorkplaceJFrame.getjTextFieldStreet().getText(),
                        Integer.valueOf(addWorkplaceJFrame.getjTextFieldBuildingNumber().getText()),
                        addWorkplaceJFrame.getjTextFieldCity().getText(),
                        addWorkplaceJFrame.getjTextFieldZipCode().getText());
                Workplace workplace = null; 
                if(addWorkplaceJFrame.getC().equals(Shop.class))        
                        workplace = new Shop(address, Float.valueOf(addWorkplaceJFrame.getjSpinnerRent().getValue().toString()));
                else if(addWorkplaceJFrame.getC().equals(Werehouse.class))   
                        workplace = new Werehouse(address, Float.valueOf(addWorkplaceJFrame.getjSpinnerRent().getValue().toString()));
                model.addWorkplace(workplace, addWorkplaceJFrame.getC());
                model.notification();
                addWorkplaceJFrame.dispose();
            }
        }
    }
}
