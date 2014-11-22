package cz.muni.fi.pa165.hauntedhouses.dao;

import cz.muni.fi.pa165.hauntedhouses.entity.House;
import java.util.List;

/**
 *
 * @author Gabriela Podolnikova
 */
public interface HouseDAO {
    
    /**
     * This method adds new house into the database.
     * 
     * @param house The house to be added into the database.
     */
    public void addHouse(House house);
    
    /**
     * Updates information about the given house in the database.
     * 
     * @param house The house to be updated.
     */
    public void updateHouse(House house);
    
    /**
     * Deletes house from the database.
     * 
     * @param house The house to be deleted.
     */
    public void deleteHouse(House house);
    
    /**
     * Gives all houses stored in the database.
     * 
     * @return the list of all houses.
     */
    public List<House> getAllHouses();
    
    /**
     * Gives the house with the given id from the database.
     * 
     * @param id The id of house that is returned.
     * @return the found entity instance or null if the entity does not exist.
     */
    public House getHouseById(Long id);
}
