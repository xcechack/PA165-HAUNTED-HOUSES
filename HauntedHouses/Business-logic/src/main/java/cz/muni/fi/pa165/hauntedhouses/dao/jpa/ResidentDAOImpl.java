package cz.muni.fi.pa165.hauntedhouses.dao.jpa;

import cz.muni.fi.pa165.hauntedhouses.dao.DAOBase;
import cz.muni.fi.pa165.hauntedhouses.dao.ResidentDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Resident;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
*
+ * @author Markéta Kružliaková
*
*/

public class ResidentDAOImpl extends DAOBase implements ResidentDAO {
   
   @Override
   @Transactional
    public void addResident(Resident resident) {
        if (resident == null) {
            throw new IllegalArgumentException("resident is null");
        }
        try {
            getEntityManager().persist(resident);
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);
        }
    }
    
    @Override
    @Transactional
    public void updateResident(Resident resident) {
        if (resident.getId() == null) {
            throw new IllegalArgumentException("Resident id is null!");
        }
        try {
            getEntityManager().merge(resident);
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public void deleteResident(Resident resident) {
        try {;
            Resident toBeRemoved = getEntityManager().merge(resident); 
            if (toBeRemoved != null) {
                getEntityManager().remove(toBeRemoved);
            }
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);
        }
    }


    @Override
    @Transactional
    public List<Resident> getAllResidents() {
        Query query = getEntityManager().createQuery("SELECT r FROM Resident r");
        List<Resident> allResidents = query.getResultList();
        if(allResidents==null){
            return new ArrayList<>();
        }
        else{
            return allResidents;
        }
    }

    @Override
    @Transactional
    public Resident getResidentById(Long id) {
        return getEntityManager().find(Resident.class, id);
    }           

}
