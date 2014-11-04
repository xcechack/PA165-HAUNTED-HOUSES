/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.dao.jpa;

import com.mycompany.hauntedhauses.dao.PowerDAO;
import com.mycompany.hauntedhauses.service.Power;
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

    EntityManagerFactory entityManagerFactory;

    public PowerDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    /**
     *
     * @param power to be inserted to the database
     */
    public void addPower(Power power) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(power);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed." + e.getMessage(), e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    
    /**
     *
     * @param power to be updated
     */
    public void updatePower(Power power) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(power);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed." + e.getMessage(), e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    /**
     *
     * @param power to be deleted
     */
    public void deletePower(Power power) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        if (entityManager.find(Power.class, power.getId()) != null) {  
            try {
                entityManager.getTransaction().begin();
                Power toBeRemoved = entityManager.merge(power);
                entityManager.remove(toBeRemoved);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                throw new PersistenceException("Transaction failed." + e.getMessage(), e);
            } finally {
                    entityManager.close();
            }
        }
        else {
            System.out.println("Power with ID:" + power.getId() + "is not in the database.");
        }
    }

    /**
     *
     * @return List of all powers in the database
     */
    public List<Power> getAllPowers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        List<Power> powers;
         try {
                entityManager.getTransaction().begin();
                Query query = entityManager.createQuery("SELECT p FROM Power p");
                powers = query.getResultList();
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                throw new PersistenceException("Transaction failed." + e.getMessage(), e);
            } finally {
                entityManager.close();
            }  
        return powers;
        
    }

    /**
     *
     * @param id of power
     * @return power with the id from parameter
     */
    public Power getPowerByID(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Power r;
        
            try {
                entityManager.getTransaction().begin();
                r = entityManager.find(Power.class, id);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                throw new PersistenceException("Transaction failed." + e.getMessage(), e);
            } finally {
                entityManager.close();
            }  
        return r;
    }
    
}