package cz.muni.fi.pa165.hauntedhouses.dao;

import cz.muni.fi.pa165.hauntedhouses.entity.Resident;
import java.util.List;

/**
 *
 * @author Markéta Kružliaková
 */
public interface ResidentDAO {


    /**
     * Adds a new resident into the database.
     *
     * @param resident the resident to be added into the database
     */
    public void addResident(Resident resident);

    /**
     * Updates given resident in the database.
     *
     * @param resident the resident to be updated
     */
    public void updateResident(Resident resident);

    /**
     * Deletes given resident from the database.
     *
     * @param resident the resident to be deleted
     */
    public void deleteResident(Resident resident);

    /**
     * Returns all residents from the database.
     *
     * @return the list of all residents
     */
    public List<Resident> getAllResidents();

    /**
     * Returns a resident with the given id from the database.
     *
     * @param id the id of resident that is returned
     * @return the found entity instance or null if the entity does not exist.
     */
    public Resident getResidentById(Long id);
}

