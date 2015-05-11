/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.model;

import com.slusarzwozniak.interfaces.IObservable;
import com.slusarzwozniak.model.hibernate.MenageWorker;
import com.slusarzwozniak.view.BasicJFrame;
import java.util.ArrayList;

/**
 *
 * @author Dominik
 */
public class Model implements IObservable{
    
    private final ArrayList<BasicJFrame> views = new ArrayList<>();
    
    public Model() throws ClassNotFoundException{
    }
    
    @Override
    public void attach(BasicJFrame view) {
        views.add(view);
    }

    @Override
    public void detach(BasicJFrame view) {
        views.remove(view);
    }

    @Override
    public void notification() {
        for(BasicJFrame view : views){
            view.update(this);
        }
    }

    public String[] getUsers(){
        ArrayList<Worker> workersList;
        MenageWorker menageWorker = new MenageWorker();
        workersList = menageWorker.getWorkers();
        String[] users = new String[workersList.size()];
        for(int i = 0; i < workersList.size(); i++){
            //users[i] = workersList.get(i).getPersonalData().getName();
        }
        return users;
    }
    
    public void addUser(){
        Address address = new Address("Ulica", 15, "miasto", "zipcode");
        PersonalData personalData = new PersonalData(address, "Imie", "Nazwisko", "tel", "email");
        Worker worker = new Worker(personalData);
        MenageWorker menageWorker = new MenageWorker();
        menageWorker.addWorker(worker);
    }
    
    public boolean checkUser() {
        return true;
    }

    public void addWorker(Worker worker) {
        new MenageWorker().addWorker(worker);
    }
    
}
