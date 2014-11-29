package cz.muni.fi.pa165.hauntedhouses.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author Jana Cechackova
 */
public class DAOBase {
    private EntityManager entityManager;
    
    public EntityManager getEntityManager() {
        if (entityManager==null) create();
        return entityManager;
    } 
     
    @PersistenceContext(unitName="HauntedHousesDB", type=PersistenceContextType.TRANSACTION)
//    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    private void create(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HauntedHousesDB");
        entityManager = emf.createEntityManager();
    }
    
}
