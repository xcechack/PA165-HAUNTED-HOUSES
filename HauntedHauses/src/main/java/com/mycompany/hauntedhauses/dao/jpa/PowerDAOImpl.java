/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.dao.jpa;


import com.mycompany.hauntedhauses.dao.PowerDAO;
import com.mycompany.hauntedhauses.entity.Ghost;
import com.mycompany.hauntedhauses.entity.Power;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Michal Zbranek
 */
public class PowerDAOImpl implements PowerDAO{

    private EntityManagerFactory entityManagerFactory;
    private EntityManager manager;
    
    public PowerDAOImpl(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
        manager = this.entityManagerFactory.createEntityManager();
    }

    public void addPower(Power power) {
      
       try{
           manager.getTransaction().begin();
           manager.persist(power);
           manager.getTransaction().commit();
           
       }
       catch(Exception ex){
           throw new PersistenceException("Transaction failed.\n" + ex.getMessage(), ex);       
       }
    }

    public void updatePower(Power power) {
        try{
            manager.getTransaction().begin();
            manager.merge(power);
            manager.getTransaction().commit();
        }
        catch (Exception ex){
            throw new PersistenceException("Transaction failed.\n" + ex.getMessage(),ex);
        }
    }

    public void deletePower(Power power) {
        try{
            manager.getTransaction().begin();
            manager.remove(power);
            manager.getTransaction().commit();
        }
        catch(Exception ex){
            throw new PersistenceException("Transaction failed.\n"+ex.getMessage(), ex);
        }
    }

    public List<Power> getAllPowers() {
        Query query = manager.createQuery("select a from Power a");
        return query.getResultList();
        
           }

    public Power getPowerByID(long id) {
        return manager.find (Power.class, id);   
        }
    
}
