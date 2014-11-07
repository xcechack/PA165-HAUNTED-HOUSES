/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hauntedhauses.service.services.jpa;

import com.mycompany.hauntedhauses.dao.GhostDAO;
import com.mycompany.hauntedhauses.entity.Ghost;
import com.mycompany.hauntedhauses.service.dto.GhostDTO;
import com.mycompany.hauntedhauses.service.dto.ResidentDTO;
import com.mycompany.hauntedhauses.service.services.GhostManager;
import java.util.List;
import javax.inject.Inject;
import org.dozer.DozerBeanMapper;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Michal Zbranek
 */
public class GhostManagerImpl implements GhostManager {
    
    GhostDAO ghostDAO;
    DozerBeanMapper dozerBeanMapper;
    
    @Override
    public void addGhost(GhostDTO ghostDTO) {
        
        Ghost ghost;
      
        ghost = dozerBeanMapper.map(ghostDTO, Ghost.class);
        
        try {
            ghostDAO.addGhost(ghost);
            ghostDTO.setId(ghost.getId());
        } catch (Exception ex){
            throw new DataAccessException("Exception on persistence layer: "+ ex.toString()) {};
        }
    }

    @Override
    public void updateGhost(GhostDTO ghostDTO) {
        
        Ghost ghost;
        
        ghost = dozerBeanMapper.map(ghostDTO, Ghost.class);
        
        try{
            ghostDAO.updateGhost(ghost);
        
        } catch (Exception ex){
            throw new DataAccessException("Exception on persistence layer: "+ ex.toString()) {};
        }
    }

    @Override
    public void deleteGhost(GhostDTO ghostDTO) {
        
        Ghost ghost;
        
        ghost = dozerBeanMapper.map(ghostDTO, Ghost.class);
         
        try {
            ghostDAO.deleteGhost(ghost);
        } catch (Exception ex){
            throw new DataAccessException("Exception on persistence layer: "+ ex.toString()) {};                
        }    
    }

    @Override
    public List<GhostDTO> getAllGhosts() {
        
        List <GhostDTO> ghostsDTO = null;
        List <Ghost> ghosts = null;
        
        try{
            ghosts = ghostDAO.getAllGhosts();             
        } catch (Exception ex){
            throw new DataAccessException("Exception on persistence layer: "+ ex.toString()) {};
        }
        if (ghosts != null) {
            for (Ghost ghost : ghosts) {
                GhostDTO ghostDTO = dozerBeanMapper.map(ghost, GhostDTO.class);
                ghostsDTO.add(ghostDTO);
            }
        }
        return ghostsDTO;
    }

    @Override
    public GhostDTO getGhostByID(long id) {
        
       Ghost ghost; 
       GhostDTO ghostDTO = null;
       
        try {
            ghost = ghostDAO.getGhostByID(id);               
         
            if (ghost != null) {
                ghostDTO = dozerBeanMapper.map(ghost, GhostDTO.class); 
            }
        } catch (Exception ex){
            throw new DataAccessException("Exception on persistence layer: "+ ex.toString()) {}; 
        } 
        return ghostDTO;
    }
    
    
    @Inject
    public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper){
        this.dozerBeanMapper = dozerBeanMapper;
    }
    
    public DozerBeanMapper getDozerBeanMapper(){
        return dozerBeanMapper;
    }
    
    public void setGhostDAO(GhostDAO ghostDAO){
        this.ghostDAO = ghostDAO;
    }
    
    public GhostDAO getGhostDAO(){
        return ghostDAO;
    }
    
}