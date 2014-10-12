package com.mycompany.hauntedhauses.dao.jpa;

import com.mycompany.hauntedhauses.dao.ResidentDAO;
import com.mycompany.hauntedhauses.entity.Resident;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
*
+ * @author Markéta Kružliaková
*
*/

public class ResidentDAOImpl implements ResidentDAO {
   
    EntityManagerFactory entityManagerFactory;

    public ResidentDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void addResident(Resident resident) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(resident);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed." + e.getMessage(), e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    
    public void updateResident(Resident resident) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(resident);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed." + e.getMessage(), e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void deleteResident(Resident resident) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        if (entityManager.contains(resident) == true) {  
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(resident);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                throw new PersistenceException("Transaction failed." + e.getMessage(), e);
            } finally {
                    entityManager.close();
            }
        }
        else {
            System.out.println("Resident with ID:" +resident.getId() + "is not in the database.");
        }
    }


    public List<Resident> getAllResidents() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        List<Resident> residents;
         try {
                entityManager.getTransaction().begin();
                Query query = entityManager.createQuery("SELECT r FROM Resident r");
                residents = query.getResultList();
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                throw new PersistenceException("Transaction failed." + e.getMessage(), e);
            } finally {
                entityManager.close();
            }  
        return residents;
        
    }

    public Resident getResidentByID(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Resident r;
        
            try {
                entityManager.getTransaction().begin();
                r = entityManager.find(Resident.class, id);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                throw new PersistenceException("Transaction failed." + e.getMessage(), e);
            } finally {
                entityManager.close();
            }  
        return r;
    }           

}
