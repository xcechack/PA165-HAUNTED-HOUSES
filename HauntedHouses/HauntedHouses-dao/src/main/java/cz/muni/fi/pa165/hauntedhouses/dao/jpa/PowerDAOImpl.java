package cz.muni.fi.pa165.hauntedhouses.dao.jpa;

import cz.muni.fi.pa165.hauntedhouses.dao.DAOBase;
import cz.muni.fi.pa165.hauntedhouses.dao.PowerDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Power;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Michal Zbranek
 */
public class PowerDAOImpl extends DAOBase implements PowerDAO{

    @Override
    public void addPower(Power power) {
        if (power == null) {
            throw new IllegalArgumentException("power is null");
        }
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(power);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);
        }
    }
    
    @Override
    public void updatePower(Power power) {
        if (power.getId() == null) {
            throw new IllegalArgumentException("Power id is null!");
        }
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(power);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);
        }
    }

    @Override
    public void deletePower(Power power) {
        try {
           getEntityManager().getTransaction().begin();
            Power toBeRemoved = getEntityManager().merge(power);
            if (toBeRemoved != null) {
                getEntityManager().remove(toBeRemoved);
                getEntityManager().getTransaction().commit();
            }
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed.\n" + e.getMessage(), e);
        }
    }

    @Override
    public List<Power> getAllPowers() {
        Query query = getEntityManager().createQuery("SELECT p FROM Power p");
        if(query==null){
            return new ArrayList<>();
        }
        else{
            return query.getResultList();
        }
        
    }

    @Override
    public Power getPowerById(Long id) {
        return getEntityManager().find(Power.class, id);
    } 
}