package cz.muni.fi.pa165.hauntedhouses.dao.jpa;

import cz.muni.fi.pa165.hauntedhouses.dao.DAOBase;
import cz.muni.fi.pa165.hauntedhouses.entity.House;
import cz.muni.fi.pa165.hauntedhouses.dao.HouseDAO;
import cz.muni.fi.pa165.hauntedhouses.entity.Ghost;
import cz.muni.fi.pa165.hauntedhouses.entity.Resident;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author Gabriela Podolnikova
 */
public class HouseDAOImpl extends DAOBase implements HouseDAO{
     
    @Override
    @Transactional
    public void addHouse(House house){
        if (house == null) {
            throw new IllegalArgumentException("house is null");
        }
        try {
            getEntityManager().persist(house);
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed. \n" + e.getMessage(), e);
        }
    }
    
    @Override
    @Transactional
    public void deleteHouse(House house) {
        try {
            House toBeRemoved = getEntityManager().merge(house);
            if (toBeRemoved != null) {
                getEntityManager().remove(toBeRemoved);
            }
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed. \n" + e.getMessage(), e);
        }
    }
    
    @Override
    @Transactional
    public void updateHouse(House house) {
        if (house.getId() == null) {
            throw new IllegalArgumentException("House id is null!");
        }
        try {
            getEntityManager().merge(house);
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed. \n" + e.getMessage(), e);
        }    
    }
    
    @Override
    @Transactional
    public List<House> getAllHouses() {
        Query query = getEntityManager().createQuery("SELECT r FROM House r");
        List<House> allHouses = query.getResultList();
        if(allHouses==null){
            return new ArrayList<>();
        }
        else{
            return allHouses;
        }
    }
    
    @Override
    @Transactional
    public House getHouseById(Long id) {
        return getEntityManager().find(House.class, id);
    }

}

