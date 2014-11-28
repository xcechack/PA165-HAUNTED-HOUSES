package cz.muni.fi.pa165.hauntedhouses.dao.jpa;

import cz.muni.fi.pa165.hauntedhouses.dao.DAOBase;
import cz.muni.fi.pa165.hauntedhouses.dao.ResidentDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Resident;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
*
+ * @author Markéta Kružliaková
*
*/

public class ResidentDAOImpl extends DAOBase implements ResidentDAO {
   
   @Override
    public void addResident(Resident resident) {
        if (resident == null) {
            throw new IllegalArgumentException("resident is null");
        }
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(resident);
            getEntityManager().getTransaction().commit();
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
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(resident);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);
        }
    }

    @Override
    public void deleteResident(Resident resident) {
        try {
            getEntityManager().getTransaction().begin();
            Resident toBeRemoved = getEntityManager().merge(resident); 
            if (toBeRemoved != null) {
                getEntityManager().remove(toBeRemoved);
                getEntityManager().getTransaction().commit();
            }
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);
        }
    }


    @Override
    public List<Resident> getAllResidents() {
        Query query = getEntityManager().createQuery("SELECT r FROM Resident r");
        if(query==null){
            return new ArrayList<>();
        }
        else{
            return query.getResultList();
        }
    }

    @Override
    public Resident getResidentById(Long id) {
        return getEntityManager().find(Resident.class, id);
    }           

}
