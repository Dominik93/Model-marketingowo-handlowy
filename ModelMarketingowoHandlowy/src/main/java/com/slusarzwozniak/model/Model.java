/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.model;

import com.slusarzwozniak.interfaces.IObservable;
import com.slusarzwozniak.model.hibernate.MenagerWorker;
import com.slusarzwozniak.view.BasicJFrame;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dominik
 */
public class Model implements IObservable{
    
    private final ArrayList<BasicJFrame> views = new ArrayList<>();
    private MenagerWorker menagerWorker;
    
    private Worker worker;
    
    public Model() throws ClassNotFoundException{
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
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

    public DefaultTableModel workersToTable(){
        DefaultTableModel tableModel = new DefaultTableModel();
        Vector vector;
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Surname");
        menagerWorker = new MenagerWorker();
        ArrayList<Worker> workersList = menagerWorker.getWorkers();
        for(Worker w : workersList){
            vector = new Vector();
            vector.add(w.getId());
            vector.add(w.getPersonalData().getName());
            vector.add(w.getPersonalData().getSurname());
            tableModel.addRow(vector);
        }
        menagerWorker.closeSession();
        return tableModel;
    }
    
    public String[] workersToComboBox(){
       menagerWorker = new MenagerWorker();
       ArrayList<Worker> workersList = menagerWorker.getWorkers();
       String[] workers = new String[workersList.size()];
       for(int i = 0; i < workers.length; i++)
           workers[i] = workersList.get(i).getId() + " "
                   + workersList.get(i).getPersonalData().getName() + " "
                   + workersList.get(i).getPersonalData().getSurname();
       menagerWorker.closeSession();
       return workers;
    }
    

    public void addWorker(Worker worker) {
        new MenagerWorker().addWorker(worker);
    }

    public boolean checkWorker(String toString) {
        if(true){
            return true;
        }
        return false;
    }

    public Worker getShopWorker(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Worker getWerehouseWorker(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
