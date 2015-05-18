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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    
    // <editor-fold defaultstate="collapsed" desc="Register">             
    private void registerLoginEvents(){
        this.login.jButtonLoginActionPerformed(new JButtonLogin());
    }
    
    private void registerMainEvents(){
        this.mainWindow.jButtonAddWorkerActionPerformed(new JButtonAddWorker());
        this.mainWindow.jButtonAddWerehouseActionPerformed(new JButtonAddWerehouse());
        this.mainWindow.jButtonAddShopActionPerformed(new JButtonAddShop());
        this.mainWindow.jTableWorkerAddListSelection(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON3)
                        mainWindow.getjPopupMenuWorker().show(mainWindow, e.getLocationOnScreen().x, e.getLocationOnScreen().y);
             }
        });
        this.mainWindow.jMenuItemDeleteActionPerformed(new JMenuItemDelete());
    }
    
    private void registerAddWorkerEvents(){
        addWorkerJFrame.jButtonSaveActionPerformed(new JButtonSaveWorker());
        addWorkerJFrame.jButtonCancelActionPerformed(new JButtonCancel());
    }
    
    private void registerAddWorkplaceEvents(){
        addWorkplaceJFrame.jButtonSaveActionPerformed(new JButtonSaveWorkplace());
        addWorkplaceJFrame.jButtonCancelActionPerformed(new JButtonCancel());
    }
    // </editor-fold>
    
    private class JButtonLogin implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            model.detach(login);
            login.dispose();
            model.setLoggedWorker(model.getWorker(Integer.valueOf(login.getjComboBoxUsers().getSelectedItem().toString().split(" ")[0])));
            mainWindow = new MainWindow();
            model.attach(mainWindow);
            model.notification();
            registerMainEvents();
            mainWindow.setVisible(true);
        }
    
    }
    
    private class JMenuItemDelete implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Worker worker = model.getWorker(mainWindow.getjTableWorkers().getValueAt(mainWindow.getjTableWorkers().getSelectedRow(), 0));
            model.deleteWorker(worker);
            model.notification();
        }
    
    }
    
    private class JButtonAddWorker implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            addWorkerJFrame = new AddWorkerJFrame();
            model.attach(addWorkerJFrame);
            model.notification();
            registerAddWorkerEvents();
            addWorkerJFrame.setVisible(true);
        }
    
    }
    
    private class JButtonAddWerehouse implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            addWorkplaceJFrame = new AddWorkplaceJFrame(Werehouse.class);
            model.attach(addWorkplaceJFrame);
            model.notification();
            registerAddWorkplaceEvents();
            addWorkplaceJFrame.setVisible(true);
        }
    
    }
        
    private class JButtonAddShop implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            addWorkplaceJFrame = new AddWorkplaceJFrame(Shop.class);
            model.attach(addWorkplaceJFrame);
            model.notification();
            registerAddWorkplaceEvents();
            addWorkplaceJFrame.setVisible(true);
        }
    
    }
    
    private class JButtonCancel implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Component component = (Component) e.getSource();
            JFrame frame = (JFrame) SwingUtilities.getRoot(component);
            frame.dispose();
        }
    
    }
    
    private class JButtonSaveWorker implements ActionListener{

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
    
    private class JButtonSaveWorkplace implements ActionListener{

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
