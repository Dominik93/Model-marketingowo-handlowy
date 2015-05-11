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
        ArrayList<String> usersList = new ArrayList();
        MenageWorker menageWorker = new MenageWorker();
        //menageWorker.getWorkers();
        String[] users = new String[usersList.size()];
        users = usersList.toArray(users);
        return users;
    }
    
    public boolean checkUser() {
        return true;
    }
    
}
