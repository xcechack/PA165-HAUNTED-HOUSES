/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.dao;

import com.mycompany.hauntedhauses.service.House;
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
     * Deletes house from the database.
     * 
     * @param house The house to be deleted.
     */
    public void deleteHouse(House house);
    
    /**
     * Updates information about the given house in the database.
     * 
     * @param house The house to be updated.
     */
    public void updateHouse(House house);
    
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
    public House getHouseById(long id);
}
