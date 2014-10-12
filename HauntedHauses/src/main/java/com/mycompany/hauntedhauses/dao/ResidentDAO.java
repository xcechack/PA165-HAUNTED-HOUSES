package com.mycompany.hauntedhauses.dao;

import com.mycompany.hauntedhauses.entity.Resident;
import java.util.List;

/**
 *
 * @author Markéta Kružliaková
 */
public interface ResidentDAO {

    /**
     * Adds a new resident into the database.
     *
     * @param resident to be inserted to the database
     */
    public void addResident(Resident resident);

    /**
     * Updates given resident in the database.
     *
     * @param resident to be updated
     */
    public void updateResident(Resident resident);

    /**
     * Deletes given resident from the database.
     *
     * @param resident to be deleted
     */
    public void deleteResident(Resident resident);

    /**
     * Returns all residents from the database.
     *
     * @return List of all residents in the database
     */
    public List<Resident> getAllResidents();

    /**
     * Returns a resident with the given id from the database.
     *
     * @param id of resident
     * @return resident with the id from parame
     */
    public Resident getResidentByID(long id);

}
