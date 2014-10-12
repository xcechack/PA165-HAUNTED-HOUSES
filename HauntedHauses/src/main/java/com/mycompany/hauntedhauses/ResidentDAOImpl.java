package com.mycompany.hauntedhauses;

import com.mycompany.hauntedhauses.entity.Resident;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;

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

        } catch (Exception ex) {
            throw new PersistenceException("Transaction failed." + ex.getMessage(), ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    
    public void updateResident(Resident resident) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteResident(Resident resident) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Resident> getAllResidents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Resident getResidentByID(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    
}
