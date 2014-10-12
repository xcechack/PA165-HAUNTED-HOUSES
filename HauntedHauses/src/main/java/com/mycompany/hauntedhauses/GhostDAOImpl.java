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

/**
 *
 * @author Janicka
 */
public class GhostDAOImpl implements GhostDAO{
    
    EntityManagerFactory entityManagerFactory;
    
    public GhostDAOImpl(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
    }

    public boolean addGhost(Ghost ghost) {
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       
       try{
           entityManager.getTransaction().begin();
           entityManager.persist(ghost);
           entityManager.getTransaction().commit();
           
       }
       catch(Exception ex){
           throw new PersistenceException("Transaction failed.\n" + ex.getMessage(), ex);
           
       }
       
       return true;
    }

    public boolean updateGhost(Ghost ghost) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean deleteGhost(Ghost ghost) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Ghost> getAllGhosts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Ghost getGhostByID(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
