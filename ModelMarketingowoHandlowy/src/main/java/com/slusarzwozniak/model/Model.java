/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.model;

import com.slusarzwozniak.model.worker.Position;
import com.slusarzwozniak.model.worker.Worker;
import com.slusarzwozniak.interfaces.IObservable;
import com.slusarzwozniak.model.hibernate.MenagerWorker;
import com.slusarzwozniak.model.hibernate.MenagerWorkplace;
import com.slusarzwozniak.model.workplace.Workplace;
import com.slusarzwozniak.view.BasicJFrame;
import com.slusarzwozniak.view.PositionAbstractTableModel;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Dominik
 */
public class Model implements IObservable{
    
    private final ArrayList<BasicJFrame> views = new ArrayList<>();
    private MenagerWorker menagerWorker;
    
    private Worker loggedWorker;
    
    public Model() throws ClassNotFoundException{
    }

    public Worker getLoggedWorker() {
        return loggedWorker;
    }

    public void setLoggedWorker(Worker loggedWorker) {
        this.loggedWorker = loggedWorker;
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
        tableModel.addColumn("Phone");
        tableModel.addColumn("Email");
        tableModel.addColumn("Address");
        menagerWorker = new MenagerWorker();
        ArrayList<Worker> workersList = menagerWorker.getWorkers();
        for(Worker w : workersList){
            vector = new Vector();
            vector.add(w.getId());
            vector.add(w.getPersonalData().getName());
            vector.add(w.getPersonalData().getSurname());
            vector.add(w.getPersonalData().getPhoneNumber());
            vector.add(w.getPersonalData().getEmailAddress());
            vector.add(w.getPersonalData().getAddress().toString());
            tableModel.addRow(vector);
        }
        menagerWorker.closeSession();
        return tableModel;
    }
    
    public DefaultComboBoxModel workersToComboBox(){
       menagerWorker = new MenagerWorker();
       ArrayList<Worker> workersList = menagerWorker.getWorkers();
       String[] workers = new String[workersList.size()];
       for(int i = 0; i < workers.length; i++)
           workers[i] = workersList.get(i).getId() + " "
                   + workersList.get(i).getPersonalData().getName() + " "
                   + workersList.get(i).getPersonalData().getSurname();
       menagerWorker.closeSession();
       return new DefaultComboBoxModel(workers);
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

    public DefaultComboBoxModel positionToComboBox(){
       menagerWorker = new MenagerWorker();
       ArrayList<Position> positionsList = menagerWorker.getPositions();
       String[] positions = new String[positionsList.size()];
       for(int i = 0; i < positions.length; i++)
           positions[i] = positionsList.get(i).getId() + " " + positionsList.get(i).getName();
       menagerWorker.closeSession();
       return new DefaultComboBoxModel(positions);
    }
    
    public Worker getShopWorker(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Worker getWerehouseWorker(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TableModel positionsToTable() {
        PositionAbstractTableModel tableModel = new PositionAbstractTableModel();
        menagerWorker = new MenagerWorker();
        String[] columnNames = {"Position", " "};
        ArrayList<Position> positionsList = menagerWorker.getPositions();
        Object[][] columnDate = new Object[positionsList.size()][2];
        for(int i = 0; i < positionsList.size(); i++){
            columnDate[i][0] = positionsList.get(i).getName();
            columnDate[i][1] = Boolean.FALSE;
        }
        tableModel.setColumnNames(columnNames);
        tableModel.setRowData(columnDate);
        menagerWorker.closeSession();
        return tableModel;
    }

    public TableModel workplacesToTable(Class c) {
        DefaultTableModel tableModel = new DefaultTableModel();
        Vector vector;
        tableModel.addColumn("ID");
        tableModel.addColumn("Address");
        tableModel.addColumn("Rent");
        MenagerWorkplace menagerWorkplace = new MenagerWorkplace();
        ArrayList<Workplace> workplacesList = menagerWorkplace.getWorkplaces(c);
        for(Workplace w : workplacesList){
            vector = new Vector();
            vector.add(w.getId());
            vector.add(w.getAddress().toString());
            vector.add(w.getRent());
            tableModel.addRow(vector);
        }
        menagerWorkplace.closeSession();
        return tableModel;
    }

    public void addWorkplace(Workplace workplace, Class c) {
        new MenagerWorkplace().addWorkplace(workplace, c);
    }

    public Worker getWorker(Object valueAt) {
       menagerWorker = new MenagerWorker();
       Worker worker = menagerWorker.getWorker((int)valueAt);
       menagerWorker.closeSession();
       return worker;
    }

    public boolean deleteWorker(Worker worker) {
        return new MenagerWorker().deleteWorker(worker);
    }
    
}
