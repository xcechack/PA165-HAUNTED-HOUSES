/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.dao.jpa;

import com.mycompany.hauntedhauses.entity.House;
import com.mycompany.hauntedhauses.dao.HouseDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 *
 * @author Gabriela Podolnikova
 */

@Controller
@Transactional
public class HouseDAOImpl implements HouseDAO{
    
    //private EntityManagerFactory emf =
    //        Persistence.createEntityManagerFactory("HouseDB");
    //private EntityManager em = emf.createEntityManager();
    
    @Autowired
    EntityManager em;
    
    /*private final EntityManagerFactory emf;

    public HouseDAOImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }*/
    public EntityManager getEntityManager() {
        return em;
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    public void addHouse(House house){
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
        //EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            House toBeRemoved = em.merge(house);
            em.remove(toBeRemoved);
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
        //EntityManager em = emf.createEntityManager();
        /*House h;
        try {
            h = em.find(House.class, house.getId());
        } catch (IllegalArgumentException ex) {
            throw new PersistenceException("Transaction failed. \n" + ex.getMessage(), ex);
        }*/
        try {
            em.getTransaction().begin();
            //h.setAddress(house.getAddress());
            //h.setHauntedFrom(house.getHauntedFrom());
            //h.setHistory(house.getHistory());
            //h.setName(house.getName());
            //h.setResidents(house.getResidents());
            em.merge(house);
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
        //EntityManager em = emf.createEntityManager();
        //List<House> houses = em.createNamedQuery("getAllHouses",House.class).getResultList();
        Query query = em.createQuery("select h from House h");
        return query.getResultList();
        //return houses;
    }
    
    public House getHouseById(long id) {
        //EntityManager em = emf.createEntityManager();
        House house;
        house = em.find(House.class, id);
        return house;
    }
}
