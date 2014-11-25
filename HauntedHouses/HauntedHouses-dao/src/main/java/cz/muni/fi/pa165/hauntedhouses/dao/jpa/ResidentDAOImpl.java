package cz.muni.fi.pa165.hauntedhouses.dao.jpa;

import cz.muni.fi.pa165.hauntedhouses.dao.ResidentDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Resident;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
*
+ * @author Markéta Kružliaková
*
*/

public class ResidentDAOImpl implements ResidentDAO {
   
    @PersistenceContext
    private EntityManager entityManager;
    
    public EntityManager getEntityManager() {
        return entityManager;
    } 
     
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addResident(Resident resident) {
        if (resident == null) {
            throw new IllegalArgumentException("resident is null");
        }
        if (resident.getId() != null) {
            throw new IllegalArgumentException("resident id is already set");
        }
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(resident);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);
        }
    }
    
    @Override
    public void updateResident(Resident resident) {
        if (resident.getId() == null) {
            throw new IllegalArgumentException("Resident id is null!");
        }
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(resident);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);
        }
    }

    @Override
    public void deleteResident(Resident resident) {
        try {
            entityManager.getTransaction().begin();
            Resident toBeRemoved = entityManager.merge(resident); 
            if (toBeRemoved != null) {
                entityManager.remove(toBeRemoved);
                entityManager.getTransaction().commit();
            }
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);
        }
    }


    @Override
    public List<Resident> getAllResidents() {
        Query query = entityManager.createQuery("SELECT r FROM Resident r");
        if(query==null){
            return new ArrayList<>();
        }
        else{
            return query.getResultList();
        }
    }

    @Override
    public Resident getResidentById(Long id) {
        return entityManager.find(Resident.class, id);
    }           

}
