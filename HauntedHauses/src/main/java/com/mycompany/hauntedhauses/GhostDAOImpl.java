/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses;

import com.mycompany.hauntedhauses.entity.Ghost;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Janicka
 */
public class GhostDAOImpl implements GhostDAO{
    
    private EntityManagerFactory entityManagerFactory;
    private EntityManager manager;
    
    public GhostDAOImpl(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
        manager = this.entityManagerFactory.createEntityManager();
    }

    public boolean addGhost(Ghost ghost) {
      
       try{
           manager.getTransaction().begin();
           manager.persist(ghost);
           manager.getTransaction().commit();
           
       }
       catch(Exception ex){
           throw new PersistenceException("Transaction failed.\n" + ex.getMessage(), ex);
           
       }
       
       return true;
    }

    public boolean updateGhost(Ghost ghost) {
        try{
            manager.getTransaction().begin();
            manager.merge(ghost);
            manager.getTransaction().commit();
        }
        catch (Exception ex){
            throw new PersistenceException("Transaction failed.\n" + ex.getMessage(),ex);
        }
        return true;
    }

    public boolean deleteGhost(Ghost ghost) {
        try{
            manager.getTransaction().begin();
            manager.remove(ghost);
            manager.getTransaction().commit();
        }
        catch(Exception ex){
            throw new PersistenceException("Transaction failed.\n"+ex.getMessage(), ex);
        }
        return true;
    }

    public List<Ghost> getAllGhosts() {
        Query query = manager.createQuery("select a from Ghost a");
        return query.getResultList();
        
           }

    public Ghost getGhostByID(long id) {
        return manager.find (Ghost.class, id);
            
        }
    
}
