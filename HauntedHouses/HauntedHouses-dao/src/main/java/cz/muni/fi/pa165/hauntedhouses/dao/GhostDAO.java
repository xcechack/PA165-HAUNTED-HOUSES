package cz.muni.fi.pa165.hauntedhouses.dao;

import cz.muni.fi.pa165.hauntedhouses.entity.Ghost;
import java.util.List;

/**
 *
 * @author Jana Cechackova
 */
public interface GhostDAO {

    /**
     * This method adds new ghost into the database.
     * 
     * @param ghost the ghost to be added into the database
     */
    public void addGhost(Ghost ghost);

    /**
     * Updates information about the given house in the database.
     * 
     * @param ghost the ghost to be updated
     */
    public void updateGhost(Ghost ghost);

    /**
     * Deletes ghost from the database.
     * 
     * @param ghost the ghost to be deleted
     */
    public void deleteGhost(Ghost ghost);

    /**
     * Gives all ghosts stored in the database.
     * 
     * @return the list of all ghosts
     */
    public List<Ghost> getAllGhosts();

    /**
     * Gives the ghost with the given id from the database.
     * 
     * @param id the id of ghost that is returned
     * @return the found entity instance or null if the entity does not exist
     */
    public Ghost getGhostById(Long id);
}
