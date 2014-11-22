package cz.muni.fi.pa165.hauntedhouses.dao.jpa;

import cz.muni.fi.pa165.hauntedhouses.entity.House;
import cz.muni.fi.pa165.hauntedhouses.dao.HouseDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Gabriela Podolnikova
 */
public class HouseDAOImpl implements HouseDAO{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    
    public EntityManager getEntityManager() {
        return entityManager;
    } 
     
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
  
    @Override
    public void addHouse(House house){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(house);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed. \n" + e.getMessage(), e);
        }
    }
    
    @Override
    public void deleteHouse(House house) {
        try {
            entityManager.getTransaction().begin();
            House toBeRemoved = entityManager.merge(house);
            if (toBeRemoved != null) {
                entityManager.remove(toBeRemoved);
                entityManager.getTransaction().commit();
            }
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed. \n" + e.getMessage(), e);
        }
    }
    
    @Override
    public void updateHouse(House house) {

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(house);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed. \n" + e.getMessage(), e);
        }    
    }
    
    @Override
    public List<House> getAllHouses() {
        Query query = entityManager.createQuery("select h from House h");
        return query.getResultList();
    }
    
    @Override
    public House getHouseById(Long id) {
        return entityManager.find(House.class, id);
    }
}

