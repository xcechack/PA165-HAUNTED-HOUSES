/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.hauntedhouses.dao;

import cz.muni.fi.pa165.hauntedhouses.entity.Power;
import java.util.List;

/**
 *
 * @author Michal Zbranek
 */
public interface PowerDAO {
    
   /**
    * This method adds new power into the database.
    * 
    * @param power The power to be added into the database.
    */ 
   public void addPower(Power power);
   
   /**
     * Deletes power from the database.
     * 
     * @param power The power to be deleted.
     */
   public void updatePower(Power power);
   
   /**
     * Updates information about the given power in the database.
     * 
     * @param power The power to be updated.
     */
   public void deletePower(Power power);
   
   /**
     * Gives all powers stored in the database.
     * 
     * @return the list of all powers.
     */
   public List<Power> getAllPowers();
   
   /**
     * Gives the power with the given id from the database.
     * 
     * @param id The id of power that is returned.
     * @return the power with the given id.
     */
   public Power getPowerById(Long id );
}
