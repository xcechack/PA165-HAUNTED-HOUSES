package cz.muni.fi.pa165.hauntedhouses.dao.jpa;

import cz.muni.fi.pa165.hauntedhouses.dao.PowerDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Power;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Michal Zbranek
 */
public class PowerDAOImpl implements PowerDAO{

    @PersistenceContext
    EntityManager entityManager;
    
    public EntityManager getEntityManager() {
        return entityManager;
    } 
     
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addPower(Power power) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(power);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);
        }
    }
    
    @Override
    public void updatePower(Power power) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(power);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);
        }
    }

    @Override
    public void deletePower(Power power) {
        try {
            entityManager.getTransaction().begin();
            Power toBeRemoved = entityManager.merge(power);
            if (toBeRemoved != null) {
                entityManager.remove(toBeRemoved);
                entityManager.getTransaction().commit();
            }
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);
        }
    }

    @Override
    public List<Power> getAllPowers() {
        Query query = entityManager.createQuery("SELECT p FROM Power p");
        return query.getResultList();
        
    }

    @Override
    public Power getPowerById(Long id) {
        return entityManager.find(Power.class, id);
    } 
}