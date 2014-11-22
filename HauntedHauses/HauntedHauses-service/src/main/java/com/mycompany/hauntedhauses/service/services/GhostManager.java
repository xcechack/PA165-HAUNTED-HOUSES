/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.service.services;

import com.mycompany.hauntedhauses.dao.GhostDAO;
import com.mycompany.hauntedhauses.service.dto.GhostDTO;
import java.util.List;
import org.dozer.DozerBeanMapper;

/**
 *
 * @author Michal Zbranek
 */
public interface GhostManager {
  /**
     * Adds a new ghost into the database.
     *
     * @param ghostDTO to be inserted to the database
     */
    public void addGhost(GhostDTO ghostDTO);

    /**
     * Updates given ghost in the database.
     *
     * @param ghostDTO to be updated
     */
    public void updateGhost(GhostDTO ghostDTO);

    /**
     * Deletes given ghost from the database.
     *
     * @param ghostDTO to be deleted
     */
    public void deleteGhost(GhostDTO ghostDTO);

    /**
     * Returns all ghosts from the database.
     *
     * @return List of all ghosts in the database
     */
    public List<GhostDTO> getAllGhosts();

    /**
     * Returns a ghost with the given id from the database.
     *
     * @param id of ghost
     * @return ghost with the id from parameter
     */
    public GhostDTO getGhostByID(long id);
    
    public void setGhostDAO(GhostDAO ghostDAO);
    public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper);
    
}