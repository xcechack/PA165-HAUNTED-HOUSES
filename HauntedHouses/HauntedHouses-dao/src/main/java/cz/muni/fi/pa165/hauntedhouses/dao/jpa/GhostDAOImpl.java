package cz.muni.fi.pa165.hauntedhouses.dao.jpa;

import cz.muni.fi.pa165.hauntedhouses.dao.GhostDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Ghost;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Janicka
 */
public class GhostDAOImpl implements GhostDAO{
    
    @PersistenceContext
    private EntityManager entityManager;
        
    public EntityManager getEntityManager() {
        return entityManager;
    } 
     
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addGhost(Ghost ghost) {
      
       try {
           entityManager.getTransaction().begin();
           entityManager.persist(ghost);
           entityManager.getTransaction().commit();     
       }
       catch(Exception e){
           throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);   
       }
    }

    @Override
    public void updateGhost(Ghost ghost) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(ghost);
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(),e);
        }
    }

    @Override
    public void deleteGhost(Ghost ghost) {
        try {
            entityManager.getTransaction().begin();
            Ghost toBeRemoved = entityManager.merge(ghost); 
            if (toBeRemoved != null) {
                entityManager.remove(toBeRemoved);
                entityManager.getTransaction().commit();
            }
        }
        catch(Exception e){
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);
        }
    }

    @Override
    public List<Ghost> getAllGhosts() {
        Query query = entityManager.createQuery("SELECT g FROM Ghost g");
        return query.getResultList();
    }

    @Override
    public Ghost getGhostById(Long id) {
        return entityManager.find(Ghost.class, id);       
    }
    
}
