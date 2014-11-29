package cz.muni.fi.pa165.hauntedhouses.dao.jpa;

import cz.muni.fi.pa165.hauntedhouses.dao.DAOBase;
import cz.muni.fi.pa165.hauntedhouses.entity.House;
import cz.muni.fi.pa165.hauntedhouses.dao.HouseDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Gabriela Podolnikova
 */
public class HouseDAOImpl extends DAOBase implements HouseDAO{
     
    @Override
    public void addHouse(House house){
        if (house == null) {
            throw new IllegalArgumentException("house is null");
        }
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(house);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed. \n" + e.getMessage(), e);
        }
    }
    
    @Override
    public void deleteHouse(House house) {
        try {
            getEntityManager().getTransaction().begin();
            House toBeRemoved = getEntityManager().merge(house);
            if (toBeRemoved != null) {
                getEntityManager().remove(toBeRemoved);
                getEntityManager().getTransaction().commit();
            }
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed. \n" + e.getMessage(), e);
        }
    }
    
    @Override
    public void updateHouse(House house) {
        if (house.getId() == null) {
            throw new IllegalArgumentException("House id is null!");
        }
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(house);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenceException("Transaction failed. \n" + e.getMessage(), e);
        }    
    }
    
    @Override
    public List<House> getAllHouses() {
        Query query = getEntityManager().createQuery("select h from House h");
        if(query==null){
            return new ArrayList<>();
        }
        else{
            return query.getResultList();
        }
    }
    
    @Override
    public House getHouseById(Long id) {
        return getEntityManager().find(House.class, id);
    }
}

