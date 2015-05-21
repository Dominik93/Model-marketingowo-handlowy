/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.model.hibernate;

import com.slusarzwozniak.model.Address;
import com.slusarzwozniak.model.worker.PersonalData;
import com.slusarzwozniak.model.worker.Position;
import com.slusarzwozniak.model.worker.Worker;
import com.slusarzwozniak.model.workplace.Shop;
import com.slusarzwozniak.model.workplace.Werehouse;
import com.slusarzwozniak.model.workplace.Workplace;
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
public class MenagerWorkplace {
    private static SessionFactory factory; 
    Session session;
    
    public MenagerWorkplace(){
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);
            ex.printStackTrace();
        }
    }
    
    
    public void closeSession() {
        session.close(); 
    }
    
    /* Method to CREATE an workplace in the database */
    public Workplace addWorkplace(Workplace workplace, Class c){
        session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            if(c.equals(Shop.class)){
                ((Shop)workplace).getAddress().setId((Integer)session.save(((Shop)workplace).getAddress()));
                ((Shop)workplace).setId((Integer)session.save(((Shop)workplace))); 
            }
            else if(c.equals(Werehouse.class)){
                ((Werehouse)(workplace)).getAddress().setId((Integer)session.save(((Werehouse)workplace).getAddress()));
                ((Werehouse)workplace).setId((Integer)session.save(((Werehouse)workplace))); 
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) 
                tx.rollback();
            e.printStackTrace(); 
        } finally{
            session.close();
        }
        return workplace;
    }
        
    /* Method to GET all workplaces from the database */
    public ArrayList getWorkplaces(Class c){
        session = factory.openSession();
        Transaction tx = null;
        ArrayList<Workplace> workplaces = new ArrayList<>();
        try{
            tx = session.beginTransaction();
            if(c.equals(Werehouse.class)){
                List workplaceListWerehouse = session.createQuery("FROM Werehouse").list();
                for (Iterator iteratorWorkers = workplaceListWerehouse.iterator(); iteratorWorkers.hasNext(); ){
                    Werehouse workplace = (Werehouse) iteratorWorkers.next();
                    Address address = new Address(workplace.getAddress().getStreet(),
                                                    workplace.getAddress().getNumber(),
                                                    workplace.getAddress().getCity(),
                                                    workplace.getAddress().getZipCode());
                    workplace.setAddress(address);
                    workplaces.add(workplace);
                }
            }
            else if(c.equals(Shop.class)){
                List workplaceListShop = session.createQuery("FROM Shop").list();
                for (Iterator iteratorWorkers = workplaceListShop.iterator(); iteratorWorkers.hasNext(); ){
                    Shop workplace = (Shop) iteratorWorkers.next();
                    Address address = new Address(workplace.getAddress().getStreet(),
                                                    workplace.getAddress().getNumber(),
                                                    workplace.getAddress().getCity(),
                                                    workplace.getAddress().getZipCode());
                    workplace.setAddress(address);
                    workplaces.add(workplace);
                }
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }
        return workplaces;
    }
    
}
