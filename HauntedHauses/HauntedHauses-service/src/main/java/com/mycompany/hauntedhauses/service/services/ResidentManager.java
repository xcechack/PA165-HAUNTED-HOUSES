/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.service.services;

import com.mycompany.hauntedhauses.service.dto.ResidentDTO;
import java.util.List;

/**
 *
 * @author Markéta Kružliaková
 */
public interface ResidentManager {
    
    /**
     * Adds a new resident into the database.
     *
     * @param resident to be inserted to the database
     */
    public void addResident(ResidentDTO residentDTO);

    /**
     * Updates given resident in the database.
     *
     * @param resident to be updated
     */
    public void updateResident(ResidentDTO residentDTO);

    /**
     * Deletes given resident from the database.
     *
     * @param resident to be deleted
     */
    public void deleteResident(ResidentDTO residentDTO);

    /**
     * Returns all residents from the database.
     *
     * @return List of all residents in the database
     */
    public List<ResidentDTO> getAllResidents();

    /**
     * Returns a resident with the given id from the database.
     *
     * @param id of resident
     * @return resident with the id from parame
     */
    public ResidentDTO getResidentByID(long id);
    
}
