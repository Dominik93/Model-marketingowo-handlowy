/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.model.hibernate;

import com.slusarzwozniak.model.worker.Position;
import com.slusarzwozniak.model.worker.PersonalData;
import com.slusarzwozniak.model.Address;
import com.slusarzwozniak.model.worker.Worker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Dominik
 */
public class MenagerWorker {
    private static SessionFactory factory; 
    Session session;
    
    public MenagerWorker(){
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);
            ex.printStackTrace();
        }
    }
    
    /* Method to CREATE an worker in the database */
    public Worker addWorker(Worker worker){
        session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            worker.getPersonalData().getAddress().setId((Integer)session.save(worker.getPersonalData().getAddress()));
            worker.getPersonalData().setId((Integer)session.save(worker.getPersonalData()));
            worker.setId((Integer)session.save(worker)); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) 
                tx.rollback();
            e.printStackTrace(); 
        } finally{
            session.close();
        }
        return worker;
    }
    
    /* Method to GET worker from the database */
    public Worker getWorker(int id){
        session = factory.openSession();
        Transaction tx = null;
        Worker w = null;
        try{
            tx = session.beginTransaction();
            List workersList = session.createQuery("FROM Worker WHERE id = "+ id).list();
            for (Iterator iteratorWorkers = workersList.iterator(); iteratorWorkers.hasNext(); ){
                Worker worker = (Worker) iteratorWorkers.next();
                Address address = new Address(worker.getPersonalData().getAddress().getStreet(),
                                                worker.getPersonalData().getAddress().getNumber(),
                                                worker.getPersonalData().getAddress().getCity(),
                                                worker.getPersonalData().getAddress().getZipCode());
                address.setId(worker.getPersonalData().getAddress().getId());
                PersonalData personalData = new PersonalData(address,
                                                worker.getPersonalData().getName(),
                                                worker.getPersonalData().getSurname(),
                                                worker.getPersonalData().getPhoneNumber(),
                                                worker.getPersonalData().getEmailAddress());
                personalData.setId(worker.getPersonalData().getId());
                w = new Worker(personalData);
                w.setId(worker.getId());
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }
        return w;
   }
    
    /* Method to GET all workers from the database */
    public ArrayList getWorkers(){
        session = factory.openSession();
        Transaction tx = null;
        ArrayList<Worker> workers = new ArrayList<>();
        try{
            tx = session.beginTransaction();
            List workersList = session.createQuery("FROM Worker").list();
            for (Iterator iteratorWorkers = workersList.iterator(); iteratorWorkers.hasNext(); ){
                Worker worker = (Worker) iteratorWorkers.next();
                Address address = new Address(worker.getPersonalData().getAddress().getStreet(),
                                                worker.getPersonalData().getAddress().getNumber(),
                                                worker.getPersonalData().getAddress().getCity(),
                                                worker.getPersonalData().getAddress().getZipCode());
                address.setId(worker.getPersonalData().getAddress().getId());
                PersonalData personalData = new PersonalData(address,
                                                worker.getPersonalData().getName(),
                                                worker.getPersonalData().getSurname(),
                                                worker.getPersonalData().getPhoneNumber(),
                                                worker.getPersonalData().getEmailAddress());
                personalData.setId(worker.getPersonalData().getId());
                Worker w = new Worker(personalData);
                w.setId(worker.getId());
                workers.add(w);
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }
        return workers;
    }

    public void closeSession() {
        session.close(); 
    }

    public ArrayList<Position> getPositions() {
        session = factory.openSession();
        Transaction tx = null;
        ArrayList<Position> positions = new ArrayList<>();
        try{
            tx = session.beginTransaction();
            List positionsList = session.createQuery("FROM Position").list();
            for (Iterator iteratorPositions = positionsList.iterator(); iteratorPositions.hasNext(); ){
                Position position = (Position) iteratorPositions.next();
                positions.add(position);
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }
        return positions;
    }

    public boolean deleteWorker(Worker worker) {
        session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            //session.delete(worker.getPersonalData().getAddress());
            //session.delete(worker.getPersonalData());
            session.delete(worker);
            tx.commit();
            return true;
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
            return false;
        }
    }
}
