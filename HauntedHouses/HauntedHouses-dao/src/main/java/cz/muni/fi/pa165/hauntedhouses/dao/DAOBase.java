package cz.muni.fi.pa165.hauntedhouses.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Jana Cechackova
 */
public class DAOBase {
    private EntityManager entityManager;
    
    @Transactional
    public EntityManager getEntityManager() {
        return entityManager;
    } 
     
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
   
}
