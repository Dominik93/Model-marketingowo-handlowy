/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.model.hibernate;

import com.slusarzwozniak.model.Worker;
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
public class MenageWorker {
    private static SessionFactory factory; 
    
    public MenageWorker(){
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);
        }
    }
    
    /* Method to CREATE an worker in the database */
    public Worker addWorker(Worker worker){
        Session session = factory.openSession();
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
        }finally {
            session.close(); 
        }
        return worker;
    }
    
    public void getWorkers(){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List workers = session.createQuery("FROM Worker").list(); 
         for (Iterator iterator = workers.iterator(); iterator.hasNext();){
            Worker employee = (Worker) iterator.next(); 
            System.out.print("ID : " + employee.getId());
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
}
