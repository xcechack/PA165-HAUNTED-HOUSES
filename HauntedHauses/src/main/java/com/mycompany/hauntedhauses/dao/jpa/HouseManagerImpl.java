/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.dao.jpa;

import com.mycompany.hauntedhauses.entity.House;
import com.mycompany.hauntedhauses.dao.HouseManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 *
 * @author Gabriela Podolnikova
 */

public class HouseManagerImpl implements HouseManager{
    
    //private EntityManagerFactory emf =
    //        Persistence.createEntityManagerFactory("HouseDB");
    //private EntityManager em = emf.createEntityManager();
    
    private final EntityManagerFactory emf;

    public HouseManagerImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public void addHouse(House house){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(house);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new PersistenceException("Transaction failed. \n" + ex.getMessage(), ex);
        } finally {
            if (em!=null) {
                em.close();
            }
        }
    }
    
    public void deleteHouse(House house) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(house);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new PersistenceException("Transaction failed. \n" + ex.getMessage(), ex);
        } finally {
             if (em!=null) {
                em.close();
            }
        }
    }
    
    public void updateHouse(House house) {
        EntityManager em = emf.createEntityManager();
        House h;
        try {
            h = em.find(House.class, house.getId());
        } catch (IllegalArgumentException ex) {
            throw new PersistenceException("Transaction failed. \n" + ex.getMessage(), ex);
        }
        try {
            em.getTransaction().begin();
            h.setAddress(house.getAddress());
            h.setHauntedFrom(house.getHauntedFrom());
            h.setHistory(house.getHistory());
            h.setName(house.getName());
            h.setResidents(house.getResidents());
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new PersistenceException("Transaction failed. \n" + ex.getMessage(), ex);
        } finally {
            if (em!=null) {
                em.close();
            }
        }
            
        
    }
    
    public List<House> getAllHouses() {
        EntityManager em = emf.createEntityManager();
        List<House> houses = em.createNamedQuery("getAllHouses",House.class).getResultList();
        return houses;
    }
    
    public House getHouseById(long id) {
        EntityManager em = emf.createEntityManager();
        House house;
        try {
            house = em.find(House.class, id);
        } catch (IllegalArgumentException ex) {
            throw new PersistenceException("Transaction failed. \n" + ex.getMessage(), ex);
        }
        return house;
    }
}
