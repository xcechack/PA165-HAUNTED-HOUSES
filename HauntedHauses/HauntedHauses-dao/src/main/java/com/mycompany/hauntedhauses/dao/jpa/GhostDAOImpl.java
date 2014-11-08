/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.dao.jpa;

import com.mycompany.hauntedhauses.dao.GhostDAO;
import com.mycompany.hauntedhauses.entity.Ghost;
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
 * @author Janicka
 */

@Controller
@Transactional
public class GhostDAOImpl implements GhostDAO{
    
    @Autowired
    EntityManager manager;
    
    /*private EntityManagerFactory entityManagerFactory;
    private EntityManager manager;
    
    public GhostDAOImpl(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
        manager = this.entityManagerFactory.createEntityManager();
    }*/
    
    public EntityManager getEntityManager() {
        return manager;
    }

    public void setEntityManager(EntityManager manager) {
        this.manager = manager;
    }

    public void addGhost(Ghost ghost) {
      
       try{
           manager.getTransaction().begin();
           manager.persist(ghost);
           manager.getTransaction().commit();
           
       }
       catch(Exception ex){
           throw new PersistenceException("Transaction failed.\n" + ex.getMessage(), ex);
           
       }
    }

    public void updateGhost(Ghost ghost) {
        try{
            manager.getTransaction().begin();
            manager.merge(ghost);
            manager.getTransaction().commit();
        }
        catch (Exception ex){
            throw new PersistenceException("Transaction failed.\n" + ex.getMessage(),ex);
        }
    }

    public void deleteGhost(Ghost ghost) {
        try{
            manager.getTransaction().begin();
            Ghost toBeRemoved = manager.merge(ghost);         
            manager.remove(toBeRemoved);
            manager.getTransaction().commit();
        }
        catch(Exception ex){
            throw new PersistenceException("Transaction failed.\n"+ex.getMessage(), ex);
        }
    }

    public List<Ghost> getAllGhosts() {
        Query query = manager.createQuery("select a from Ghost a");
        return query.getResultList();
        
        }

    public Ghost getGhostByID(long id) {
        return manager.find (Ghost.class, id);
            
        }
    
}
